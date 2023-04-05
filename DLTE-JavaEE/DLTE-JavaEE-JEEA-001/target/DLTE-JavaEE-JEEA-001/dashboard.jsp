<%--
  Created by IntelliJ IDEA.
  User: xxshetug
  Date: 3/20/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h2>Helloooooooooo</h2>
    <%@ taglib prefix="db" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
    <db:setDataSource var="payeeeDb" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="Gourav@2512"/>
    <db:query var="schema" sql="alter session set current_schema =GOURAV" dataSource="${payeeeDb}"/>
    <db:query var="payees" sql="select name,acc_no from payeee" dataSource="${payeeeDb}"/>
    <div class="table-responsive">
        <table class="table text-info table-striped p-2 shadow-lg text-nowrap" cellspacing="1px" cellpadding="1px">
            <thead>
            <tr>
                <th>Name</th><th>Account Number</th>
            </tr>
            </thead>
            <tbody>
            <core:forEach var="payee" items="${payees.rows}">
                <tr>
                    <td>${payee.name}</td><td>${payee.acc_no}</td>
<%--                    <td>--%>
<%--                        <a href="edit.jsp?id=${customer.acc_number}" class="btn btn-outline-warning">--%>
<%--                            <i class="bi bi-pencil-square"></i>--%>
<%--                        </a>--%>
<%--                        <a class="btn btn-outline-danger">--%>
<%--                            <i class="bi bi-person-x"></i>--%>
<%--                        </a>--%>
<%--                    </td>--%>
                </tr>
            </core:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
