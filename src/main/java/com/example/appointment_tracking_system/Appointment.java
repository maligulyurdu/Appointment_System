package com.example.appointment_tracking_system;

import java.util.ArrayList;

public class Appointment implements ChangeInformation {
    public Appointment() {} //
    private String hour;
    private String date;

    private String patient_name;
    private String doctor_name;
    private String phone_number;
    private int patient_id;
    private String complaint;

    public static ArrayList<Appointment> appointments = new ArrayList<>();

    public Appointment(String hour, String date, String patient_name, String doctor_name, String phone_number, int patient_id, String complaint) {
        this.hour = hour;
        this.date = date;
        this.setPatient_name(patient_name);
        this.setDoctor_name(doctor_name);
        this.setPhone_number(phone_number);
        this.setPatient_id(patient_id);
        this.setComplaint(complaint);
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        // ID numbers control
            if(patient_id < 100000 || patient_id > 999999){
                System.out.println("Invalid ID, changed to 0 by default.\n");
                this.patient_id = 0;
            }
            else this.patient_id = patient_id;
        }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
    Patient patient = new Patient("","","",0);

    public void add_appointment(String patient_name,int patient_id,String phone_number,String complaint,String doctor_name,String hour,String date){
        appointments.add(new Appointment(hour,date,patient_name,doctor_name,phone_number,patient_id,complaint));
        Patient.patients.add(new Patient(patient_name,"",phone_number,patient_id));
        add_info();
        patient.add_info();
    }
    @Override
    public void add_info() {
        System.out.println("Appointment has been created.\n");
    }

    @Override
    public void delete_info() {
        System.out.println("Appointment has been deleted.\n");
    }


}
