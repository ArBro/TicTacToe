<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
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
                <h4>${game.getGame().getPlayers().getCurrentPlayer().getPlayerName()} it is your turn!</h4>
            </div>
            <div class="col-sm-12" align="center">
                <%@include file="directives/interactiveboard.jsp"%>
            </div>
            <c:forEach var="message" items="${messages}">
                <span class="error">${message.value}</span><br/>
            </c:forEach>
        </div>
    </div>

</body>


</html>

