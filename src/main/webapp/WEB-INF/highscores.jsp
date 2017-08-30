<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = " java.util.* " %>

<%--
  User: arbro
  Date: 29-8-17
  Time: 14:06
  Project: tictactoe
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TicTacToe - Highscores</title>
    <link href="css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%@include file="directives/_navbar.html"%>
    <hr/>

    <h3>Highscores</h3>
    <table class="highScoreList">
        <thead class="highScoreList">
            <td class="highScoreListName">PlayerName</td>
            <td class="highScoreListScore">Score</td>
        </thead>
        <c:forEach var="score" items="${highScores}">
            <tr class="highScoreList">
                <td class="highScoreListName">${score.getPlayerName()}</td>
                <td class="highScoreListScore">${score.getScore()}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
