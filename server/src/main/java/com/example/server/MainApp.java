package com.example.server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;


public class MainApp extends Application {
    private static Stage stg;
    /* Setting up variables */
    private static final int PORT = 9001;
    /* private static final HashMap<String, User> names = new HashMap<>();*/
    private static HashSet<ObjectOutputStream> writers = new HashSet<>();
    /*private static ArrayList<User> users = new ArrayList<>();*/
    static Logger logger = LoggerFactory.getLogger(MainApp.class);

    @Override
    public void start(Stage primaryStage) throws Exception {
        stg=primaryStage;
        System.out.println(getClass());
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/server/login.fxml"));
        primaryStage.setTitle("User Login");

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    public void changeScene(String fxml) throws IOException{
        try {
            Parent pane = FXMLLoader.load(getClass().getResource(fxml));
            stg.getScene().setRoot(pane);
            stg.setMinHeight(100);
            stg.setMinWidth(200);

        }catch (Exception  v){
            v.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        //launch(args);
        logger.info("server is running.");
        //launch(args);
        ServerSocket listener = new ServerSocket(PORT);
        launch(args);

        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            listener.close();
        }
        //launch(args);
    }

    private static class Handler extends Thread {
        private String name;
        private Socket socket;
        private Logger logger = LoggerFactory.getLogger(Handler.class);
        private ObjectInputStream input;
        private OutputStream os;
        private ObjectOutputStream output;
        private InputStream is;

        public Handler(Socket socket) throws IOException {
            this.socket = socket;
        }

        public void run() {
            logger.info("Attempting to connect a user...");
            try {
                is = socket.getInputStream();
                input = new ObjectInputStream(is);
                os = socket.getOutputStream();
                output = new ObjectOutputStream(os);

                Type firstMessage = (Type) input.readObject();

                writers.add(output);
            } catch (SocketException socketException) {
                logger.error("Socket Exception for user " + name);
            } catch (Exception e){
                logger.error("Exception in run() method for user: " + name, e);
            }
        }
    }

}


