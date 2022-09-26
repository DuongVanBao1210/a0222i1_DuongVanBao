<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 6/27/2022
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>
<body>

<form action="/calc" method="post">
    <div class="form-group">
        <label>Number1</label>
        <input type="number" class="form-control" name="number1" value="${number1}" >
    </div>
    <div class="form-group">
        <label>Number2</label>
        <input type="number" class="form-control" name="number2" value="${number2}">
    </div>
    <button type="submit" name="Submit" class="btn btn-primary" value="cong">Cong</button>
    <button type="submit" name="Submit" class="btn btn-primary" value="tru">Tru</button>
    <button type="submit" name="Submit" class="btn btn-primary" value="nhan">Nhan</button>
    <button type="submit" name="Submit" class="btn btn-primary" value="chia">Chia</button>
</form>
<h3>Result: ${result}</h3>
</body>
</html>
