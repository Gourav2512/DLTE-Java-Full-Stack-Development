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

@WebServlet(name = "DeleteServlet",value = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        int reg_no = Integer.parseInt(request.getParameter("reg"));
        try {
            Driver driver = new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GOURAV", "Gourav22512");
            PreparedStatement preparedStatement = connection.prepareStatement("delete from students where reg_no=?");
            preparedStatement.setInt(1, reg_no);
            preparedStatement.executeUpdate();
            RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
