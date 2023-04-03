package interfaces;

import org.Address;
import org.Student;

import java.sql.SQLException;
import java.util.List;

public interface Operations {
    void insertDB(Student student) throws SQLException;
    void deleteDB(int reg_no) throws SQLException;
    List<Student> fetch() throws SQLException;
    List<Address> fetchAddress(int reg_no) throws SQLException;

}
