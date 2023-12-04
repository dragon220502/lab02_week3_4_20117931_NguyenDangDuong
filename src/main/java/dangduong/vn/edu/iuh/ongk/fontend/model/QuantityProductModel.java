package dangduong.vn.edu.iuh.ongk.fontend.model;

import dangduong.vn.edu.iuh.ongk.backend.models.GioHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/quantity")
public class QuantityProductModel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter();) {
            String action = req.getParameter("action");
            long id = Long.parseLong(req.getParameter("id"));
            HttpSession session = req.getSession();
            ArrayList<GioHang> gioHangList = (ArrayList<GioHang>) session.getAttribute("cart-list");

            System.out.println(gioHangList);
            if (action != null && gioHangList != null) {
                if (action.equals("inc")) {
                    for (GioHang c : gioHangList) {
                        if (c.getId() == id) {
                            int quatity = c.getQuantity();
                            quatity++;
                            c.setQuantity(quatity);
                            resp.sendRedirect("cart.jsp");
                        }
                    }
                }
                if (action.equals("dec")) {
                    for (GioHang c : gioHangList) {
                        if (c.getId() == id) {
                            int quatity = c.getQuantity();
                            quatity--;
                            if (quatity <= 1)
                                quatity = 1;
                            c.setQuantity(quatity);
                            resp.sendRedirect("cart.jsp");
                        }
                    }
                }
                if (action.equals("delete")) {
                    GioHang cart = null;
                    for (GioHang c : gioHangList) {
                        if (c.getId() == id) {
                            cart = c;
                            break;
                        }
                    }
                    if (cart != null) {
                        gioHangList.remove(cart);
                    }
                    resp.sendRedirect("cart.jsp");
                }

            } else {
                resp.sendRedirect("cart.jsp");
            }

        }
    }
}