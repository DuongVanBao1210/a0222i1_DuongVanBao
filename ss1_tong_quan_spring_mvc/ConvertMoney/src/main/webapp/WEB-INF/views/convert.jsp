<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 6/24/2022
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result" method="post">
    <input type="number" name="money" value="${money}">
    <select name="value">
        <option value="usd">USD</option>
        <option value="vnd">VND</option>
    </select>
    <input type="submit" value="Convert">
</form>
<h2>Result: ${result} </h2>

</body>
</html>
