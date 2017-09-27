<div class="row justify-content-center">
    <h2 class="col-sm-12" align="center">Welcome to TicTacToe</h2>
    <p class="col-sm-12" align="center">Please enter your names</p>

    <div class="col-sm-4">
        <form method="post" action="initgame">
            <div class="form-group">
                <input class="form-control" type="text" name="player1" placeholder="Name Player 1" /><br>
                <input class="form-control" type="text" name="player2" placeholder="Name Player 2" /><br>
                <input class="form-control btn btn-primary" type="submit" value="Start Game" name="startBtn" /><br>
            </div>

            <c:forEach var="message" items="${messages}">
                <span class="error">${message.value}</span><br/>
            </c:forEach>
        </form>
    </div>
</div>



