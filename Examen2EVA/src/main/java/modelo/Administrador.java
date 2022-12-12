package modelo;

public class Administrador extends Persona {

    private final int sueldo;
    private final String tarea;

    public Administrador(String dni, String nombre, int sueldo, String tarea) {
        super(dni, nombre);
        this.sueldo = sueldo;
        this.tarea = tarea;
    }

}
