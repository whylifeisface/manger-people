<%@ page import="java.util.List" %>
<%@ page import="com.example.demo2.entity.Address" %><%--
  Created by IntelliJ IDEA.
  User: lishifu
  Date: 2023/11/6
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>
    人事管理系统V1.0
</h1>
<h3>
    ------------查询界面
</h3>
<table border="1" width="500">
    <tr>
        <td>姓名</td>
        <td>街道</td>
        <td>城市</td>
        <td>省份</td>
        <td>邮编</td>
        <td>操作</td>
        <td>添加新纪录</td>
    </tr>
    <%
        List<Address> list = (List<Address>) request.getAttribute("list");
        for (Address address : list) {

    %>
    <tr>
        <td>
            <%=address.getName()%>
        </td>
        <td>
            <%=address.getStreet()%>
        </td>
        <td>
            <%=address.getCity()%>
        </td>
        <td>
            <%=address.getState()%>
        </td>
        <td>
            <%=address.getZip()%>
        </td>
        <td>
            <a href="addressServlet?method=todelete&id=<%= address.getId() %>">
                删除
            </a>
        </td>
        <td>
            <a href="addressServlet?method=toedit&id=<%= address.getId() %>">
                编辑
            </a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
