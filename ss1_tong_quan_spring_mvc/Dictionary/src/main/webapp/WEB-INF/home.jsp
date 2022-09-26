<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 6/24/2022
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result" method="post">
    <input type="text" name="word" value="${word}">
    <input type="submit" value="Translate">
</form>
<h1>Result: ${result}</h1>
</body>
</html>
