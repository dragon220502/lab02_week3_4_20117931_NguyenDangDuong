<%@ page import="dangduong.vn.edu.iuh.ongk.backend.services.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ page import="dangduong.vn.edu.iuh.ongk.backend.models.Employee" %>
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
    EmployeeService em = new EmployeeService();
    List<Employee> emp = em.getAll();
%>
<table class="table table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Address</th>
        <th>Date of Birth</th>
        <th>Email</th>
        <th>Full Name</th>
        <th>Phone</th>
        <th>Status</th>
        <th><a href="insertEmployee.jsp" class="btn btn-success">Thêm mới </a></th>
    </tr>
    </thead>
    <tbody>
    <% for (Employee employee:emp){ %>
    <tr>
        <td><%=employee.getEmpId()%></td>
        <td><%= employee.getAddress() %></td>
        <td><%= employee.getDob() %></td>
        <td><%= employee.getEmail() %></td>
        <td><%= employee.getFull_name() %></td>
        <td><%= employee.getPhone() %></td>
        <td><%= employee.getStatus() %></td>
        <td>
            <a href="<%="updateEmployee.jsp?id="+employee.getEmpId()%>" class="btn btn-primary">Update</a>
            <a href="<%="control-servlet?action=deleteEmp&id="+employee.getEmpId()%>" class="btn btn-danger">Delete</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
