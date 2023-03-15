package org.example;

import java.io.Serializable;


public class Student implements Serializable {
    private int reg_no;
    private  String name;
    private int age;
    private  String email;
    private String door;
    private  String street;
    private String city;
    private int pincode;


    public Student(int reg_no, String name, int age, String email, String door, String street, String city, int pincode) {
        this.reg_no = reg_no;
        this.name = name;
        this.age = age;
        this.email = email;
        this.door = door;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
    }

    public int getReg_no() {
        return reg_no;
    }

    public void setReg_no(int reg_no) {
        this.reg_no = reg_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Student() {
    }
}
