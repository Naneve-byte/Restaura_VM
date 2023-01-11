package com.example.client;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    private static Stage stg;
    public static final String CURRENCY = "$";


    @Override
    public void start(Stage primaryStage) throws Exception {
        stg=primaryStage;
        System.out.println(getClass());
        Parent root = FXMLLoader.load(getClass().getResource("clientConServer.fxml"));
        primaryStage.setTitle("Connect Server");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public void changeScene(String fxml) throws IOException {
        Parent pane =FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void loginButtonAction(ActionEvent actionEvent) {
    }
}
