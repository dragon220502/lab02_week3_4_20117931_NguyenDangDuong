package dangduong.vn.edu.iuh.ongk.fontend.controllers;

import dangduong.vn.edu.iuh.ongk.fontend.model.EmployeeModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.OPTIONS;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/controllers")
public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object option = req.getParameter("action");
            if (option!=null){
                if(option.equals("insert")){
                    EmployeeModel abc = new EmployeeModel();
                    abc.insert(req,resp);
                }
                else if(option.equals("update")){
                    long id= Long.parseLong(req.getParameter("id"));
                    EmployeeModel abc = new EmployeeModel();
                    abc.uodate(req, resp);
                }

            }

        }catch (Exception ex){
            throw new RuntimeException();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object option = req.getParameter("action");
            if (option!=null){
                if(option.equals("list")){
                    EmployeeModel abc = new EmployeeModel();
                    abc.insert(req,resp);
                }
                else if(option.equals("delete")){
                    long id= Long.parseLong(req.getParameter("id"));
                    EmployeeModel abc = new EmployeeModel();
                    abc.delete(req, resp);
                }

            }

        }catch (Exception ex){
            throw new RuntimeException();
        }
    }
}
