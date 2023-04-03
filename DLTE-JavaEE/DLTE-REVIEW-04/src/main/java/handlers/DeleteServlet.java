package handlers;

import dbase.DBOperations;
import lombok.SneakyThrows;
import oracle.jdbc.driver.OracleDriver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "DeleteServlet",value = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        DBOperations dbOperations = new DBOperations();
        int reg_no = Integer.parseInt(request.getParameter("regNo"));
        dbOperations.deleteDB(reg_no);
        logger.log(Level.INFO,"Deleted");
        PrintWriter pw = response.getWriter();
//        pw.write(dbOperations.deleteDB(reg_no));
    }
}
