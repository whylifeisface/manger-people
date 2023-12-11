<%@ page import="com.example.demo2.entity.Address" %><%--
  Created by IntelliJ IDEA.
  User: lishifu
  Date: 2023/11/20
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Address address = (Address) request.getAttribute("address");
        System.out.println(address.getId());
%>

<form action="addressServlet" method="post">
    Name: <input name="Name" type="text" value="<%= address.getName() %>">
    <br>

    Street: <input name="Street" type="text" value="<%= address.getStreet() %>">
    <br>

    City: <input name="City" type="text" value="<%= address.getCity() %>">
    <br>

    State: <input name="State" type="text" value="<%= address.getState() %>">
    <br>

    Zip: <input name="Zip" type="text" value="<%= address.getZip() %>" >
    <br>
    Name: <input name="id" type="hidden" value="<%= address.getId() %>">

    <input type="submit" value="update">
</form>


</body>
</html>
