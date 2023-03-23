<%--
  Created by IntelliJ IDEA.
  User: xxshetug
  Date: 3/23/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Address</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    </head>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--<c:set var = "id" value ="${param.reg}" />--%>
<sql:setDataSource var="connection" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="GOURAV" password="Gourav22512"/>
<sql:query var="qry" dataSource="${connection}" >select * from address_new,address_mapper where address_mapper.reg_no=? and address_mapper.add_id=address_new.address_id <sql:param value="${param.reg}"/> </sql:query>
<div class="container">
    <div class="card mt-3" >
        <div class="card-header">
            Current Address
        </div>
        <div class="card-body">
            <ul class="card-text">
                <li>${qry.rows[0].door_no}</li>
                <li>${qry.rows[0].street}</li>
                <li>${qry.rows[0].city}</li>
                <li>${qry.rows[0].pincode}</li>
            </ul>
        </div>
    </div>

<div class="card mt-3" >
    <div class="card-header">
        Permanent Address
    </div>
    <div class="card-body">
        <ul class="card-text">
            <li>${qry.rows[1].door_no}</li>
            <li>${qry.rows[1].street}</li>
            <li>${qry.rows[1].city}</li>
            <li>${qry.rows[1].pincode}</li>
        </ul>
    </div>
</div>
</div>
</body>
</html>
