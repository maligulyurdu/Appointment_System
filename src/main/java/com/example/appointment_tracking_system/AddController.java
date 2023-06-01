package com.example.appointment_tracking_system;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    Alert alert = new Alert(Alert.AlertType.WARNING);

    Appointment appointment = new Appointment();

    @FXML
    private ChoiceBox<String> add_add_doctor;

    @FXML
    private ComboBox<String> add_add_hour;

    @FXML
    private TextField add_add_id;

    @FXML
    private TextField add_add_name;

    @FXML
    private TextField add_add_num;

    @FXML
    private DatePicker add_date;

    @FXML
    private Button cancelButton;

    @FXML
    private TextArea complaintInput;

    @FXML
    void add_add_appointment() throws IOException {
        // LocalDate to String
        // formattedDate for String usages.
        // Call add function
        // Control everything
        int id_information;
        try{
                id_information = Integer.parseInt((add_add_id.getText()));
                LocalDate date = add_date.getValue();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String formattedDate = date.format(formatter);
                appointment.add_appointment(
                        add_add_name.getText(),
                        id_information,
                        add_add_num.getText(),
                        complaintInput.getText(),
                        add_add_doctor.getValue(),
                        add_add_hour.getValue(),
                        formattedDate);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main-scene.fxml"));
            Parent root = loader.load();
            Stage stage=(Stage)cancelButton.getScene().getWindow();
            Scene scene=new Scene(root,1266,765);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            System.out.println("Appointment could not created.");
            alert.setTitle("Error Message");
            alert.setHeaderText("Invalid information");
            alert.setContentText("Please enter the information correctly.");
            alert.showAndWait();
        }

    }

    @FXML
    void add_cancel() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-scene.fxml"));
        Parent root = loader.load();
        Stage stage=(Stage)cancelButton.getScene().getWindow();
        Scene scene=new Scene(root,1266,765);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        add_add_hour.setItems(FXCollections.observableArrayList("13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30"));
        add_add_doctor.getItems().addAll(ReadyActions.doctor_names);
    }
}
