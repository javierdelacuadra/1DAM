package main;

import videoclub.dao.modelo.*;
import videoclub.servicios.ServiciosVideoclub;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsVideoClub {
    ServiciosVideoclub sv = new ServiciosVideoclub();
    List<Socio> socios = sv.getTodosLosSocios();
    List<Producto> productos = sv.getTodosProductos();
    List<Pelicula> peliculas = sv.getTodasPeliculas();
    List<Videojuego> videojuegos = sv.getTodosVideoJuegos();
    List<Alquiler> alquileres = sv.getTodosAlquileres();

    /**
     * FACIL
     **/
    public void numeroSociosSancionados() {
        System.out.println(socios.stream().filter(Socio::isSancionado).count());
    }

    public void mediaEdadDeSociosSancionados() {
        System.out.println(socios.stream()
                .filter(Socio::isSancionado)
                .flatMapToInt(socio -> IntStream.of(socio.getEdad())).average());
    }

    /**
     * DIFICIL
     **/
    public void listaDiezProductosMasAlquilados() {
        System.out.println(productos.stream()
                .sorted(Comparator.comparingInt(Producto::getCantidadAlquilada).reversed())
                .limit(10)
                .collect(Collectors.toUnmodifiableList()));

        System.out.println(alquileres.stream().map(Alquiler::getProductoAlquilado).sorted(Comparator.comparingInt(Producto::getCantidadAlquilada).reversed()).limit(10).collect(Collectors.toUnmodifiableList()));
    }

    // numero de Peliculas Alquiladas, de Documentales y Videojuegos.
    public void numeroProductosAlquiladosPorTipo() {

    }

    public void todosLosActoresDistintosDeTodasLasPeliculas() {
        System.out.println(peliculas.stream()
                .flatMap(pelicula -> pelicula.getActores()
                        .stream()
                        .distinct())
                .collect(Collectors.toUnmodifiableList()));
    }

    public void peliculaConMasActores() {
        peliculas.stream().mapToInt(value -> value.getActores().size()).max();
    }


    //el listado de productos ordenados de mayor a menor según su valoración media.
    public void productoConSuValoracionMediaOrdenadosDeMayoraMenor() {
        System.out.println(productos.stream()
                .sorted(Comparator.comparingDouble(Producto::getValoracionMedia).reversed())
                .collect(Collectors.toUnmodifiableList()));
    }

    public void las10PeliculasMejorValoradas() {
        System.out.println(productos.stream().
                sorted(Comparator.comparingDouble(Producto::getValoracionMedia).reversed())
                .limit(10)
                .collect(Collectors.toUnmodifiableList()));
    }

    public void los10VideoJuegosMejorValoradas() {
        System.out.println(videojuegos.stream().
                sorted(Comparator.comparingDouble(Videojuego::getValoracionMedia).reversed())
                .limit(10)
                .collect(Collectors.toUnmodifiableList()));
    }


    // el numero de DVD y Videos que hay.
    public void numeroDocumentalesyPeliculasSegunSuFormato() {
        System.out.println(productos.stream().filter(producto -> producto instanceof Documental).distinct().count());
    }

    // conseguir un String con todos los faricantes distintos de videojuegos separados por ,
    public void todosLosFabricantesDistintosDeVideoJuegosEnUnSoloString() {
        StringBuilder sb = new StringBuilder();
        videojuegos.forEach(videojuego -> sb.append(videojuego.getFabricante()).append(","));
        System.out.println(sb);
    }
}