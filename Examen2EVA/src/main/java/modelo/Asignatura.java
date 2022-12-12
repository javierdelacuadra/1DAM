package modelo;

import java.util.Objects;

public class Asignatura {

    private final String nombre;
    private int precio;
    private int maxAlumnos;
    private int nota;

    public Asignatura(String nombre, int precio, int maxAlumnos) {
        this.nombre = nombre;
        this.precio = precio;
        this.maxAlumnos = maxAlumnos;
    }

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getMaxAlumnos() {
        return maxAlumnos;
    }

    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return precio == that.precio && maxAlumnos == that.maxAlumnos && nota == that.nota && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, precio, maxAlumnos, nota);
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", maxAlumnos=" + maxAlumnos +
                '}';
    }
}