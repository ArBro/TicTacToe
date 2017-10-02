<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: arbro
  Date: 31-7-17
  Time: 20:35
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" type = "text/css">
    <script src="<c:url value="/lib/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/lib/js/popper.js"/>"></script>
    <script src="<c:url value="/lib/js/bootstrap.min.js"/>"></script>

</head>
<body>
    <%@include file="directives/_navbar.html"%>
    <div class="container">
        <h2>${hello}</h2>
    </div>



</body>
</html>
