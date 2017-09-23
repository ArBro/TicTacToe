package nl.arbro.tictactoe.model;

import java.util.EnumSet;

/**
 * Created By: arbro
 * Date: 23-8-17 - 11:19
 * Project: tictactoe
 **/

public abstract class BoardGame {

    private Board board;
    private PlayerSet players;
    private GameStatus gameStatus;
    private Player winner;
    private EnumSet<? extends Token> tokenSet;

    protected BoardGame() {
        this.createGame();
    }

    //Getters & Setters used by the .jsp files mainly

    public Board getBoard() {
        return board;
    }
    public PlayerSet getPlayers() {return players;}
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    public Player getWinner() {
        return winner;
    }
    public EnumSet<? extends Token> getTokenSet() {
        return tokenSet;
    }

    protected void setBoard(Board board) {
        this.board = board;
    }
    protected void setPlayers(PlayerSet playerSet) {
        this.players = playerSet;
    }
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
    public void setWinner(Player winner){
        this.winner = winner;
    }
    public void setTokenSet(EnumSet<? extends Token> tokenSet) {
        this.tokenSet = tokenSet;
    }

    //Methods
    public abstract void createGame();
    public abstract BoardGameMoveCommand createMoveCommand(BoardGameMove move);
    public abstract boolean hasWinner(Board board);
}
