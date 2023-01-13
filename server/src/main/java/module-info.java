module com.example.server {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires slf4j.api;
    requires java.sql;
    requires fontawesomefx;
    requires com.jfoenix;

    opens com.example.server to javafx.fxml;
    exports com.example.server;
    exports com.example.model;
    opens com.example.model to javafx.fxml;
}