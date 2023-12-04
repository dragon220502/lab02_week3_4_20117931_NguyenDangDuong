package dangduong.vn.edu.iuh.ongk.fontend.model;

import dangduong.vn.edu.iuh.ongk.backend.models.Customer;
import dangduong.vn.edu.iuh.ongk.backend.services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CustomerModel {
    private CustomerService customerService;

    public CustomerModel(){
        this.customerService = new CustomerService();

    }
    public void addCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name").trim();
        String address = req.getParameter("address").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();

        Customer customer = new Customer(name, address, phone, email);
        customerService.create(customer);
        resp.sendRedirect("listCust.jsp");
    }
    public void updateCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name").trim();
        String address = req.getParameter("address").trim();
        String email = req.getParameter("email").trim();
        String phone = req.getParameter("phone").trim();


        Customer customer = new Customer(id,name, address, phone, email);
        customerService.update(customer);
        resp.sendRedirect("listCust.jsp");
    }
    public void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        customerService.delete(id);
        resp.sendRedirect("listCust.jsp");
    }
    public void getCustomerList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Customer> customers = customerService.getAll();
        req.getSession().setAttribute("customers", customers);
        resp.sendRedirect("listCust.jsp");
    }

}
