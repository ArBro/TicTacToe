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
        <c:when test="${game.getGameStatus().equals('Draw')}">
            <h2>${game.getWinCtrl().announceDraw()}</h2>
        </c:when>
        <c:otherwise>
            <h2>${game.getWinCtrl().announceWinner()}</h2>
        </c:otherwise>
    </c:choose>

    <%@include file="directives/board.jsp"%>

    <p></p>
    <p><a href="initgame"><input type="button" value="Start a new Game"></a> <a href="home"><input type="button" value="Reset Game"></a></p>

</body>
</html>
