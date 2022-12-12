package domain.servicios;

import dao.DaoPersonas;
import domain.modelo.Persona;

import java.util.List;

public class ServiciosPersonas {

    private DaoPersonas daoPersonas;

    public ServiciosPersonas(DaoPersonas daoPersonas) {
        this.daoPersonas = daoPersonas;
    }

    public boolean addPersona(Persona p) {
        if (!getPersona(p)) {
            return daoPersonas.addPersona(p);
        } else {
            return false;
        }
    }

    public List<Persona> getPersonas() {
        return daoPersonas.getPersonas();
    }

    public boolean getPersona(Persona p) {
        return daoPersonas.getPersona(p);
    }

    public boolean updatePersona(Persona p1, Persona p2) {
        if (daoPersonas.getPersona(p2)) {
            return daoPersonas.updatePersona(p1, p2);
        } else {
            return false;
        }
    }

    public boolean eliminarPersona(Persona p) {
        if (daoPersonas.getPersona(p)) {
            return daoPersonas.eliminarPersona(p);
        } else {
            return false;
        }
    }

}