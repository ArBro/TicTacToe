package nl.arbro.tictactoe.model;

/**
 * Created By: arbro
 * Date: 13-4-18 - 13:41
 * Project: tictactoe
 **/

public class ConnectFourBoard extends Board {

    int boardRow;

    public ConnectFourBoard() {
        super(7, 6);
    }

    @Override
    public void fillBoard(int move, Token t) {
        int boardCol = (move - 1) % getBoardLength(); //Calculate column based on input
        getBoard()[boardRow][boardCol] = t.toString();
        this.setHasEmptyFields();
    }

    @Override
    public boolean isEmptyField(int fieldId) {
        int boardCol = (fieldId - 1) % getBoardLength(); //Calculate col number based on user input
        boardRow = 5;
        //Determine next free cell in column

        while (boardRow >= 0){
            if (getBoard()[boardRow][boardCol] == null || getBoard()[boardRow][boardCol].isEmpty()) {
                return true;
            }
            boardRow--;
        }

        return false;
    }

}
