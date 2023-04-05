<%@ page import="java.util.List" %>
<%@ page import="oraclejdbc.CreditCard" %>
<%--
  Created by IntelliJ IDEA.
  User: xxshetug
  Date: 3/7/2023
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<CreditCard> objects=(List<CreditCard>)request.getAttribute("dbData");
    pageContext.setAttribute("creditcards",objects,PageContext.APPLICATION_SCOPE);
%>
<table>
    <thead>
    <tr>
        <th>Card_Number</th><th>Card_Holder</th><th>Card_Pin</th>
        <th>Card_Expiry</th><th>Limit</th>
    </tr>
    </thead>
    <tbody>
    <% for(CreditCard card:objects){ %>
    <tr>
        <td><%=card.getCardNumber()%></td>
        <td><%=card.getCardHolder()%></td>
        <td><%=card.getCardPin()%></td>
        <td><%=card.getCardExpiry()%></td>
        <td><%=card.getCardLimit()%></td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
