package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.exceptions.InvalidInputException;
import nl.arbro.tictactoe.model.*;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created By: arbro
 * Date: 7-8-17 - 19:00
 * Project: TicTacToe
 **/

public class GameController {

    private Board board;
    private PlayerSet players;
    private WinController winCtrl;
    private GameStatus gameStatus;

    //Constructor
    public GameController() {
        this.board = new Board();
        this.players = new PlayerSet();
        this.winCtrl = new WinController();
        this.gameStatus = GameStatus.Playing;
    }

    //Getters & Setters
    public WinController getWinCtrl() {
        return winCtrl;
    }

    public Board getBoard() {
        return this.board;
    }

    public PlayerSet getPlayers() {
        return this.players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    //Game Methods
    public void initGame(String playerName1, String playerName2) throws Exception {
        Set<Token> tokenSet = EnumSet.allOf(Token.class);
        Iterator<Token> it = tokenSet.iterator();

        this.getPlayers().addPlayer(0, playerName1, it.next());
        this.getPlayers().addPlayer(1, playerName2, it.next());
        this.getBoard().emptyBoard();
        this.getPlayers().chooseFirstPlayer();
    }

    public void progressMove(String moveInput) throws IllegalArgumentException {
        Player curPlayer = this.getPlayers().getCurrentPlayer();
        int move = Integer.parseInt(moveInput); //Throws IllegalArgumentException

        if (move <= 0 || move > 9) {
            throw new InvalidInputException("Your input is not in the range 1-9");
        }

        if (board.getIsFilledField(move)){
            throw new InvalidInputException("Please fill in a non-empty field");
        }

        this.board.fillBoard(move, curPlayer.getPlayToken());
        this.updateGameStatus();
        this.getPlayers().switchCurPlayer();

    }

    public void updateGameStatus(){
        Player curPlayer = this.getPlayers().getCurrentPlayer();
        if (this.winCtrl.hasWinner(board.getBoard())) {
            this.winCtrl.setWinner(curPlayer);
            this.setGameStatus(GameStatus.Winner);
        } else if (!board.getEmptyFieldsLeft()) {
            this.setGameStatus(GameStatus.Draw);
        } else {
            //do Nothing
        }

    }

    public boolean nextMoveAllowed() {
        if (this.getGameStatus() != GameStatus.Playing){
            return false;
        } else {
            return true;
        }
    }

    public void resetGame(){
        this.getBoard().emptyBoard();
        this.getPlayers().chooseFirstPlayer();
        this.setGameStatus(GameStatus.Playing);
    }



}
