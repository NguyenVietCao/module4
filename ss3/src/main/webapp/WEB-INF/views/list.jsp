<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 19/06/2023
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email List</title>
</head>
<body>
<h2 class="text-center">Email List</h2>
<h4 style="color: aqua " class="text-center">${message}</h4>
<table class="table table-striped table-inverse table-responsive" >
    <thead>
    <tr>
        <th>ID</th>
        <th>Languages</th>
        <th>Page size</th>
        <th>Spams filter</th>
        <th>Signature</th>
        <th></th>
    </tr>
    <c:forEach items = "${mailList}" var = "mail">
        <tr>
            <td>${mail.id}</td>
            <td>${mail.languages}</td>
            <td>${mail.pageSize}</td>
            <td>${mail.spamsFilter}</td>
            <td>${mail.signature}</td>
            <td><a href="/update?id=${mail.id}">Update</a></td>
            <td></td>
        </tr>

    </c:forEach>
    </thead>

</table>
</body>
</html>
