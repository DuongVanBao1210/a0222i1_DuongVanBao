<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 10/3/2022
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sandwich" method="post">
    <lable>Sandwich Condiments</lable>
    </br>
    <input type="checkbox" name="sandwich" value="Lettuce">
    <input type="checkbox" name="sandwich" value="Tomato">
    <input type="checkbox" name="sandwich" value="Mustard">
    <input type="checkbox" name="sandwich" value="Sprouts"></br>
    <button type="submit">Save</button>
</form>

<c:forEach items="${sandwich}" var="sandwich">
    <p>${sandwich}</p>
</c:forEach>
</body>
</html>
