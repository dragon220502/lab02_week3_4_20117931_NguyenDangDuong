package dangduong.vn.edu.iuh.ongk.fontend.model;


import dangduong.vn.edu.iuh.ongk.backend.enums.EmployeeStatus;
import dangduong.vn.edu.iuh.ongk.backend.models.Employee;
import dangduong.vn.edu.iuh.ongk.backend.services.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmployeeModel {
    private EmployeeService employeeService;

    public EmployeeModel(){
        this.employeeService = new EmployeeService();
    }
    public void insertEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
        String fullname = req.getParameter("fullname").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();
        String address = req.getParameter("address").trim();
        String statusStr = req.getParameter("status").trim();
        String dateOfBirth = req.getParameter("dob");

        EmployeeStatus employeeStatus = EmployeeStatus.valueOf(statusStr);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateOfBirth, formatter);

        Employee employee = new Employee(fullname, email, phone, address, localDate, employeeStatus);
        employeeService.create(employee);
        resp.sendRedirect("listEmp.jsp");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String fullname = req.getParameter("fullname").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();
        String address = req.getParameter("address").trim();
        String statusStr = req.getParameter("status").trim();
        String dateOfBirth = req.getParameter("dob").trim();
        EmployeeStatus employeeStatus = EmployeeStatus.valueOf(statusStr);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateOfBirth, formatter);

        Employee employee = new Employee(id, fullname, email, phone, address, localDate, employeeStatus);
        employeeService.update(employee);
        resp.sendRedirect("listEmp.jsp");
    }
    public void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        employeeService.delete(id);
        resp.sendRedirect("listEmp.jsp");
    }
    public void getEmployeeList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Employee> employees = employeeService.getAll();
        req.getSession().setAttribute("employees", employees);
        resp.sendRedirect("listEmp.jsp");
    }

}
