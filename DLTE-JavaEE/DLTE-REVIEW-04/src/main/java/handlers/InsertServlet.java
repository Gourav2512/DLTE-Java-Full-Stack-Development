package handlers;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "InsertServlet", value="/insert")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        int reg_no = Integer.parseInt(request.getParameter("reg_no"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String cDoor = request.getParameter("door1");
        String cStreet = request.getParameter("street1");
        String cCity = request.getParameter("city1");
        int cPincode = Integer.parseInt(request.getParameter("pincode1"));
        String pDoor = request.getParameter("door2");
        String pStreet = request.getParameter("street2");
        String pCity = request.getParameter("city2");
        int pPincode = Integer.parseInt(request.getParameter("pincode2"));
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Gourav@2512");
            PreparedStatement preparedStatement = connection.prepareStatement("alter session set current_schema=GOURAV");
            preparedStatement.executeQuery();
            preparedStatement = connection.prepareStatement("insert into students_new values(?,?,?,?)");
            preparedStatement.setInt(1,reg_no);
            preparedStatement.setString(2,name);
            preparedStatement.setInt(3,age);
            preparedStatement.setString(4,email);
            int p =preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("insert into address_new values(address_seq.NEXTVAL,?,?,?,?,'Current')");
            preparedStatement.setString(1,cDoor);
            preparedStatement.setString(2,cStreet);
            preparedStatement.setString(3,cCity);
            preparedStatement.setInt(4,cPincode);
            int q = preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("insert into address_mapper values(?,address_seq.CURRVAL)");
            preparedStatement.setInt(1,reg_no);
            int r = preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("insert into address_new values(address_seq.NEXTVAL,?,?,?,?,'Permanent')");
            preparedStatement.setString(1,pDoor);
            preparedStatement.setString(2,pStreet);
            preparedStatement.setString(3,pCity);
            preparedStatement.setInt(4,pPincode);
            int s = preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement("insert into address_mapper values(?,address_seq.CURRVAL)");
            preparedStatement.setInt(1,reg_no);
            int t = preparedStatement.executeUpdate();
            if(p>0&&q>0&&r>0&&s>0&&t>0){
                logger.log(Level.INFO,"Insertion Successful");
                RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
                dispatcher.forward(request,response);
            }
            else {
                logger.log(Level.INFO,"Insertion Declined");
                RequestDispatcher dispatcher = request.getRequestDispatcher("insert.jsp");
                dispatcher.forward(request,response);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
