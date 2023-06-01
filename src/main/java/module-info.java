module com.example.appointment_tracking_system {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.appointment_tracking_system to javafx.fxml;
    exports com.example.appointment_tracking_system;
}