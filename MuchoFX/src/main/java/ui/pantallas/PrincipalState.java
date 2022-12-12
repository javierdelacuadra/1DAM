package ui.pantallas;

import domain.modelo.Persona;
import javafx.collections.ObservableList;
import lombok.Data;

@Data
public class PrincipalState {

    private final ObservableList<Persona> personas;

    private final String error;

}