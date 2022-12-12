package ui;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.inject.Inject;
import modelo.Cliente;
import modelo.ClienteNormal;
import servicios.ServiciosClientes;
import ui.common.ConstantesAdmin;
import ui.common.ConstantesClientes;

import java.util.Scanner;

public class Main {

    private final Scanner sc;
    private final ServiciosClientes sclientes;
    private final UIGestionProductos adminUI;
    private final UIGestionCliente uiGestionCliente;
    private final UICliente clienteUI;

    @Inject
    public Main(Scanner sc, ServiciosClientes sclientes, UIGestionProductos adminUI, UIGestionCliente uiGestionCliente, UICliente clienteUI) {
        this.sc = sc;
        this.sclientes = sclientes;
        this.adminUI = adminUI;
        this.uiGestionCliente = uiGestionCliente;
        this.clienteUI = clienteUI;
    }

    public void menu() {

        int opcion;
        do {
            System.out.println(ConstantesAdmin.MENU_INICIAL);
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    inicioSesion();
                    break;
                case 2:
                    registroClientes();
                    break;
                default:
                    if (opcion == 3) {
                        System.out.println(ConstantesAdmin.SALIR_DEL_PROGRAMA);
                    } else System.out.println(ConstantesAdmin.NÚMERO_INCORRECTO);
            }
        } while (opcion != 3);
    }

    private void inicioSesion() {

        System.out.println(ConstantesAdmin.INTRODUZCA_NOMBRE_DE_USUARIO);
        String nombreUsuario = sc.nextLine();
        if (nombreUsuario.equalsIgnoreCase(ConstantesAdmin.ADMIN)) {
            System.out.println(ConstantesAdmin.MENU_ADMIN);
            int opcion = sc.nextInt();
            sc.nextLine();
            if (opcion == 1) {
                adminUI.menuAdmin();
            } else if (opcion == 2) {
                uiGestionCliente.menuClientes();
            }
        } else {
            //cliente
            System.out.println(ConstantesAdmin.INTRODUCE_TU_DNI);
            String dni = sc.nextLine();
            Cliente c = new ClienteNormal(dni);
            if (sclientes.inicioSesion(c)) {
                clienteUI.menuCliente(dni);
            } else {
                System.out.println(ConstantesClientes.DNI_INCORRECTO);
            }
        }
    }

    private void registroClientes() {
        System.out.println(ConstantesAdmin.INTRODUZCA_NOMBRE_DE_USUARIO);
        String nombreUsuario = sc.nextLine();
        System.out.println(ConstantesAdmin.INTRODUCE_TU_DNI);
        String dni = sc.nextLine();
        ClienteNormal c = new ClienteNormal(dni, nombreUsuario);
        if (sclientes.registrarCliente(c)) {
            System.out.println(ConstantesAdmin.CLIENTE_REGISTRADO);
        } else {
            System.out.println(ConstantesClientes.CLIENTE_NO_REGISTRADO);
        }
    }
}