<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .navbar{
            background-color: rgb(28,28,28);
        }
        .navbar .nav-link{
            color: aliceblue;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light ">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="./image/logo.png" width="50" height="50" class="d-inline-block align-top" alt="Logo">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Cửa hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="control-servlet?action=listProduct">Danh sách sản phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="control-servlet?action=listCust">Danh sách khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="control-servlet?action=listOrder">Danh sách hóa đơn</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="control-servlet?action=listEmp">Danh sách nhân viên</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
