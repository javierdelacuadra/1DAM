package dao;

import domain.modelo.Persona;

import java.util.ArrayList;
import java.util.List;

public class DaoPersonas {

    private Database db;

    public DaoPersonas() {
        this.db = new Database();
    }

    public boolean addPersona(Persona p) {
        List<Persona> personas = db.loadPersonas();
        if (personas == null) {
            personas = new ArrayList<>();
        }
        personas.add(p);
        return db.savePersonas(personas);
    }

    public List<Persona> getPersonas() {
        return db.loadPersonas();
    }

    public boolean eliminarPersona(Persona p) {
        List<Persona> personas = db.loadPersonas();
        personas.remove(p);
        return db.savePersonas(personas);
    }

    public boolean updatePersona(Persona p1, Persona p2) {
        List<Persona> personas = db.loadPersonas();
        personas.remove(p2);
        personas.add(p1);
        return db.savePersonas(personas);
    }

    public boolean getPersona(Persona p) {
        List<Persona> personas = db.loadPersonas();
        return personas.stream().anyMatch(persona -> persona.equals(p));
    }
}