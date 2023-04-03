package org;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Student {
    private int reg_no;
    private  String name;
    private int age;
    private  String email;
    private List<Address> addresses = new ArrayList<>();

    public Student(int reg_no, String name, int age, String email, List<Address> addresses) {
        this.reg_no = reg_no;
        this.name = name;
        this.age = age;
        this.email = email;
        this.addresses=addresses;

    }

    public Student() {
    }
}
