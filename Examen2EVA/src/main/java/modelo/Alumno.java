package modelo;

import java.util.List;

public class Alumno extends Persona {

    private int dinero;
    private final List<Asignatura> asignaturas;

    public Alumno(String dni, String nombre, List<Asignatura> asignaturas, int dinero) {
        super(dni, nombre);
        this.asignaturas = asignaturas;
        this.dinero = dinero;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
}