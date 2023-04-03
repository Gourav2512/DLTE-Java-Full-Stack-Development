package handlers;


import dbase.DBOperations;
import interfaces.Operations;
import lombok.SneakyThrows;
import org.Address;
import org.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "InsertServlet", value="/insert")
public class InsertServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.log(Level.INFO,"Entered servlet");
        int reg_no = Integer.parseInt(request.getParameter("regNo"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");

        String cDoor = request.getParameter("cDoor");
        String cStreet = request.getParameter("cStreet");
        String cCity = request.getParameter("cCity");
        int cPincode = Integer.parseInt(request.getParameter("cPincode"));

        String pDoor = request.getParameter("pDoor");
        String pStreet = request.getParameter("pStreet");
        String pCity = request.getParameter("pCity");
        int pPincode = Integer.parseInt(request.getParameter("pPincode"));
        List<Address> addresses = new ArrayList<>();
//        addresses.add(new Address(cDoor, cStreet, cCity, cPincode));
//        addresses.add(new Address(pDoor, pStreet, pCity, pPincode));
//        Student student = new Student(reg_no,name,age,email,addresses);
        addresses.add(new Address(cDoor,cStreet,cCity,cPincode));
        addresses.add(new Address(pDoor,pStreet,pCity,pPincode));
        Student student = new Student(reg_no,name,age,email,addresses);
        logger.log(Level.INFO,student.toString());
        logger.log(Level.INFO,addresses.toString());
        Operations dbOperations = new DBOperations();
        try{
            dbOperations.insertDB(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        logger.log(Level.INFO, "Insertion Successful");
        PrintWriter pw = response.getWriter();
        pw.write("Helloooooo");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getttttttttt");
    }
}
