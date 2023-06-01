package com.example.appointment_tracking_system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Appointment_Application extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        ReadyActions readyActions = new ReadyActions(); // Import doctor information.
        readyActions.import_docs();

        FXMLLoader fxmlLoader = new FXMLLoader(Appointment_Application.class.getResource("main-scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1266, 765); // H/V
        stage.setTitle("Appointment Tracking System");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
            launch();
    }
}