<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: arbro
  Date: 25-9-17
  Time: 16:32
  Project: tictactoe
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Successful</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.css" rel="stylesheet" type = "text/css">
    <script src="lib/js/jquery-3.2.1.min.js"></script>
    <script src="lib/js/popper.js"></script>
    <script src="lib/js/bootstrap.min.js"></script>
</head>
<body>

    <%@include file="directives/_navbar.html"%>

    <div class="container">
        <div class="row justify-content-center">
            <p class="col-sm-12" align="center">Login was Successful! Welcome ${loggedInUsername} <br/> You are logged in as ${loggedInUserRole}</p>
        </div>
        <div class="row justify-content-center">
            <a class="col-sm-1" href="logout.html"><input class="btn btn-primary" type="button" value="Logout"></a>
        </div>
    </div>

</body>
</html>
