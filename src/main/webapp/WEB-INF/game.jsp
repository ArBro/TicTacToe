<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link href="css/main.css" rel="stylesheet" type="text/css">
</head>

<body>
    <%@include file="directives/_navbar.html"%>
    <hr/>

    <p><h3>${game.getGame().getPlayers().getPlayerById(1).getPlayerName()} (${game.getGame().getPlayers().getPlayerById(1).getPlayToken()}) vs. ${game.getGame().getPlayers().getPlayerById(2).getPlayerName()} (${game.getGame().getPlayers().getPlayerById(2).getPlayToken()})</h3></p>
    <%@include file="directives/board.jsp"%>

    <p></p>
    <p>${game.getGame().getPlayers().getCurrentPlayer().getPlayerName()} it is your turn!</p>
    <form method="post">
        Input: <input type="text" name="input" /> <input type="submit" value="Play move"/>
    </form>
    <p class="error">${errorMsg}</p>

</body>


</html>

