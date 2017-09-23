package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.*;

import java.util.Iterator;

/**
 * Created By: arbro
 * Date: 7-8-17 - 19:00
 * Project: TicTacToe
 **/

public class BoardGameController {

    private final BoardGame game;

    public BoardGameController(BoardGame game) {
        this.game = game;
    }

    //Getters & Setters (Getters mainly used by .jsp files
    public BoardGame getGame(){return this.game;}

    //BoardGameController Methods
    public void initGame(String ... players) throws Exception {
        Iterator<? extends Token> it = game.getTokenSet().iterator();

        for (String player : players) {
            game.getPlayers().addPlayer(player, it.next());
        }

        this.resetGame();
    }

    public void processMove(String moveInput) throws IllegalArgumentException {
        Player curPlayer = game.getPlayers().getCurrentPlayer();
        BoardGameMoveHandler moveHandler = new BoardGameMoveHandler();

        BoardGameMove move = new BoardGameMove(moveInput, curPlayer.getPlayToken());
        BoardGameMoveCommand moveCommand = game.createMoveCommand(move);

        moveHandler.processMove(moveCommand);

        updateGameStatus();
        game.getPlayers().setNextPlayer();

    }

    public void updateGameStatus(){
        Player curPlayer = game.getPlayers().getCurrentPlayer();
        if (game.hasWinner(game.getBoard())) {
            game.setWinner(curPlayer);
            game.setGameStatus(GameStatus.WINNER);
        } else if (!game.getBoard().hasEmptyFields()) {
            game.setGameStatus(GameStatus.DRAW);
        } else {
            //do Nothing
        }

    }

    public boolean nextMoveAllowed() {
        if (game.getGameStatus() != GameStatus.PLAYING){
            return false;
        } else {
            return true;
        }
    }

    public void resetGame(){
        game.getBoard().resetBoard();
        game.getPlayers().chooseFirstPlayer();
        game.setGameStatus(GameStatus.PLAYING);
    }

    //announceWinner() used by winner.jsp
    public String announceWinner() {
        if (game.getGameStatus() == GameStatus.WINNER) {
            return game.getWinner().getPlayerName() + " has won. Congratulations!";
        } else if (game.getGameStatus() == GameStatus.DRAW) {
            return "I can't decide who has won. It is a draw.";
        } else {
            return "There is no winner";
        }
    }

}