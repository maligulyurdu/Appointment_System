package com.example.appointment_tracking_system;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExitController {

    @FXML
    private Button exportButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button exitButton;


    @FXML
    void cancel() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-scene.fxml"));
        Parent root = loader.load();
        Stage stage=(Stage)exitButton.getScene().getWindow();
        Scene scene=new Scene(root,1266,765);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void exportandexit() throws IOException {
        File file = new File("..\\Appointment tracking system\\src\\appointments.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file,false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Patient Name --- ID --- Phone Number --- Date --- Time\n\n");
        try{
            String temp = "000000";
            for (int i = 0; i < Appointment.appointments.size(); i++) {
                if(Appointment.appointments.get(i).getPatient_id() == 0){
                    temp = "000000";
                }
                else temp = String.valueOf(Appointment.appointments.get(i).getPatient_id());
                bufferedWriter.write(
                        Appointment.appointments.get(i).getPatient_name()+" --- "+
                                temp+" --- "+ //ID
                                Appointment.appointments.get(i).getPhone_number()+" --- "+
                                Appointment.appointments.get(i).getDate()+" --- "+
                                Appointment.appointments.get(i).getHour()+"\n"
                );
        }
            bufferedWriter.close();
            System.exit(0);
        }
        catch (Exception e){
            System.exit(0);
        }

    }

    @FXML
    void exit(){
        System.exit(0);
    }

}
