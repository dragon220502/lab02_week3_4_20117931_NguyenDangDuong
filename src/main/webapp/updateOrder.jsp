

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>UPDATE ORDER</title>
    <%
        long id=Long.parseLong(request.getParameter("id"));
    %>
    <%@include file="ft.jsp"%>
</head>
<body>
<h1>UPDATE ORDER</h1>
<form class="container" action="control-servlet?action=updateOrder" method="post">
    <div class="mb-3">
        <label for="Date" class="form-label">Date</label>
        <input type="date" class="form-control" id="Date" name="Date">
    </div>
    <div class="mb-3">
        <label for="customerID" class="form-label">Customer ID</label>
        <input type="number" class="form-control" id="customerID" name="customerID">
    </div>
    <div class="mb-3">
        <label for="employeeID" class="form-label">Employee ID</label>
        <input type="number" class="form-control" id="employeeID" name="employeeID">
    </div>
    <button type="submit" class="btn btn-primary">Save</button>
    <button type="reset" class="btn btn-secondary">Clear</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
