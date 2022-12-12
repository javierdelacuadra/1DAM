package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profesor extends Persona {

    private int sueldo;
    private int experienciaAnual;
    private final List<Asignatura> asignaturas;

    public Profesor(String dni, String nombre, int sueldo, int experienciaAnual, List<Asignatura> asignaturas) {
        super(dni, nombre);
        this.sueldo = sueldo;
        this.experienciaAnual = experienciaAnual;
        this.asignaturas = asignaturas;
    }

    private Profesor() {
        asignaturas = new ArrayList<>();
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return sueldo == profesor.sueldo && experienciaAnual == profesor.experienciaAnual && Objects.equals(asignaturas, profesor.asignaturas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sueldo, experienciaAnual, asignaturas);
    }

    @Override
    public String toString() {
        return "\n" + getNombre() + "{" +
                "sueldo=" + sueldo +
                ", experienciaAnual=" + experienciaAnual +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
