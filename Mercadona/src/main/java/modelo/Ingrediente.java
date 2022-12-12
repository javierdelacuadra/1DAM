package modelo;

public class Ingrediente implements Clonable<Ingrediente> {

    private final String nombre;

    public Ingrediente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public Ingrediente clonar() {
        return new Ingrediente(this.nombre);
    }
}