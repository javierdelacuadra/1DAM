package ui;

import jakarta.inject.Inject;
import modelo.*;
import servicios.ServiciosClientes;
import servicios.ServiciosCompras;
import servicios.ServiciosMonedero;
import ui.common.ConstantesAdmin;
import ui.common.ConstantesClientes;
import ui.common.ConstantesGestionClientes;

import java.util.Scanner;

public class UICliente {

    private final ServiciosClientes sclientes;
    private final ServiciosCompras scompras;
    private final ServiciosMonedero sm;
    private final Scanner sc;

    @Inject
    public UICliente(ServiciosClientes sclientes, ServiciosCompras scompras, ServiciosMonedero sm, Scanner sc) {
        this.sclientes = sclientes;
        this.scompras = scompras;
        this.sm = sm;
        this.sc = sc;
    }

    public void menuCliente(String dni) {
        int numero;
        do {
            System.out.println(ConstantesClientes.BIENVENIDO_A_LA_INTERFAZ_DE_CLIENTES);
            System.out.println(ConstantesAdmin.MENU_CLIENTE);
            numero = sc.nextInt();
            sc.nextLine();
            switch (numero) {
                case 1:
                    modificarNombre(dni);
                    break;
                case 2:
                    modificarDNI(dni);
                    break;
                case 3:
                    gestionMonederos(dni);
                    break;
                case 4:
                    menuCompras(dni);
                    break;
                case 5:
                    otrasOpciones(dni);
                    break;
                default:
                    if (numero == 6) {
                        System.out.println(ConstantesAdmin.SALIR_DEL_PROGRAMA);
                    } else System.out.println(ConstantesAdmin.NÚMERO_INCORRECTO);
            }
        } while (numero != 6);
    }

    private void modificarNombre(String dni) {
        System.out.println(ConstantesClientes.ESCRIBE_TU_NUEVO_NOMBRE);
        String nombre = sc.nextLine();
        ClienteNormal c = new ClienteNormal(dni, nombre);
        if (sclientes.modificarNombre(c)) {
            System.out.println(ConstantesGestionClientes.NOMBRE_CAMBIADO);
        } else {
            System.out.println(ConstantesGestionClientes.NO_SE_HAN_PODIDO_MODIFICAR_LOS_DATOS);
        }
    }

    private void modificarDNI(String dni) {
        System.out.println(ConstantesClientes.ESCRIBE_EL_NUEVO_DNI);
        String nuevoDNI = sc.nextLine();
        ClienteNormal c = new ClienteNormal(nuevoDNI);
        ClienteNormal cviejo = new ClienteNormal(dni);
        if (sclientes.modificarDNI(c, cviejo)) {
            System.out.println(ConstantesGestionClientes.DNI_CAMBIADO);
        } else {
            System.out.println(ConstantesGestionClientes.NO_SE_HAN_PODIDO_MODIFICAR_LOS_DATOS);
        }
    }

