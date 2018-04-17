package nl.arbro.tictactoe.model;

/**
 * Created By: arbro
 * Date: 23-8-17 - 12:11
 * Project: tictactoe
 **/

public class BoardGameFactory {

    public static BoardGame getBoardGame(BoardGameType boardGameType){
        switch (boardGameType){
            case TICTACTOE: {return new TicTacToeGame();}
            case CONNECT_FOUR: {return new ConnectFourGame();}
            default: return null;
        }
    }
}
