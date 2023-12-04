
<%@ page import="java.util.List" %>
<%@ page import="dangduong.vn.edu.iuh.ongk.backend.services.CustomerService" %>
<%@ page import="dangduong.vn.edu.iuh.ongk.backend.models.Customer" %>
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
    CustomerService em = new CustomerService();
    List<Customer> emp = em.getAll();
%>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Address</th>
        <th>Email</th>
        <th>Phone</th>
        <th><a href="insertCus.jsp" class="btn btn-success">Thêm mới </a></th>
    </tr>
    </thead>
    <tbody>
    <% for (Customer employee:emp){ %>
    <tr>
        <td><%=employee.getCustId()%></td>
        <td><%= employee.getCustName() %></td>
        <td><%= employee.getAddress()%></td>
        <td><%= employee.getEmail() %></td>
        <td><%= employee.getPhone() %></td>
        <td>
            <a href="<%="updateCust.jsp?id="+employee.getCustId()%>" class="btn btn-primary">Update</a>
            <a href="<%="control-servlet?action=deleteCust&id="+employee.getCustId()%>" class="btn btn-danger">Delete</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
