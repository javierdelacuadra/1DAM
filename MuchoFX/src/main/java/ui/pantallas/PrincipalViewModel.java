package ui.pantallas;

import dao.DaoPersonas;
import domain.modelo.Persona;
import domain.servicios.ServiciosPersonas;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PrincipalViewModel {

    private ServiciosPersonas serviciosPersonas = new ServiciosPersonas(new DaoPersonas());
    private ObservableList<Persona> personas;

    private PrincipalViewModel() {
        personas = FXCollections.observableArrayList(serviciosPersonas.getPersonas());
    }

    public PrincipalViewModel(ServiciosPersonas serviciosPersonas) {
        this();
        this.serviciosPersonas = serviciosPersonas;
    }

    public void addPersona(Persona persona){
        serviciosPersonas.addPersona(persona);
        personas.clear();
        personas.addAll(serviciosPersonas.getPersonas());
    }

    public void updatePersona(Persona persona) {
        personas.remove(persona);
        personas.add(persona);
    }

    public void removePersona(Persona persona){
        serviciosPersonas.eliminarPersona(persona);
        personas.remove(persona);
    }

    public ObservableList<Persona> getPersonas() {
        return personas;
    }
}
