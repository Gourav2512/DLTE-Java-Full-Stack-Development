package org.example;

import java.io.IOException;
import java.sql.SQLException;

public interface StudentEvents {
    //public void connect() throws SQLException;
    public void insertData() throws IOException, SQLException;
    public void insertDB(Student student) throws SQLException;
    public void deleteData() throws SQLException;
    public void deleteDB(int regNo) throws SQLException;
    public void displayData() throws SQLException;
}
