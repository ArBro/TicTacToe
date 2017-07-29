package nl.arbro.tictactoe.model;

/**
 * Created By: arbro
 * Date: 27-7-17 - 21:44
 * Project: tictactoe
 **/

public class TicTacToeGame {

    private Board board;
    private PlayerSet players;

    public TicTacToeGame() {
        this.board = new Board();
        this.players = new PlayerSet();
    }

    public Board getBoard() {
        return this.board;
    }

    public PlayerSet getPlayers() {
        return this.players;
    }
}
