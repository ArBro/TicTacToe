<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  User: arbro
  Date: 25-9-17
  Time: 15:56
  Project: tictactoe
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
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
            <h2 class="col-sm-12" align="center">Login</h2>
            <p class="col-sm-12" align="center">Please enter your credentials</p>

            <div class="col-sm-4">
                <form:form modelAttribute="loginCredentials" >
                    <div class="form-group">
                        <form:input class="form-control" path="username" placeholder="Username"/><br>
                        <form:password class="form-control" path="password" placeholder="Password"/><br>
                        <input class="form-control btn btn-primary" type="submit" value="Login" /><br>
                    </div>
                    <form:errors path="*" cssClass="errorblock" element="div" />
                </form:form>
            </div>

        </div>
    </div>


</body>
</html>
