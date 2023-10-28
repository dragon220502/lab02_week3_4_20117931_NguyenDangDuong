<%@ page import="dangduong.vn.edu.iuh.ongk.backend.services.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ page import="dangduong.vn.edu.iuh.ongk.backend.models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 25/10/2023
  Time: 12:58 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
    <%
        EmployeeService em = new EmployeeService();
        List<Employee> emp = em.getAll();
    %>
    <table width="80%" align="center">
        <tr>
            <td>addres</td>
            <td>dob</td>
            <td>email</td>
            <td>fullname</td>
            <td>phone</td>
            <td>status</td>

        </tr>
        <% for (Employee employee:emp){%>
        <tr>
            <td><%=employee.getAddress()%></td>
            <td><%=employee.getDob()%></td>
            <td><%=employee.getEmail()%></td>
            <td><%=employee.getFull_name()%></td>
            <td><%=employee.getPhone()%></td>
            <td><%=employee.getStatus()%></td>

            <td>
                <a href=<%="updateEmployee.jsp?id="+employee.getEmpId()%>>Update</a>
                <a href=<%="controllers?action=delete&id="+ employee.getEmpId()%>>Delete</a>
                <a href="insertEmployee.jsp">insert</a>
            </td>
        </tr>
        <%}%>
    </table>
</body>
</html>
