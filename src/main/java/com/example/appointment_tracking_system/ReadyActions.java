package com.example.appointment_tracking_system;

import java.util.ArrayList;

public class ReadyActions {

    public ReadyActions(){} // For calling methods.

    public ArrayList<Doctor> doctors = new ArrayList<>();
    public static ArrayList<String> doctor_names = new ArrayList<>();
    Doctor d1 = new Doctor("Dr. Elizabeth Smith","","555-123-4567",123456);
    Doctor d2 = new Doctor("Dr. John Johnson","","555-987-6543",345612);
    Doctor d3 = new Doctor("Dr. Maria Rodriguez","","555-246-8376",356612);



    public void import_docs(){
        doctors.add(d1);
        doctors.add(d2);
        doctors.add(d3);
        doctor_names.add(d1.getFull_name());
        doctor_names.add(d2.getFull_name());
        doctor_names.add(d3.getFull_name());
        d1.add_info(); // Terminal test
    }


}
