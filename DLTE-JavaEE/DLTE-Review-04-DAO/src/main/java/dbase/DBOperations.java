package dbase;

import interfaces.Operations;
import oracle.jdbc.driver.OracleDriver;
import org.Address;
import org.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DBOperations implements Operations {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    ResourceBundle bundle = ResourceBundle.getBundle("application");

    public Connection getConnection() throws SQLException {
        Driver driver = new OracleDriver();
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(bundle.getString("dbUrl"), bundle.getString("dbUser"), bundle.getString("dbPassword"));
        return connection;
    }

    public void  insertDB(Student student) throws SQLException {
        Connection connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement("insert into students_new values(?,?,?,?,REF_SEQ.nextval)");
            preparedStatement.setInt(1,student.getReg_no());
            preparedStatement.setString(2,student.getName());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setString(4,student.getEmail());
            preparedStatement.executeUpdate();
            for (Address address : student.getAddresses()){
                preparedStatement = connection.prepareStatement("insert into address_new values(ADD_SEQ.nextval,REF_SEQ.currval,?,?,?,?)");
                preparedStatement.setString(1,address.getDoor_no());
                preparedStatement.setString(2,address.getStreet());
                preparedStatement.setString(3,address.getCity());
                preparedStatement.setInt(4,address.getPincode());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            connection.close();
        }
    }

    public void deleteDB(int reg_no) throws SQLException {
        Connection connection = getConnection();
        try{
            preparedStatement = connection.prepareStatement("delete from students_new where reg_no=?");
            preparedStatement.setInt(1, reg_no);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
    }

    @Override
    public List<Student> fetch() throws SQLException {
        Connection connection = getConnection();
        List<Student> students = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement("select * from STUDENTS_NEW");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                List<Address> addresses = fetchAddress(resultSet.getInt("reg_no"));
                Student student = new Student(resultSet.getInt("reg_no"),resultSet.getString("name"),resultSet.getInt("age"),resultSet.getString("email"),addresses);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
        return students;
    }

    @Override
    public List<Address> fetchAddress(int reg_no) throws SQLException {
        Connection connection = getConnection();
        List<Address> addresses = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement("select * from STUDENTS_NEW join ADDRESS_NEW on STUDENTS_NEW.ADD_REF = ADDRESS_NEW.ADD_REF and REG_NO=?");
            preparedStatement.setInt(1,reg_no);
            ResultSet addressSet = preparedStatement.executeQuery();
            while (addressSet.next()){
                addresses.add(new Address(addressSet.getString("door"),addressSet.getString("street"),addressSet.getString("city"),addressSet.getInt("pincode")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
        return addresses;
    }


}