<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link href="css/main.css" rel="stylesheet" type="text/css">
</head>

<body>

    <p><h3>${game.getPlayers().getPlayerById(0).getPlayerName()} (${game.getPlayers().getPlayerById(0).getPlayToken()}) vs. ${game.getPlayers().getPlayerById(1).getPlayerName()} (${game.getPlayers().getPlayerById(1).getPlayToken()})</h3></p>
    <%@include file="directives/board.jsp"%>

    <p></p>
    <p>${game.getPlayers().getCurrentPlayer().getPlayerName()} it is your turn!</p>
    <form method="post">
        Input: <input type="text" name="input" /> <input type="submit" name="action" value="Play move"/>
    </form>
    <p class="error">${errorMsg}</p>

</body>


</html>

