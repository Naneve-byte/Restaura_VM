package com.example.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientConServer extends Application {
    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stg=primaryStage;
        System.out.println(getClass());
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/login/clientConServer.fxml"));
        primaryStage.setTitle("User Login");
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

}

