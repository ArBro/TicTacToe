package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.InvalidInputException;
import nl.arbro.tictactoe.model.*;

import java.util.EnumSet;
import java.util.Iterator;

/**
 * Created By: arbro
 * Date: 7-8-17 - 19:00
 * Project: TicTacToe
 **/

public class TicTacToeGameController {

    private BoardGame game = BoardGameFactory.getBoardGame(BoardGameType.TICTACTOE);

    //Getters & Setters (Getters mainly used by .jsp files
    public BoardGame getGame(){return this.game;}

    //TicTacToeGameController Methods
    public void initGame(String playerName1, String playerName2) throws Exception {
        EnumSet<TicTacToeToken> tokenSet = EnumSet.allOf(TicTacToeToken.class);
        Iterator<TicTacToeToken> it = tokenSet.iterator();

        game.getPlayers().addPlayer(playerName1, it.next());
        game.getPlayers().addPlayer(playerName2, it.next());
        game.getPlayers().chooseFirstPlayer();
        game.getBoard().clearBoard();

    }

    public void processMove(String moveInput) throws IllegalArgumentException {
        Player curPlayer = game.getPlayers().getCurrentPlayer();
        int move = Integer.parseInt(moveInput); //Throws IllegalArgumentException

        if (move <= 0 || move > 9) {
            throw new InvalidInputException("Your input is not in the range 1-9");
        }

        if (!game.getBoard().isEmptyField(move)){
            throw new InvalidInputException("Please fill in a non-empty field");
        }

        game.getBoard().fillBoard(move, curPlayer.getPlayToken());
        updateGameStatus();
        game.getPlayers().switchCurPlayer();

    }

    public void updateGameStatus(){
        Player curPlayer = game.getPlayers().getCurrentPlayer();
        if (game.hasWinner()) {
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
        game.getBoard().clearBoard();
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
