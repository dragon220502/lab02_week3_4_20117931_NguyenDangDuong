
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>UPDATE EMPLOYEE</title>
    <%
        long id=Long.parseLong(request.getParameter("id"));
    %>
    <%@include file="ft.jsp"%>
</head>
<body>
<h1>Cập nhật nhân viên</h1>
<form class="container" action="<%="control-servlet?action=updateEmp&id="+id%>" method="post">
    <div class="mb-3">
        <label for="fullname" class="form-label">Họ và tên</label>
        <input type="text" class="form-control" id="fullname" name="fullname">
    </div>
    <div class="mb-3">
        <label for="dob" class="form-label">Ngày sinh</label>
        <input type="date" class="form-control "style="width: 140px" id="dob" name="dob">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" id="email" name="email">
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label">Số điện thoại</label>
        <input type="text" class="form-control" id="phone" name="phone">
    </div>
    <div class="mb-3">
        <label for="address" class="form-label">Địa chỉ</label>
        <textarea class="form-control" id="address" name="address" rows="3"></textarea>
    </div>
    <div class="mb-3">
        <label for="status" class="form-label">Trạng thái</label>
        <select class="form-select" id="status" name="status">
            <option selected="true" value="DANGLAM">ĐANG LÀM</option>
            <option value="NGHI">NGHỈ</option>
            <option value="TAMNGUNG">TẠM NGỪNG</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
    <button type="reset" class="btn btn-secondary">Clear</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
