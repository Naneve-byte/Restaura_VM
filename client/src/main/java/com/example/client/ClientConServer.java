package com.example.client;

import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class    ClientConServer implements Initializable {
    private static Stage stg;
    @FXML private ImageView Defaultview;
    @FXML public TextField hostnameTextfield;
    @FXML private TextField portTextfield;
    @FXML
    JFXComboBox<String> imagePicker;
    @FXML private BorderPane borderPane;
    private Scene scene;
    private static ClientConServer instance;

    public ClientConServer() {
        instance = this;
    }

    public static ClientConServer getInstance() {
        return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imagePicker.getItems().add("Table 1");
        for (int i = 0; i < 13; i++) {
            String a = "Table "+i;
            imagePicker.getItems().add(a);
        }

    }

    public void loginButtonAction() throws IOException {
        String hostname = hostnameTextfield.getText();
        int port = Integer.parseInt(portTextfield.getText());


        FXMLLoader fmxlLoader = new FXMLLoader(getClass().getResource("ClientApplication.fxml"));
        Parent window = (Pane) fmxlLoader.load();
        Connect Connect = new Connect(hostname, port);
        Thread x = new Thread(Connect);
        x.start();
        this.scene = new Scene(window);
        String b = imagePicker.getValue();
        Connect.send(b);
    }
    public void showScene() throws IOException {
        Platform.runLater(() -> {
            Stage stage = (Stage) hostnameTextfield.getScene().getWindow();
            stage.setResizable(true);
            stage.setWidth(1040);
            stage.setHeight(620);

            stage.setOnCloseRequest((WindowEvent e) -> {
                Platform.exit();
                System.exit(0);
            });
            stage.setScene(this.scene);
            stage.setMinWidth(800);
            stage.setMinHeight(300);
            stage.centerOnScreen();
        });

    }
    public void showErrorDialog(String message) {
        Platform.runLater(()-> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText(message);
            alert.setContentText("Please check for firewall issues and check if the server is running.");
            alert.showAndWait();
        });

    }

    public void pilih(ActionEvent actionEvent) throws IOException {
        String table = imagePicker.getValue();
        Connect.send(table);
    }
}

