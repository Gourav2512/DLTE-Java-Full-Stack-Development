package dbase;

import classes.Customer;
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
    public ArrayList<Customer> fetchCustomer() throws SQLException {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from customer_new");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int cust_id = resultSet.getInt("cust_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String pan = resultSet.getString("pan");
                long contact = resultSet.getLong("contact");
                int pin = resultSet.getInt("pin");
                customers.add(new Customer(cust_id, name, email, pan, contact, pin));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
