package com.example.appointment_tracking_system;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    Appointment appointment = new Appointment();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private Button addButton;
    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<Appointment, String> main_date;

    @FXML
    private TableColumn<Appointment, String> main_doctor_name;

    @FXML
    private TableColumn<Appointment, Integer> main_patient_id;

    @FXML
    private TableColumn<Appointment, String> main_patient_name;

    @FXML
    private TableColumn<Appointment, String> main_phone_num;

    @FXML
    private TableColumn<Appointment, String> main_time;

    @FXML
    private TableView<Appointment> tableView;
    @FXML
    void showComplaint() {
        try{
            int index = tableView.getSelectionModel().getSelectedIndex();
            alert.setTitle("Complaint");
            alert.setHeaderText("Patient Name: " + Appointment.appointments.get(index).getPatient_name());
            alert.setContentText(Appointment.appointments.get(index).getComplaint());
            alert.showAndWait();
        }
        catch (Exception e){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Error Message");
            alert2.setHeaderText("An error has occurred!");
            alert2.setContentText("Please select a appointment.");
            alert2.showAndWait();

        }

    }

    @FXML
    void exit() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("exit-scene.fxml"));
        Parent root = loader.load();
        Stage stage=(Stage)exitButton.getScene().getWindow();
        Scene scene=new Scene(root,457,141);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void main_add_appointment() throws IOException { // Switch add-appointment scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("add-appointment.fxml"));
        Parent root = loader.load();
        Stage stage=(Stage)addButton.getScene().getWindow();
        Scene scene=new Scene(root,662,491);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void main_delete_appointment() {
        try{
            int m = tableView.getSelectionModel().getSelectedIndex();
            Appointment.appointments.remove(m);
            tableView.getItems().remove(m);
            appointment.delete_info();
        }
        catch (Exception e){
            System.out.println("There is nothing to remove.");
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //background.setImage(image);
        ObservableList<Appointment> appointmentObservableList = tableView.getItems();
        appointmentObservableList.addAll(Appointment.appointments);
        tableView.setItems(appointmentObservableList);
        main_patient_name.setCellValueFactory(new PropertyValueFactory<>("patient_name"));
        main_patient_id.setCellValueFactory(new PropertyValueFactory<>("patient_id"));
        main_doctor_name.setCellValueFactory(new PropertyValueFactory<>("doctor_name"));
        main_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        main_time.setCellValueFactory(new PropertyValueFactory<>("hour"));
        main_phone_num.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
    }
}
