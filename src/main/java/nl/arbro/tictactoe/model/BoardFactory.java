package nl.arbro.tictactoe.model;

/**
 * Created By: arbro
 * Date: 24-8-17 - 10:12
 * Project: tictactoe
 **/

public class BoardFactory {
    public static Board getBoard(BoardGameType boardGameType){
        switch (boardGameType){
            case TICTACTOE: {
                return new TicTacToeBoard();
            }
            case CONNECT_FOUR: {
                return new ConnectFourBoard();
            }
            default: return null;
        }
    }
}
