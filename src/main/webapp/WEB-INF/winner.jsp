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
</head>
<body>
    <c:choose>
        <c:when test="${winCtrl.getWinCategory().equals('Draw')}">
            <h2>${winCtrl.announceDraw()}</h2>
        </c:when>
        <c:otherwise>
            <h2>${winCtrl.announceWinner()}</h2>
        </c:otherwise>
    </c:choose>

    <%@include file="directives/board.jsp"%>

    <p><a href="home">Start a new game</a></p>

</body>
</html>
