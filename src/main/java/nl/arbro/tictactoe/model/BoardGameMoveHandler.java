package nl.arbro.tictactoe.model;

/**
 * Created By: arbro
 * Date: 25-8-17 - 10:54
 * Project: tictactoe
 **/

public class BoardGameMoveHandler {

    public void processMove(BoardGameMoveCommand move){
        move.execute();
    }
}
