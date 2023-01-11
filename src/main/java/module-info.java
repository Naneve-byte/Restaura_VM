module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires java.sql;
    requires slf4j.api;

    opens com.example.login to javafx.fxml;
    exports com.example.login;
}
