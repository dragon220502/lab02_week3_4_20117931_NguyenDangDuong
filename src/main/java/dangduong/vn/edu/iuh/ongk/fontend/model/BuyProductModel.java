package dangduong.vn.edu.iuh.ongk.fontend.model;

import dangduong.vn.edu.iuh.ongk.backend.models.GioHang;
import dangduong.vn.edu.iuh.ongk.backend.models.Order;
import dangduong.vn.edu.iuh.ongk.backend.models.OrderDetail;
import dangduong.vn.edu.iuh.ongk.backend.models.Product;
import dangduong.vn.edu.iuh.ongk.backend.services.OrderDetailService;
import dangduong.vn.edu.iuh.ongk.backend.services.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/order-now")
public class BuyProductModel extends HttpServlet {
    private OrderService orderService;
    private OrderDetailService orderDetailService;

    public void init() {
        orderService = new OrderService(); // Initialize your OrderService
        orderDetailService = new OrderDetailService(); // Initialize your OrderDetailService
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(PrintWriter out =resp.getWriter()){
            out.print("this buy now servlet");
        }
        String productId = req.getParameter("id");
        double quantity = Double.parseDouble(req.getParameter("quantity"));
        double price = Double.parseDouble(req.getParameter("price"));

        Product product = new Product(); // Assuming product creation using productId

        LocalDateTime orderDate = LocalDateTime.now();

        Order order = new Order( /* provide required arguments */);

        OrderDetail orderDetail = new OrderDetail( product,order, quantity, price, "Additional note");

        boolean result = orderService.add(order);
        orderDetailService.insert(orderDetail);

        List<Order> orders = orderService.findAll();
        req.setAttribute("orders", orders);
        if(result){
            ArrayList<GioHang> list = (ArrayList<GioHang>) req.getSession().getAttribute("cart-list");
            if(list != null){
                for (GioHang c: list){
                    if(c.getId() == Long.parseLong(productId)){
                        list.remove(list.indexOf(c));
                    }
                }
                resp.sendRedirect("cart.jsp");
            }

        }
        resp.sendRedirect("orders.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}