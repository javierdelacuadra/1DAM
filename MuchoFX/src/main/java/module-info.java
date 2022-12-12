module javafx {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;

    requires lombok;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires com.google.gson;
    requires org.apache.logging.log4j;

    exports ui;
    exports ui.pantallas;

    opens domain.modelo to javafx.base, com.google.gson;
    opens ui.pantallas to javafx.fxml;
    opens config to com.fasterxml.jackson.databind, com.fasterxml.jackson.dataformat.yaml, org.apache.logging.log4j;

}