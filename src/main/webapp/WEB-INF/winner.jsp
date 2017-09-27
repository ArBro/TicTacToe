<%--
  Created by IntelliJ IDEA.
  User: arbro
  Date: 19-7-17
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Winner</title>
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
            <div class="col-sm-12" align="center">
                <h4>${game.announceWinner()}</h4>
            </div>
            <div class="col-sm-12" align="center">
                <%@include file="directives/staticboard.jsp"%>
                <br>
            </div>
            <div class="col-sm-12" align="center">
                <a class="col-sm-1" href="initgame"><input class="btn btn-primary" type="button" value="New Game"></a>
                <a class="col-sm-1" href="exitgame"><input class="btn" type="button" value="Exit Game"></a>
            </div>
        </div>
    </div>
</body>
</html>
