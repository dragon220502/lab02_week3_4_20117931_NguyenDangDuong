
<%@ page import="java.util.List" %>
<%@ page import="dangduong.vn.edu.iuh.ongk.backend.models.Order" %>
<%@ page import="dangduong.vn.edu.iuh.ongk.backend.services.OrderService" %>

<%@ include file="ft.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

    <title>List Employee</title>
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
    OrderService em = new OrderService();
    List<Order> emp = em.findAll();
%>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Customer</th>
        <th>Employee</th>
        <th>Date</th>
        <th><a href="insertOrder.jsp" class="btn btn-success">Thêm mới </a></th>
    </tr>
    </thead>
    <tbody>
    <% for (Order order:emp){ %>
    <tr>
        <td><%=order.getOrderId()%></td>
        <td><%= order.getCustId().getCustName() %></td>
        <td><%= order.getEmployeeId().getFull_name()%></td>
        <td><%= order.getOrderDate() %></td>
        <td>
            <a href="<%="updateOrder.jsp?id="+order.getOrderId()%>" class="btn btn-primary">Update</a>
            <a href="<%="control-servlet?action=deleteOrder&id="+order.getOrderId()%>" class="btn btn-danger">Delete</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
