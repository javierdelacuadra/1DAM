package servicios;

import data.DaoInstituto;
import modelo.Asignatura;
import modelo.Persona;

import java.util.List;

public class Servicios {

    public boolean matricularAlumno(String dni, String asignatura) {
        DaoInstituto dao = new DaoInstituto();
        return dao.matricularAlumno(dni, asignatura);
    }

    public boolean addNota(String dni, Asignatura a) {
        DaoInstituto dao = new DaoInstituto();
        return dao.addNota(dni, a);
    }

    public List<Persona> listaProfesoresOrdenada() {
        DaoInstituto dao = new DaoInstituto();
        return dao.listaProfesoresOrdenada();
    }

    public double notaMedia(String dni) {
        DaoInstituto dao = new DaoInstituto();
        return dao.notaMedia(dni);
    }
}
