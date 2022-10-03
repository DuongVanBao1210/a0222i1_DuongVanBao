<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 6/29/2022
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email</title>
</head>
<body>
<form action="/info" method="post">
    <table>
        <tr>
            <td>Languages</td>
            <td>
                <select  name="language" >
                    <option value="English">English</option>
                    <option value="Vietnamese">Vietnamese</option>
                    <option value="Japanese">Japanese</option>
                    <option value="Chinese">Chinese</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>Show
                <select  name="page" >
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                    <option value="30">30</option>
                </select>
                emails per page
            </td>
        </tr>
        <tr>
            <td>Spam filter</td>
            <td>
                <input type="checkbox" name="filter" >
                <!-- <input th:field="*{filter}" type="checkbox" name="radio"> Enable spams filter -->
            </td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">Update</button></td>
        </tr>
    </table>
</form>
</body>
</html>
