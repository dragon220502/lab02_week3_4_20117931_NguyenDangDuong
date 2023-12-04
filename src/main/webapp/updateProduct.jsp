
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>UPDATE PRODUCT</title>
    <%
        long id=Long.parseLong(request.getParameter("id"));
    %>
    <%@include file="ft.jsp"%>
</head>
<body>
<h1>Cập nhập sản phẩm</h1>
<form class="container" action="control-servlet?action=updateProduct" method="post">
    <div class="mb-3">
        <label for="name" class="form-label">Full Name</label>
        <input type="text" class="form-control" id="name" name="name">
    </div>
    <div class="mb-3">
        <label for="decription" class="form-label">Decription</label>
        <input type="text" class="form-control"  id="decription" name="decription">
    </div>
    <div class="mb-3">
        <label for="manufacturer" class="form-label">Manufacturer</label>
        <input type="text" class="form-control" id="manufacturer" name="manufacturer">
    </div>
    <div class="mb-3">
        <label for="unit" class="form-label">Unit</label>
        <input type="text" class="form-control" id="unit" name="unit">
    </div>
    <div class="mb-3">
        <label for="status" class="form-label">Status</label>
        <select class="form-select" id="status" name="status">
            <option selected="true" value="DANGKINHDOANG">DANG KINH DOANG</option>
            <option value="KHONGKINHDOANG">KHONG KINH DOANG</option>
            <option value="TAMNGUNG">TAM NGUNG</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-secondary">Clear</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
