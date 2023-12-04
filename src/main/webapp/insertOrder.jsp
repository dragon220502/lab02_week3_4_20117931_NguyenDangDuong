
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <%@include file="ft.jsp"%>
    <title>Insert Employee</title>
    <style>
        label {
            margin-top: 10px;
            display: block;
        }
        input[type="text"],
        input[type="date"],
        input[type="email"],
        select,
        textarea {
            width: 100%;
            padding: 0.375rem 0.75rem;
            font-size: 1rem;
            line-height: 1.5;
            color: #495057;
            background-color: #fff;
            background-clip: padding-box;
            border: 1px solid #ced4da;
            border-radius: 0.25rem;
            transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
        }
        select {
            height: calc(2.25rem + 2px);
        }
        textarea {
            resize: vertical;
        }
    </style>
</head>
<body>
<form class="container" action="control-servlet?action=insertOrder" method="post">
    <div class="mb-3">
        <label for="Date" class="form-label">Date</label>
        <input type="date" class="form-control" id="Date" name="Date">
    </div>
    <div class="mb-3">
        <label for="cust" class="form-label">Customer ID</label>
        <input type="number" class="form-control" id="cust" name="cust">
    </div>
    <div class="mb-3">
        <label for="emp" class="form-label">Employee ID</label>
        <input type="number" class="form-control" id="emp" name="emp">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-secondary">Clear</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
