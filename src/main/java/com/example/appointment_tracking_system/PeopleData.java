package com.example.appointment_tracking_system;

public abstract class PeopleData {
    private String full_name;
    private String type;
    private String phone_num;
    private int id;

    public PeopleData(String full_name, String type, String phone_num, int id) {
        this.setFull_name(full_name);
        this.setType(type);
        this.setPhone_num(phone_num);
        this.setId(id);
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){this.id = id;}

}
