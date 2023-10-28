package dangduong.vn.edu.iuh.ongk.fontend.model;


import dangduong.vn.edu.iuh.ongk.backend.enums.EmployeeStatus;
import dangduong.vn.edu.iuh.ongk.backend.models.Employee;
import dangduong.vn.edu.iuh.ongk.backend.services.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmployeeModel {
    private final EmployeeService empsve = new EmployeeService();
   public void insert( HttpServletRequest request, HttpServletResponse response) throws Exception{
        String fullname = request.getParameter("fullname");
       String dob = request.getParameter("dob");
       String email = request.getParameter("email");
       String phone = request.getParameter("phone");
       String address = request.getParameter("address");
       String status = request.getParameter("status");

       DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
       LocalDate day = LocalDate.parse(dob,date);
       Employee s1 = new Employee(fullname,email,phone,address,day, EmployeeStatus.valueOf(status));
       System.out.println(s1);
       empsve.insert(s1);
       response.sendRedirect("listEmp.jsp");
   }
   public List<Employee> getAllEmployee(){
       return empsve.getAll();
   }
    public void uodate( HttpServletRequest request, HttpServletResponse response) throws Exception{
        String fullname = request.getParameter("fullname");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        long id = Long.parseLong(request.getParameter("id"));
        // Cập nhật các thuộc tính của nhân viên
        Employee e = empsve.find(id);
        e.setStatus(EmployeeStatus.valueOf(status));
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate day = LocalDate.parse(dob,date);
        e.setDob(day);
        e.setAddress(address);
        e.setEmail(email);
        e.setPhone(phone);
        e.setFull_name(fullname);
        empsve.update(e);
        response.sendRedirect("listEmp.jsp");
    }
    public void delete( HttpServletRequest request, HttpServletResponse response) throws Exception{
        long id = Long.parseLong(request.getParameter("id"));
        // Cập nhật các thuộc tính của nhân viên
        Employee e = empsve.find(id);
        empsve.delete(e);
        response.sendRedirect("listEmp.jsp");
    }

}
