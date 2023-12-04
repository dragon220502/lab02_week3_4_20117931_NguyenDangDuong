<%@ page import="dangduong.vn.edu.iuh.ongk.backend.services.ProductService" %>
<%@ page import="dangduong.vn.edu.iuh.ongk.backend.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="dangduong.vn.edu.iuh.ongk.backend.models.GioHang" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="ft.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    ProductService productServices = new ProductService();
    List<Product> lst = productServices.findAll();
    ArrayList<GioHang> list = (ArrayList<GioHang>) session.getAttribute("giohang");
    int size = (list != null) ? list.size() : 0;

    if (list != null) {
        request.setAttribute("giohang", list);
    }
%>

<div class="container mt-5">
    <div class="row">
        <div class="col-md-12 mb-3">
            <a class="btn btn-primary btn-sm float-right" href="gioHang.jsp">
                Giỏ hàng
                <% if (size > 0) { %>
                <div class="badge badge-danger">
                    <span><%= size %></span>
                </div>
                <% } %>
            </a>
        </div>
    </div>

    <div class="row">
        <% if (!lst.isEmpty()) {
            for (Product p : lst) { %>
        <div class="col-lg-3 col-md-4 col-sm-6 mb-4">
            <div class="card">
                <img class="card-img-top" src="<%= p.getProductImageList().get(0).getPath() %>" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title"><%= p.getName() %></h5>
                    <h6 class="price"><%="$ " + p.getProductPrices().get(0).getPrice() %></h6>
                    <h6 class="Manu"><%= p.getManufacturerName() + "&nbsp;&nbsp;" + p.getUnit() %></h6>
                    <div class="btn-group">
                        <a href="insert-product?id=<%= p.getProdcctId() %>" class="btn btn-dark">Thêm vào giỏ</a>
                        <a href="#" class="btn btn-primary">Mua ngay</a>
                    </div>
                </div>
            </div>
        </div>
        <% }
        } %>
    </div>
</div>
