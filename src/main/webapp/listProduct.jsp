<%@ page import="dangduong.vn.edu.iuh.ongk.backend.services.ProductService" %>
<%@ page import="java.util.List" %>
<%@ page import="dangduong.vn.edu.iuh.ongk.backend.models.Product" %>
<%@ include file="ft.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

    <title>List Product</title>
    <style>
        table {
            width: 80%;
            margin: 0 auto;
        }
        th, td {
            text-align: center;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<%
    ProductService productService = new ProductService();
    List<Product> products = productService.findAll();
%>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Image</th>
        <th>Name</th>
        <th>Description</th>
        <th>Manufactorer</th>
        <th>Unit</th>
        <th>Status</th>
        <th>Price</th>
        <th><a href="insertProduct.jsp" class="btn btn-success">Thêm mới </a></th>
    </tr>
    </thead>
    <tbody>
    <% for (Product product:products){ %>
    <tr>
        <td><%=product.getProdcctId()%></td>
        <td>
            <img style="width: 50px; height: 50px" src="<%=(product.getProductImageList().get(0).getPath())%>">
        </td>
        <td><%= product.getName() %></td>
        <td><%= product.getDescription() %></td>
        <td><%= product.getManufacturerName() %></td>
        <td><%= product.getUnit()%></td>
        <td><%= product.getStatus() %></td>
        <td><%= product.getProductPrices().get(0).getPrice() %></td>
        <td>
            <a href="<%="updateProduct.jsp?id="+product.getProdcctId()%>" class="btn btn-primary">Update</a>
            <a href="<%="control-servlet?action=deleteProduct&id="+product.getProdcctId()%>" class="btn btn-danger">Delete</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
