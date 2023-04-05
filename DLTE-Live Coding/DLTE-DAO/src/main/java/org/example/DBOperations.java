package org.example;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;

public class DBOperations {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public DBOperations() {
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

    public String authenticate(String username, String password) {
        try {
            preparedStatement = connection.prepareStatement("select * from admin where username=? and passcode=?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("fullname");
            } else
                return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int insertAdmin(Admin admin){
        int x=0;
        try{
            preparedStatement = connection.prepareStatement("insert into admin values(?,?,?,?)");
            preparedStatement.setString(1,admin.getUsername());
            preparedStatement.setString(2,admin.getPassword());
            preparedStatement.setString(3,admin.getFullname());
            preparedStatement.setInt(4,admin.getAge());
            x = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }

    public ArrayList<Customer> fetchCustomer(){
        ArrayList<Customer> customers = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement("select * from customer_new");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("cust_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String pan = resultSet.getString("pan");
                long contact = resultSet.getLong("contact");
                int pin = resultSet.getInt("pin");
                Customer customer = new Customer(id,name,email,pan,contact,pin);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;

    }
    public ArrayList<Loan> fetchLoan(int cust_id){
        ArrayList<Loan> loans = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement("select * from loan where cust_d=?");
            preparedStatement.setInt(1,cust_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("borrowername");
                String type = resultSet.getString("type");
                int amount = resultSet.getInt("amount");
                Date date = resultSet.getDate("issuedate");
                Loan loan = new Loan(id,name,type,amount,date);
                loans.add(loan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loans;

    }
}

