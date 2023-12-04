
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
<form class="container" action="control-servlet?action=insertProduct" method="post" enctype="multipart/form-data">
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" name="name">
    </div>
    <div class="mb-3">
        <label for="image" class="form-label">Name</label>
        <input type="file" class="form-control" id="image" name="image"  size="60">
    </div>
    <div class="mb-3">
        <label for="decription" class="form-label">Decription</label>
        <textarea class="form-control"  id="decription" name="decription" rows="3"></textarea>
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
        <label for="price" class="form-label">Price</label>
        <input type="number" class="form-control" id="price" name="price">
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
