<h2>Welcome to TicTacToe</h2>
<p>Please enter your names</p>
<form method="post" action="initgame">
    <p>Player1 <input type="text" name="player1" placeholder="Name" /></p>
    <p>Player2 <input type="text" name="player2" placeholder="Name"/></p>
    <p><input type="submit" value="Start Game" name="startBtn" /></p>
</form>
<p class="error">${errorMsg}</p>
