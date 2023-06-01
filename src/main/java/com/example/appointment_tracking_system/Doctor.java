package com.example.appointment_tracking_system;

public class Doctor extends PeopleData implements ChangeInformation{

    public Doctor(String full_name, String type, String phone_num, int id) {
        super(full_name, type, phone_num, id);
        this.setType("Doctor");
    }

    @Override
    public void add_info() {
        System.out.println("Doctors were successfully imported.\n");
    }

    @Override
    public void delete_info() {
        //
    }

}
