package classes;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Student {
    private int reg_no;
    private  String name;
    private int age;
    private  String email;
    private ArrayList<Address> addresses = new ArrayList<>();

    public Student(int reg_no, String name, int age, String email) {
        this.reg_no = reg_no;
        this.name = name;
        this.age = age;
        this.email = email;

    }

    public Student() {
    }
}
