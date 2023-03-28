package handlers;

import classes.Address;
import classes.Student;
import dbase.DBOperations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "InsertServlet", value="/insert")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

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

        Student student = new Student(reg_no, name, age, email);
        student.getAddresses().add(new Address(cDoor, cStreet, cCity, cPincode,"Current"));
        student.getAddresses().add(new Address(pDoor, pStreet, pCity, pPincode,"Permanent"));
        DBOperations dbOperations = new DBOperations();
        dbOperations.insertDB(student);

        logger.log(Level.INFO, "Insertion Successful");
        RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
