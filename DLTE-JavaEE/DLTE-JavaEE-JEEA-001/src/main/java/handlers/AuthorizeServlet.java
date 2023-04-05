package handlers;

import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "AuthorizeServlet", value = "/authen")
public class AuthorizeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String receiveId=request.getParameter("custId");
        String receivePass=request.getParameter("custPassword");
        int custID=Integer.parseInt(receiveId);
        try {
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Gourav@2512");
            PreparedStatement preparedStatement = connection.prepareStatement("alter session set current_schema =GOURAV");
            preparedStatement.executeQuery();
            String query="select * from customers where cust_id=? and password=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1, custID);
            preparedStatement.setString(2,receivePass);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                RequestDispatcher dispatcher=request.getRequestDispatcher("dashboard.jsp");
                dispatcher.forward(request,response);
            }
            else{
                RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
