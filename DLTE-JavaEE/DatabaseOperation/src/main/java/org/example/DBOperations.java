package org.example;

import oracle.jdbc.driver.OracleDriver;


import java.sql.*;
import java.util.logging.Level;

public class DBOperations {
    private Connection connection;
    private PreparedStatement preparedStatement;
    DBOperations() {
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Gourav@2512");
            preparedStatement = connection.prepareStatement("alter session set current_schema=GOURAV");
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void  insertDB(Student student){
        try {
            preparedStatement = connection.prepareStatement("insert into students_new values(?,?,?,?)");
            preparedStatement.setInt(1,student.getReg_no());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setString(4,student.getEmail());
            preparedStatement.executeUpdate();
            for (Address address : student.getAddresses()){
                preparedStatement = connection.prepareStatement("insert into address_new values(address_seq.NEXTVAL,?,?,?,?,?)");
                preparedStatement.setString(1,address.getDoor_no());
                preparedStatement.setString(2,address.getStreet());
                preparedStatement.setString(3,address.getCity());
                preparedStatement.setInt(4,address.getPincode());
                preparedStatement.setString(5,address.getType());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement("insert into address_mapper values(?,address_seq.CURRVAL)");
                preparedStatement.setInt(1,student.getReg_no());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}