package nl.arbro.tictactoe.model;

import java.util.Iterator;

/**
 * Created By: arbro
 * Date: 7-8-17 - 19:00
 * Project: TicTacToe
 **/


public class BoardGameHandler {

    private final BoardGame game;

    public BoardGameHandler(BoardGame game) {
        this.game = game;
    }

    public BoardGame getGame(){return this.game;}

    //BoardGameHandler Methods
    public void initGame(String ... players) throws IllegalArgumentException {
        Iterator<? extends Token> it = game.getTokenSet().iterator();

        for (String player : players) {
            game.getPlayers().addPlayer(player, it.next());
        }

        resetGame();
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
