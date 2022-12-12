package data.impl;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import modelo.Cliente;
import modelo.ClienteNormal;
import modelo.Producto;
import modelo.ProductoNormal;
import nl.altindag.log.LogCaptor;
import nl.altindag.log.model.LogEvent;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(MockitoExtension.class)
class DatabaseTest {

    private Database db;

    private static SeContainer container;

    @BeforeAll
    static void beforeAll() {
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        container = initializer.initialize();
    }

    @BeforeEach
    void setUp() {
        try {
            Files.delete(Paths.get("src/test/java/dataTests/testClientes.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.delete(Paths.get("src/test/java/dataTests/testProductos.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        db = container.select(Database.class).get();
    }

    @AfterAll
    static void afterAll() {
        container.close();
    }

    @Test
    @DisplayName("Cargar productos correctamente")
    void loadProductos() {
        //given
        List<Producto> productos;
        try {
            Files.copy(Paths.get("data/productos.json"), Paths.get("src/test/java/dataTests/testProductos.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //when
        productos = db.loadProductos();

        //then
        assertAll(
                () -> assertThat(productos).isNotNull(),
                () -> assertThat(productos).isNotEmpty(),
                () -> assertThat(productos.size()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("Cargar productos cuando no existe el archivo")
    void loadProductosNoHayFichero() {
        //given
        LogCaptor logcaptor = LogCaptor.forClass(Database.class);

        //when
        db.loadProductos();

        //then
        List<LogEvent> events = logcaptor.getLogEvents();

        LogEvent event = events.get(0);
        assertAll(
                () -> assertThat(events).hasSize(1),
                () -> assertThat(event.getLevel()).isEqualTo("ERROR"),
                () -> assertThat(event.getThrowable().get()).isInstanceOf(IOException.class)
        );
    }

    @Test
    @DisplayName("Guardar productos correctamente")
    void saveProductos() {
        //given
        Producto p = new ProductoNormal("Pan", 1.99, 5);
        Producto p1 = new ProductoNormal("Leche", 2.99, 5);
        List<Producto> productos = new ArrayList<>();
        productos.add(p);
        productos.add(p1);

        //when
        boolean resultado = db.saveProductos(productos);

        //then

        assertAll(
                () -> assertThat(resultado).isTrue(),
                () -> assertThat(productos.size()).isEqualTo(2)
        );
    }

    @Test
    @DisplayName("Cargar clientes correctamente")
    void loadClientes() {
        Map<String, Cliente> clientes;
        try {
            Files.copy(Paths.get("data/clientes.json"), Paths.get("src/test/java/dataTests/testClientes.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //when
        clientes = db.loadClientes();

        //then
        assertAll(
                () -> assertThat(clientes).isNotNull(),
                () -> assertThat(clientes).isNotEmpty(),
                () -> assertThat(clientes.size()).isEqualTo(2)
        );
    }

    /*
    @Test
    @DisplayName("No hay fichero al cargar clientes")
    void loadClientesNoHayFichero() {
        //given
        LogCaptor logcaptor = LogCaptor.forClass(Database.class);

        //when
        db.loadClientes();

        //then
        List<LogEvent> events = logcaptor.getLogEvents();

        LogEvent event = events.get(0);
        assertAll(
                () -> assertThat(events).hasSize(1),
                () -> assertThat(event.getLevel()).isEqualTo("ERROR"),
                () -> assertThat(event.getThrowable().get()).isInstanceOf(IOException.class)
        );
    }*/

    @Test
    @DisplayName("Guardar clientes correctamente")
    void saveClientes() {
        //given
        Cliente c = new ClienteNormal("100", "Pedro");
        Cliente c1 = new ClienteNormal("101", "Juan");
        Map<String, Cliente> clientes = new HashMap<>();
        clientes.put(c.getDni(), c);
        clientes.put(c1.getDni(), c1);

        //when
        boolean resultado = db.saveClientes(clientes);

        //then
        assertAll(
                () -> assertThat(resultado).isTrue(),
                () -> assertThat(clientes.values()).hasSize(2)
        );
    }
}