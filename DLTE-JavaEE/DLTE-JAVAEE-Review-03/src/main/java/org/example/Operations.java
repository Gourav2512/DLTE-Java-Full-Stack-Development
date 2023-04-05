package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Operations implements StudentEvents {

    Scanner scanner = new Scanner(System.in);
    Connection con;
    PreparedStatement preparedStatement;

    Operations() throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        String oracleUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        con = DriverManager.getConnection(oracleUrl,"system","Gourav@2512");
        preparedStatement = con.prepareStatement("alter session set current_schema=GOURAV");
        preparedStatement.executeQuery();
        System.out.println("Connected");
    }

    @Override
    public void insertData() throws SQLException {
        Student s = new Student();
        System.out.println("Enter the Register No.:");
        s.setReg_no(scanner.nextInt());
        System.out.println("Enter the Name:");
        scanner.nextLine();
        s.setName(scanner.nextLine());
        System.out.println("Enter the Age:");
        s.setAge(scanner.nextInt());
        System.out.println("Enter the Email ID:");
        scanner.nextLine();
        s.setEmail(scanner.nextLine());
        System.out.println("Enter the Door No.:");
        s.setDoor(scanner.nextLine());
        System.out.println("Enter the Street:");
        s.setStreet(scanner.nextLine());
        System.out.println("Enter the City:");
        s.setCity(scanner.nextLine());
        System.out.println("Enter the Pincode:");
        s.setPincode(scanner.nextInt());
        scanner.nextLine();
        insertDB(s);
    }

    @Override
    public void insertDB(Student student) throws SQLException {
        preparedStatement = con.prepareStatement("insert into students values(?,?,?,?,add_seq.NEXTVAL)");
        preparedStatement.setInt(1,student.getReg_no());
        preparedStatement.setString(2,student.getName());
        preparedStatement.setInt(3,student.getAge());
        preparedStatement.setString(4,student.getEmail());
        int x =preparedStatement.executeUpdate();
        preparedStatement = con.prepareStatement("insert into address values(add_seq.CURRVAL,?,?,?,?)");
        preparedStatement.setString(1,student.getDoor());
        preparedStatement.setString(2,student.getStreet());
        preparedStatement.setString(3,student.getCity());
        preparedStatement.setInt(4,student.getPincode());
        int y = preparedStatement.executeUpdate();
        if(x>0&&y>0){
            System.out.println("Insertion successful");
        }
        else {
            System.out.println("Insertion declined");
        }
    }

    @Override
    public void deleteData() throws SQLException {
        System.out.println("Enter the Register Number:");
        deleteDB(scanner.nextInt());
    }

    @Override
    public void deleteDB(int regNo) throws SQLException {
        preparedStatement = con.prepareStatement("delete from students where reg_no=?");
        preparedStatement.setInt(1,regNo);
        if(preparedStatement.executeUpdate()>0){
            System.out.println("Deletion Successful");
        }
        else {
            System.out.println("Insertion declined");
        }
    }

    @Override
    public void displayData() throws SQLException {
        preparedStatement = con.prepareStatement("select * from students join address on add_id=address_id");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            System.out.println(rs.getInt("reg_no")+" "+rs.getString("name")+" "+rs.getInt("age")+" "+rs.getString("email")+" "+rs.getString("door_no")+" "+rs.getString("street")+" "+rs.getString("city")+" "+rs.getInt("pincode"));
        }
    }
}
