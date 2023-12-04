<%@ page import="dangduong.vn.edu.iuh.ongk.backend.services.ProductService" %>
<%@ page import="dangduong.vn.edu.iuh.ongk.backend.services.ProductPriceService" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="dangduong.vn.edu.iuh.ongk.backend.models.GioHang" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dangduong.vn.edu.iuh.ongk.backend.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 04/12/2023
  Time: 9:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<%
    ProductService productServices = new ProductService();
    ProductPriceService productPriceServices = new ProductPriceService();
    DecimalFormat dcf = new DecimalFormat("#.##");
    request.setAttribute("dcf", dcf);
    Double total = 0.0;
    List<GioHang> gioHangs = null;
    ArrayList<GioHang> list = (ArrayList<GioHang>) session.getAttribute("cart-list");
    if (list != null && !list.isEmpty()) {

        for (GioHang c : list) {
            Double price = productPriceServices.getNewPriceByIdProduct(String.valueOf(c.getId()));
            total += price * c.getQuantity();
        }
        gioHangs =list;
        request.setAttribute("list", list);
        request.setAttribute("total", total);
    }
%>

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center py-3">
        <div class="d-flex align-items-center">
            <h1 class="mr-3">Total Price:</h1>
            <h2 style="color: red">$ ${(total > 0) ? dcf.format(total) : 0}</h2>
        </div>
        <a class="btn btn-primary" href="#">Check Out</a>

        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="danhSachSanPhamClient.jsp">List product</a></li>
            <li class="nav-item">
                <a class="nav-link" href="gioHang.jsp">Cart <span class="badge badge-danger">${list.size()!=null?list.size():0}</span></a>
            </li>
            <li class="nav-item"><a class="nav-link" href="index.jsp">Back to home</a></li>
        </ul>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Category</th>
            <th scope="col">Price</th>
            <th scope="col">Buy Now</th>
            <th scope="col">Cancel</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (list != null) {
                for (GioHang c : gioHangs) {
                    Double price = productPriceServices.getNewPriceByIdProduct(String.valueOf(c.getId()));
                    Product product = productServices.findOne(Long.valueOf(c.getId())).get();
                    if (product != null && price != null) {
        %>
        <tr>
            <td><%= product.getName() %></td>
            <td><%= product.getUnit() %></td>
            <td><%= dcf.format(price * c.getQuantity()) %> $</td>
            <td>
                <form action="order-now" method="get" class="form-inline">
                    <input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
                    <div class="form-group d-flex justify-content-between w-50">
                        <a class="btn btn-sm btn-incre" href="quantity?action=inc&id=<%= c.getId() %>"><i class="fas fa-plus-square"></i></a>
                        <input type="text" name="quantity" class="form-control w-50 text-center" value="<%= c.getQuantity() %>" readonly>
                        <a class="btn btn-sm btn-decre" href="quantity?action=dec&id=<%= c.getId() %>"><i class="fas fa-minus-square"></i></a>
                    </div>
                    <button type="submit" class="btn btn-primary btn-sm">Buy</button>
                </form>
            </td>
            <td><a class="btn btn-sm btn-danger" href="quantity?action=delete&id=<%= c.getId() %>">Remove</a></td>
        </tr>
        <% }
        }
        }
        %>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
