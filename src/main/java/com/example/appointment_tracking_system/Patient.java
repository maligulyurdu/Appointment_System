package com.example.appointment_tracking_system;

import java.util.ArrayList;

public class Patient extends PeopleData implements ChangeInformation{

    static ArrayList<Patient> patients = new ArrayList<>();
    public Patient(String full_name, String type, String phone_num, int id) {
        super(full_name, type, phone_num, id);
        this.setType("Patient");
    }


    @Override
    public void add_info() {
        System.out.println("New patient created successfully.\n");
    }

    @Override
    public void delete_info() {
        System.out.println("Patient deleted successfully.\n");
    }

}
