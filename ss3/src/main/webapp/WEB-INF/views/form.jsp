<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 19/06/2023
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form mail update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form:form method="post" action="/edit" modelAttribute="email">
<form:hidden path="id"/>
    <h2 class="text-center">Setting</h2>
    <hr>
    <table>
        <tr>
            <td>Languages: </td>
            <td>
                <form:select path="languages">
                    <form:options items="${languagesList}"/>
                </form:select>
            </td>
        </tr>
        <td>Page Size:</td>
        <tr>
            <td>
                show
                <form:select path="pageSize">
                    <form:options items="${pageSizeList}"/>
                </form:select>
                email per page
            </td>
        </tr>
        <tr>
            <td>Spams filter</td>
            <td>
                <form:checkbox path="spamsFilter"/>
                Enable spams filter
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button>Update</form:button>
            </td>
        </tr>
    </table>
</form:form>
</body>

</html>
