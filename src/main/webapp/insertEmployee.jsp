<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 25/10/2023
  Time: 1:16 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Employee</title>
</head>
<body>
<form action="controllers?action=insert" method="post">
    <label>fullname</label> <input type="text" name="fullname"/><br/>
    <label>dob</label> <input type="date" name="dob"/><br/>
    <label>email</label> <input type="email" name="email"/><br/>
    <label>phone</label> <input type="text" name="phone"/><br/>
    <label>address</label> <textarea cols="10" rows="10" name="address"></textarea><br/>
    <label>status</label><select name="status">
    <option selected="true" label="DANGLAM">DANGLAM</option>
    <option  label="NGHI">NGHI</option>
    <option  label="TAMNGUNG">TAM NGUNG</option>
</select>
    <input type="submit" value="Chonanh"/>
    <input type="reset" value="Clear"/>
</form>
</body>
</html>
