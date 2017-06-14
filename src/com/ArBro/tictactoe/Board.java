package com.ArBro.tictactoe;

/**
 * Created by ABrouwer on 24-5-2017.
 */


public class Board {
    private int boardSize = 3;
    String board[][] = new String[boardSize][boardSize];
    private boolean[] isFilledField = new boolean[9];
    private boolean emptyFieldsLeft = true;
    String winningToken;

    //Constructors
    Board(){
        for (String[] row : this.board){
            for (int i = 0; i < row.length; i++) {
                row[i] = "[ ]";
            }
        }
    }

    //Getters & Setters
    boolean getIsFilledField(int fieldId){
        return this.isFilledField[fieldId - 1];
    }

    boolean getEmptyFieldsLeft() {
        return emptyFieldsLeft;
    }

    void setIsFilledField(int fieldId){
        this.isFilledField[fieldId - 1] = true;
    }

    void setEmptyFieldsLeft(){
        int countEmptyFields = 0;
        for (boolean anIsFilledField : isFilledField) {
            if (!anIsFilledField) {
                countEmptyFields++;
            }
        }
        this.emptyFieldsLeft = (countEmptyFields > 0);
    }

    //Methods
    public void emptyBoard(){
        for (String[] row : board){
            for (int i = 0; i < row.length; i++) {
                row[i] = "[ ]";
            }
        }
    }

    void displayBoard(){
        for (String[] row : board){
            for (String col : row ){
                System.out.print(col);
            }
            System.out.println();
        }
    }

    boolean hasWinner() {
        //Possible wins
        // (0,0),(0,1),(0,2)
        // (1,0),(1,1),(1,2)
        // (2,0),(2,1),(2,2)
        // (0,0),(1,0),(2,0)
        // (0,1),(1,1),(2,1)
        // (0,2),(1,2),(2,2)
        // (0,0),(1,1),(2,2)
        // (0,2),(1,1),(2,0)

        if (this.board[0][0].equals(this.board[0][1]) && this.board[0][1].equals(this.board[0][2]) &&
                !this.board[0][0].equals("[ ]")) {
            this.winningToken = this.board[0][0].substring(1, 2);
            return true;
        } else if (this.board[1][0].equals(this.board[1][1]) && this.board[1][1].equals(this.board[1][2]) &&
                !this.board[1][0].equals("[ ]")) {
            this.winningToken = this.board[1][0].substring(1, 2);
            return true;
        } else if (this.board[2][0].equals(this.board[2][1]) && this.board[2][1].equals(this.board[2][2]) &&
                !this.board[2][0].equals("[ ]")) {
            this.winningToken = this.board[2][0].substring(1, 2);
            return true;
        } else if (this.board[0][0].equals(this.board[1][0]) && this.board[1][0].equals(this.board[2][0]) &&
                !this.board[0][0].equals("[ ]")) {
            this.winningToken = this.board[0][0].substring(1, 2);
            return true;
        } else if (this.board[0][1].equals(this.board[1][1]) && this.board[1][1].equals(this.board[2][1]) &&
                !this.board[0][1].equals("[ ]")) {
            this.winningToken = this.board[0][1].substring(1, 2);
            return true;
        } else if (this.board[0][2].equals(this.board[1][2]) && this.board[1][2].equals(this.board[2][2]) &&
                !this.board[0][2].equals("[ ]")) {
            this.winningToken = this.board[0][2].substring(1, 2);
            return true;
        } else if (this.board[0][0].equals(this.board[1][1]) && this.board[1][1].equals(this.board[2][2]) &&
                !this.board[0][0].equals("[ ]")) {
            this.winningToken = this.board[0][0].substring(1, 2);
            return true;
        } else if (this.board[0][2].equals(this.board[1][1]) && this.board[1][1].equals(this.board[2][0]) &&
                !this.board[0][2].equals("[ ]")) {
            this.winningToken = this.board[0][2].substring(1, 2);
            return true;
        } else {
            return false;
        }
    }


}
