package nl.arbro.tictactoe.model;

import nl.arbro.tictactoe.controller.TicTacToeWinController;

/**
 * Created By: arbro
 * Date: 27-7-17 - 21:44
 * Project: tictactoe
 **/

public class TicTacToeGame {

    private Board board;
    private PlayerSet players;
    private TicTacToeWinController winCtrl;

    public TicTacToeGame() {
        this.board = new Board();
        this.players = new PlayerSet();
        this.winCtrl = new TicTacToeWinController();
    }

    public Board getBoard() {
        return this.board;
    }

    public PlayerSet getPlayers() {
        return this.players;
    }

    public TicTacToeWinController getWinCtrl() {
        return winCtrl;
    }

    public void resetGame(){
        board.emptyBoard();
        players.chooseFirstPlayer();
        winCtrl.setWinCategory(WinStatus.Playing);

    }
}
