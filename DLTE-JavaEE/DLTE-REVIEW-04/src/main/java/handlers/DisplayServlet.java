package handlers;

import com.google.gson.Gson;
import dbase.DBOperations;
import lombok.SneakyThrows;
import org.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DisplayServlet",value="/fetch")
public class DisplayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();
        DBOperations dbOperations = new DBOperations();
        List<Student> list = dbOperations.fetch();
        Gson gson = new Gson();
        pw.write(gson.toJson(list));
        System.out.println((gson.toJson(list)));
    }
}
