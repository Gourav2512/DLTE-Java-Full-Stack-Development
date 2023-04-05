package handlers;

import classes.Customer;
import dbase.DBOperations;
import lombok.SneakyThrows;
import sun.util.resources.cldr.chr.CalendarData_chr_US;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DisplayServlet",value = "/display")
public class DisplayServlet extends HttpServlet {
    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBOperations dbOperations = new DBOperations();
        ArrayList<Customer> customers = dbOperations.fetchCustomer();
        System.out.println(customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request,response);
    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
