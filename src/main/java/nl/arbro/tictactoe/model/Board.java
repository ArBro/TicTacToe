package nl.arbro.tictactoe.model;

/**
 * Created by ArBro on 24-5-2017.
 */


abstract public class Board {
    private int boardLength;
    private int boardHeight;
    private String[][] board;
    private boolean hasEmptyFields = true;


    //Constructors
    protected Board(int boardLength, int boardHeight){
        this.boardLength = boardLength;
        this.boardHeight = boardHeight;
        this.board = new String[this.boardHeight][this.boardLength];
        this.resetBoard();
    }

    //Getters & Setters
    public String[][] getBoard() {
        return this.board;
    }

    protected int getBoardLength() {
        return boardLength;
    }

//    public int getBoardHeight() {
//        return boardHeight;
//    }

    public boolean hasEmptyFields() {
        return hasEmptyFields;
    }

    protected void setHasEmptyFields(){
        int countEmptyFields = 0;
        for (int row = 0; row < getBoard().length; row++){
            for (int col = 0; col < getBoard()[row].length; col++){
                if (getBoard()[row][col] == null || getBoard()[row][col].isEmpty()){
                    countEmptyFields++;
                }
            }
        }

        this.hasEmptyFields = (countEmptyFields > 0);
    }

    //Methods
    public void resetBoard(){
        for (String[] row : board){
            for (int i = 0; i < row.length; i++) {
                row[i] = "";
            }
        }
    }

    abstract public void fillBoard(int move, Token t);

    abstract public boolean isEmptyField(int fieldId);


}
