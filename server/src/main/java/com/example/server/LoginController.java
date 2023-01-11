package com.example.server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Window;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;


import java.io.IOException;
import java.sql.SQLException;


public class LoginController  {
    @FXML
    private TextField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    private TextField usernameField;


    @FXML
    public void login(ActionEvent event) throws SQLException,IOException {
        Parent root= null;
        Window owner = submitButton.getScene().getWindow();



        if (usernameField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, owner, "Error!",
                    "Please enter your username");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, owner, " Error!",
                    "Please enter a password");
            return;
        }

        String usr = usernameField.getText();
        String pas = passwordField.getText();

        JdbcDao jdbcDao = new JdbcDao();
        boolean flag = jdbcDao.validate(usr, pas);

        MainApp s = new MainApp();
        if (!flag) {
            infoBox("Please enter correct Username and Password", null, "Failed");
        } else {
            infoBox("Login Successful!", null, "Failed");
           s.changeScene("serverbig.fxml");
        }
    }
    @FXML
    void enter(KeyEvent event) throws IOException {
        MainApp en = new MainApp();
        if(event.getCode() == KeyCode.ENTER){
            en.changeScene("serverbig.fxml");
        }}

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    private static void showAlert(AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}