    public void menuCompras(String dni) {
        int opcion;
        do {
            System.out.println(ConstantesClientes.INTERFAZ_DE_COMPRAS);
            System.out.println(ConstantesClientes.MENU_COMPRAS);
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    addProducto(dni);
                    break;
                case 2:
                    System.out.println(scompras.verProductos());
                    break;
                case 3:
                    System.out.println(scompras.verCarrito(dni));
                    break;
                case 4:
                    pagar(dni);
                    break;
                default:
                    if (opcion == 5) {
                        System.out.println(ConstantesAdmin.SALIR_DEL_PROGRAMA);
                    } else System.out.println(ConstantesAdmin.NÚMERO_INCORRECTO);
            }
        } while (opcion != 5);
    }

    private void addProducto(String dni) {
        System.out.println(ConstantesClientes.ELIGE_EL_PRODUCTO_QUE_QUIERAS_AÑADIR_AL_CARRITO);
        String nombreProducto = sc.nextLine();
        System.out.println(ConstantesClientes.ELIGE_LA_CANTIDAD_DEL_PRODUCTO_QUE_QUIERAS_AÑADIR);
        int cantidad = sc.nextInt();
        sc.nextLine();
        Producto p = new ProductoNormal(nombreProducto, cantidad);
        if (scompras.addProducto(p, dni)) {
            System.out.println(ConstantesClientes.PRODUCTO_AÑADIDO_A_LA_CESTA);
        } else {
            System.out.println(ConstantesClientes.PRODUCTO_NO_AÑADIDO);
        }
    }

    private void pagar(String dni) {
        System.out.println(ConstantesClientes.ELIGE_EL_MONEDERO_CON_EL_QUE_VAS_A_PAGAR);
        System.out.println(sm.verMonederos(dni));
        String nombreMonedero = sc.nextLine();
        if (scompras.pagar(nombreMonedero, dni)) {
            System.out.println(ConstantesClientes.PAGO_REALIZADO_CORRECTAMENTE);
        } else {
            System.out.println(ConstantesClientes.NO_SE_PUDO_REALIZAR_EL_PAGO);
        }
    }

    public void gestionMonederos(String dni) {
        int opcion;
        do {
            System.out.println(ConstantesClientes.INTERFAZ_DE_GESTIÓN_DE_MONEDEROS);
            System.out.println(ConstantesClientes.MENU_MONEDEROS);
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    addMonedero(dni);
                    break;
                case 2:
                    addSaldo(dni);
                    break;
                case 3:
                    System.out.println(sm.verMonederos(dni));
                    break;
                default:
                    if (opcion == 4) {
                        System.out.println(ConstantesAdmin.SALIR_DEL_PROGRAMA);
                    } else System.out.println(ConstantesAdmin.NÚMERO_INCORRECTO);
            }
        } while (opcion != 4);
    }

    private void addMonedero(String dni) {
        System.out.println(ConstantesClientes.ESCRIBE_EL_NOMBRE_DEL_MONEDERO);
        String nombreMonedero = sc.nextLine();
        System.out.println(ConstantesClientes.ESCRIBE_LA_CANTIDAD_DE_SALDO_INICIAL_DEL_MONEDERO);
        double cantidad = sc.nextDouble();
        sc.nextLine();
        Monedero m = new Monedero(nombreMonedero, cantidad);
        if (sm.addMonedero(dni, m)) {
            System.out.println(ConstantesClientes.MONEDERO_CREADO_CORRECTAMENTE);
        } else {
            System.out.println(ConstantesClientes.NO_SE_HA_PODIDO_CREAR_EL_MONEDERO);
        }
    }

    private void addSaldo(String dni) {
        System.out.println(ConstantesClientes.ESCRIBE_EL_NOMBRE_DEL_MONEDERO);
        System.out.println(sm.verMonederos(dni));
        String nombreMonedero = sc.nextLine();
        System.out.println(ConstantesClientes.ESCRIBE_LA_CANTIDAD_DE_SALDO_A_AÑADIR);
        double cantidad = sc.nextDouble();
        sc.nextLine();
        Monedero m = new Monedero(nombreMonedero, cantidad);
        if (sm.addSaldo(dni, m)) {
            System.out.println(ConstantesClientes.SALDO_AÑADIDO_CORRECTAMENTE);
        } else {
            System.out.println(ConstantesClientes.NO_SE_HA_PODIDO_AÑADIR_SALDO);
        }
    }

    public void otrasOpciones(String dni) {
        int opcion;
        do {
            System.out.println(ConstantesClientes.MENU_CLIENTE_OPCIONES_EXTRA);
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println(sclientes.verComprasAntiguas(dni));
                    break;
                case 2:
                    System.out.println(sclientes.gastoTotalCliente(dni));
                    break;
                case 3:
                    addAlergeno(dni);
                    break;
                case 4:
                    System.out.println(ConstantesClientes.PERRO);
                    break;
                default:
                    if (opcion == 5) {
                        System.out.println(ConstantesAdmin.SALIR_DEL_PROGRAMA);
                    } else System.out.println(ConstantesAdmin.NÚMERO_INCORRECTO);
            }
        } while (opcion != 5);
    }

    private void addAlergeno(String dni) {
        System.out.println(ConstantesClientes.ESCRIBE_EL_INGREDIENTE_AL_QUE_ERES_ALÉRGICO);
        String nombre = sc.nextLine();
        Ingrediente i = new Ingrediente(nombre);
        if (sclientes.addAlergeno(dni, i)) {
            System.out.println(ConstantesClientes.ALERGENO_AÑADIDO_CORRECTAMENTE);
        } else System.out.println(ConstantesClientes.NO_SE_HA_PODIDO_AÑADIR_EL_ALÉRGENO);
    }
}