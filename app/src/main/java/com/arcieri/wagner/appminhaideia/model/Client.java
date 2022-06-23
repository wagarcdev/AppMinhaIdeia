package com.arcieri.wagner.appminhaideia.model;

public class Client {

    private int ID;
    private String name;
    private String email;
    private String telephone;
    private int age;
    private boolean gender;

    public Client(String name, String email, String telephone, int age, boolean gender) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.age = age;
        this.gender = gender;
    }

    public Client() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }




}
