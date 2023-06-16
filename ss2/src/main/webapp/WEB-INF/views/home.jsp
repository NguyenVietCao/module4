<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Sandwich</title>
</head>
<body>
<br/>
<form action="save" method="post">
    <h1>Sandwich Condiments</h1>
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" name="condiment" id="lettuce" value="lettuce">

    <label for="tomato">Tomato</label>
    <input type="checkbox" name="condiment" id="tomato" value="tomato">

    <label for="mustard">Mustard</label>
    <input type="checkbox" name="condiment" id="mustard" value="mustard">

    <label for="sprouts">Sprouts</label>
    <input type="checkbox" name="condiment" id="sprouts" value="sprouts">
    <br>
    <br>
    <button type="submit">Save</button>
</form>
<br>
<br>
<br>
${result}
</body>
</html>