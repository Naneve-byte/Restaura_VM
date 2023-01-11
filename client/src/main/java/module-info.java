module com.example.client {
    requires javafx.controls;
    requires javafx.fxml;


    requires org.controlsfx.controls;
    requires com.jfoenix;
    requires org.slf4j;



    opens com.example.client to javafx.fxml;
    exports com.example.client;
}