package dangduong.vn.edu.iuh.ongk.fontend.model;

import dangduong.vn.edu.iuh.ongk.backend.models.GioHang;
import dangduong.vn.edu.iuh.ongk.backend.services.ProductPriceService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/insert-product")
public class insertProdcutModel extends HttpServlet {
    @Inject
    private ProductPriceService productPriceServices;
    public void init() {
        productPriceServices = new ProductPriceService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            int id = Integer.parseInt(req.getParameter("id"));
            HttpSession session = req.getSession();
            ArrayList<GioHang> cart_list = (ArrayList<GioHang>) session.getAttribute("giohang");

            if (cart_list == null) {
                ArrayList<GioHang> carts = new ArrayList<>();
                GioHang cart = new GioHang();
                cart.setId(id);
                cart.setQuantity(1);
                carts.add(cart);
                session.setAttribute("cart-list", carts);
            } else {
                boolean found = false;
                for (GioHang c : cart_list) {
                    if (c.getId() == id) {
                        c.setQuantity(c.getQuantity() + 1);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    GioHang cart = new GioHang();
                    cart.setId(id);
                    cart.setQuantity(1);
                    cart_list.add(cart);
                }
                session.setAttribute("cart-list", cart_list);
            }
            resp.sendRedirect("index.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}

