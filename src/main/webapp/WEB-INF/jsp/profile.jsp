<%--
  User: arbro
  Date: 26-9-17
  Time: 15:46
  Project: tictactoe
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile Page</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap.css" rel="stylesheet" type = "text/css">
    <script src="lib/js/jquery-3.2.1.min.js"></script>
    <script src="lib/js/popper.js"></script>
    <script src="lib/js/bootstrap.min.js"></script>
</head>

<body>

    <%@include file="directives/_navbar.html"%>
    <div class="container">
       <div class="row">
           <div class="col-sm-12">Welcome ${user.getUsername()}!</div>
       </div>
    </div>



</body>
</html>
