package ui.pantallas;

import dao.DaoPersonas;
import domain.modelo.Persona;
import domain.servicios.ServiciosPersonas;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.MFXToggleButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class PrincipalController implements Initializable {

    ServiciosPersonas sp = new ServiciosPersonas(new DaoPersonas());

    private PrincipalViewModel viewModel;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private MFXButton botonadd;

    @FXML
    private MFXButton botonremove;

    @FXML
    private MFXButton botonupdate;

    @FXML
    private TableView<Persona> tablapersonas;

    @FXML
    private TableColumn<Persona, String> columna1;

    @FXML
    private TableColumn<Persona, Integer> columna2;

    @FXML
    private TableColumn<Persona, String> columna3;

    @FXML
    private TableColumn<Persona, String> columna4;

    @FXML
    private MFXComboBox<String> comboBox;

    @FXML
    private MFXTextField nombre;

    @FXML
    private MFXTextField edad;

    @FXML
    private MFXTextField DNI;

    @FXML
    private Label label;

    @FXML
    private ImageView botonayuda;

    @FXML
    private MFXToggleButton toggleidioma;

    @FXML
    private MFXToggleButton modooscuro;

    public PrincipalController() {
        viewModel = new PrincipalViewModel(new ServiciosPersonas(new DaoPersonas()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tablapersonas.setItems(viewModel.getPersonas());
        columna1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columna2.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columna3.setCellValueFactory(new PropertyValueFactory<>("DNI"));
        columna4.setCellValueFactory(new PropertyValueFactory<>("genero"));
        comboBox.getItems().addAll(resourceBundle.getString("combo1"), resourceBundle.getString("combo2"), resourceBundle.getString("combo3"));
    }

    @FXML
    private void cambioIdioma() {

        ResourceBundle bundle;
        FXMLLoader loaderMenu;

        if (toggleidioma.isSelected()) {
            bundle = ResourceBundle.getBundle("muchotext", Locale.ENGLISH);
        } else {
            bundle = ResourceBundle.getBundle("muchotext", Locale.getDefault());
        }
        loaderMenu = new FXMLLoader(getClass().getResource("/fxml/principal.fxml"), bundle);

        label.setText(bundle.getString("titulo"));
        columna1.setText(bundle.getString("columnaNombre"));
        columna2.setText(bundle.getString("columnaEdad"));
        columna3.setText(bundle.getString("columnaDNI"));
        columna4.setText(bundle.getString("columnaGenero"));
        botonadd.setText(bundle.getString("botonadd"));
        botonremove.setText(bundle.getString("botoneliminar"));
        botonupdate.setText(bundle.getString("botonupdate"));
        nombre.setPromptText(bundle.getString("columnaNombre"));
        edad.setPromptText(bundle.getString("columnaEdad"));
        DNI.setPromptText(bundle.getString("columnaDNI"));
        comboBox.setPromptText(bundle.getString("columnaGenero"));
        toggleidioma.setText(bundle.getString("idioma"));
        modooscuro.setText(bundle.getString("modooscuro"));
        comboBox.getItems().clear();
        comboBox.getItems().addAll(bundle.getString("combo1"), bundle.getString("combo2"), bundle.getString("combo3"));
    }

    @FXML
    private void modoOscuro() {
        if (modooscuro.isSelected()) {
            anchorPane.setStyle("-fx-background-color: #000000;");
            label.setTextFill(Color.WHITE);
            label.setStyle("-fx-background-color: #000000");
            botonadd.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
            botonremove.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
            botonupdate.setStyle("-fx-text-fill: white; -fx-background-color: #000000;");
            toggleidioma.setTextFill(Color.WHITE);
            modooscuro.setTextFill(Color.WHITE);
        } else {
            anchorPane.setStyle("-fx-background-color: #ffffff;");
            label.setTextFill(Color.BLACK);
            label.setStyle("-fx-background-color: #ffffff");
            botonadd.setStyle("-fx-text-fill: black; -fx-background-color: #e6e9eb;");
            botonremove.setStyle("-fx-text-fill: black; -fx-background-color: #e6e9eb;");
            botonupdate.setStyle("-fx-text-fill: black; -fx-background-color: #e6e9eb;");
            toggleidioma.setTextFill(Color.BLACK);
            modooscuro.setTextFill(Color.BLACK);
        }
    }

    @FXML
    private void addPersona() {
        if (nombre.getText().isEmpty() || edad.getText().isEmpty() || DNI.getText().isEmpty() || comboBox.getValue().isEmpty()) {
            alertaErrorAdd();
        } else {
            Persona p = new Persona(nombre.getText(), Integer.parseInt(edad.getText()), DNI.getText(), comboBox.getValue());
            if (sp.addPersona(p)) {
                tablapersonas.getItems().add(p);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Persona añadida con éxito");
                alert.setHeaderText("Persona añadida con éxito");
                alert.setContentText("Se ha añadido correctamente");
                alert.show();
            } else {
                alertaErrorAdd();
            }
        }
    }

    @FXML
    private void eliminarPersona() {
        if (nombre.getText().isEmpty() || edad.getText().isEmpty() || DNI.getText().isEmpty() || comboBox.getValue().isEmpty()) {
            alertaErrorEliminar();
        } else {
            Persona p = new Persona(nombre.getText(), Integer.parseInt(edad.getText()), DNI.getText(), comboBox.getValue());
            if (sp.eliminarPersona(p)) {
                tablapersonas.getItems().remove(new Persona(nombre.getText(), Integer.parseInt(edad.getText()), DNI.getText(), comboBox.getValue()));
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Persona eliminada con éxito");
                alert.setHeaderText("Persona eliminada con éxito");
                alert.setContentText("Se ha eliminado correctamente");
                alert.show();
            } else {
                alertaErrorEliminar();
            }
        }
    }

    @FXML
    private void updatePersona() {
        if (nombre.getText() == null || edad.getText() == null || DNI.getText() == null || comboBox.getValue() == null) {
            alertaErrorUpdate();
        } else {
            Persona p1 = new Persona(nombre.getText(), Integer.parseInt(edad.getText()), DNI.getText(), comboBox.getValue());
            Persona p2 = tablapersonas.getSelectionModel().getSelectedItem();
            if (sp.updatePersona(p1, p2)) {
                tablapersonas.getItems().remove(p2);
                tablapersonas.getItems().add(p1);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Persona actualizada con éxito");
                alert.setHeaderText("Persona actualizada con éxito");
                alert.setContentText("Se ha actualizado correctamente");
                alert.show();
            } else {
                alertaErrorUpdate();
            }
        }
    }

    @FXML
    private void ayuda() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Ayuda");
        a.setHeaderText("Ayuda");
        a.setContentText("Para actualizar una persona, selecciona una persona\nen la tabla y escribe los nuevos datos");
        a.show();
    }

    @FXML
    private void alertaErrorAdd() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al añadir persona");
        alert.setContentText("No se ha podido añadir la persona");
        alert.show();
    }

    @FXML
    private void alertaErrorEliminar() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al eliminar persona");
        alert.setContentText("No se ha podido eliminar la persona");
        alert.show();
    }

    @FXML
    private void alertaErrorUpdate() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error al actualizar persona");
        alert.setContentText("No se ha podido actualizar la persona");
        alert.show();
    }
}