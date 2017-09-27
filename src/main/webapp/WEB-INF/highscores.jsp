<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link href="css/bootstrap.css" rel="stylesheet" type = "text/css">
    <script src="lib/js/jquery-3.2.1.min.js"></script>
    <script src="lib/js/popper.js"></script>
    <script src="lib/js/bootstrap.min.js"></script>
</head>
<body>
    <%@include file="directives/_navbar.html"%>

    <div class="container">
        <h3>Highscores</h3>
        <table class="table highScoreList">
            <thead class="highScoreList">
                <td class="highScoreListName">PlayerName</td>
                <td class="highScoreListScore">Score</td>
                <td class="highScoreListAchievedDate">AchievedDate</td>
            </thead>
            <tbody>
            <c:forEach var="score" items="${highScores}">
                <tr class="highScoreList">
                    <td class="highScoreListName">${score.getPlayerName()}</td>
                    <td class="highScoreListScore">${score.getScore()}</td>
                    <td class="highScoreListAchievedDate">${score.getAchievedDate()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>



</body>
</html>
