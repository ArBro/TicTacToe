package nl.arbro.tictactoe.model;

/**
 * Created By: arbro
 * Date: 24-8-17 - 13:15
 * Project: tictactoe
 **/

public class TicTacToeBoard extends Board {


    public TicTacToeBoard(){
        super(3,3);
    }

    @Override
    public void fillBoard(int move, Token t) {
        int boardRow = (move - 1) / getBoardLength(); //Calculate row number based on user input
        int boardCol = (move - 1) % getBoardLength(); //Calculate col number based on user input
        getBoard()[boardRow][boardCol] = t.toString();
        this.setHasEmptyFields();
    }

    @Override
    public boolean isEmptyField(int fieldId) {
        int boardRow = (fieldId - 1) / getBoardLength(); //Calculate row number based on user input
        int boardCol = (fieldId - 1) % getBoardLength(); //Calculate col number based on user input
        return (getBoard()[boardRow][boardCol] == null || getBoard()[boardRow][boardCol].isEmpty() );
    }
}
