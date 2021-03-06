<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arbro
  Date: 14-7-17
  Time: 20:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Play TicTacToe or CheckFour</title>
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
            <h2 class="col-sm-12" align="center">Welcome to TicTacToe</h2>
            <p class="col-sm-12" align="center">Please enter your names</p>

            <div class="col-sm-4">
                <form:form modelAttribute="initGameForm">
                    <div class="form-group" id="playernames">
                        <form:input class="form-control" path="playername1" placeholder="Name Player 1" /><br>
                        <form:input class="form-control" path="playername2" placeholder="Name Player 2" />
                    </div>
                    <div class="form-group row" id="gametype">
                        <div class="col-sm-12"><b>Select game type:</b></div>
                        <div class="col-sm-1 form-inline"><form:radiobutton path="gameType" value="TICTACTOE"/></div>
                        <div class="col-sm-11">TicTacToe</div>
                        <div class="col-sm-1 form-inline"><form:radiobutton class="disabled" path="gameType" value="CONNECT_FOUR"/></div>
                        <div class="col-sm-11">Connect Four</div>
                    </div>
                    <div class="form-group" id="buttons">
                        <input class="form-control btn btn-primary" type="submit" value="Start Game" /><br>
                    </div>
                    <form:errors path="*" cssClass="errorblock" element="div" />
                </form:form>
            </div>
        </div>
    </div>



</body>
</html>
