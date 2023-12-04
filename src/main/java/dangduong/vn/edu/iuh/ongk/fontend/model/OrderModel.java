package dangduong.vn.edu.iuh.ongk.fontend.model;

import dangduong.vn.edu.iuh.ongk.backend.models.Customer;
import dangduong.vn.edu.iuh.ongk.backend.models.Employee;
import dangduong.vn.edu.iuh.ongk.backend.models.Order;
import dangduong.vn.edu.iuh.ongk.backend.services.CustomerService;
import dangduong.vn.edu.iuh.ongk.backend.services.EmployeeService;
import dangduong.vn.edu.iuh.ongk.backend.services.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class OrderModel {
    private OrderService orderService;
    private CustomerService customerService;
    private EmployeeService employeeService;
    public OrderModel(){
        this.orderService = new OrderService();
        this.customerService = new CustomerService();
        this.employeeService = new EmployeeService();
    }

    public void addOrder(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        String createDateStr = req.getParameter("Date");
        long customerIdStr = Long.parseLong(req.getParameter("cust"));
        long employeeIdStr = Long.parseLong(req.getParameter("emp"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(createDateStr, formatter);
        Order order = new Order(new Customer(customerIdStr), new Employee(employeeIdStr), localDate);
        orderService.add(order);
        resp.sendRedirect("listOrder.jsp");

    }
    public void updateOrder(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String createDateStr = req.getParameter("Date");
        long customerIdStr = Long.parseLong(req.getParameter("cust"));
        long employeeIdStr = Long.parseLong(req.getParameter("emp"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(createDateStr, formatter);
        Order order = new Order(id,localDate,new Customer(customerIdStr), new Employee(employeeIdStr));
        orderService.update(order);
        resp.sendRedirect("listOrder.jsp");
    }
    public void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        orderService.delete(id);
        resp.sendRedirect("listOrder.jsp");
    }
    public void getAllOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Order> orderList = orderService.findAll();
        req.getSession().setAttribute("order", orderList);
        resp.sendRedirect("listOrder.jsp");
    }
}
