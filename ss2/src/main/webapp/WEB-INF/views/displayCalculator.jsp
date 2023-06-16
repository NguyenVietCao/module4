<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 16/06/2023
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
<form action="calculator" method="post">
    <h1>Calculate</h1>
    <input type="number" name="input1">
    <input type="number" name="input2">
    <br>
    <br>
    <button type="submit" name="button" value="addition">Addition (+)</button>
    <button type="submit" name="button" value="subtraction">Subtraction (-)</button>
    <button type="submit" name="button" value="multiplication">Multiplication (x)</button>
    <button type="submit" name="button" value="division">Division ( / )</button>
</form>
${result}
<h1>${message}</h1>
</body>
</html>
