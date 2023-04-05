package handlers;


import org.example.DBOperations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthenticateServlet", value = "/authenticate")
public class AuthenticateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DBOperations dbOperations = new DBOperations();
        String user = dbOperations.authenticate(username,password);
        System.out.println(user);
        if(!user.equals(null)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("display");
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            dispatcher.forward(request,response);
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            request.setAttribute("invalid","<span>Invalid Credentials...</span>");
            dispatcher.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
