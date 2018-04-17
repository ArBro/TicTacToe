package nl.arbro.tictactoe.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created By: arbro
 * Date: 13-4-18 - 15:26
 * Project: tictactoe
 **/

public class BoardGameWinCalculator implements WinCalculator {

    private Pattern winPattern;

    @Override
    public boolean hasWinner(Board b, Pattern winPat) {
        String[][] board = b.getBoard();
        winPattern = winPat;

        // Check Rows
        for (int i=0; i<board.length; i++) {
            StringBuilder c = new StringBuilder();
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j].isEmpty()){
                    c.append("-");
                } else {
                    c.append(board[i][j]);
                }
            }
            //System.out.println(c.toString() + " " + winPattern.matcher(c.toString()).matches());
            if(winPattern.matcher(c.toString()).matches()){
                return true;
            }
        }

        //Check Columns
        for(int j = 0; j < board.length; j++){
            StringBuilder c = new StringBuilder();
            for(int i = 0; i < board.length; i++){
                if(board[i][j].isEmpty()){
                    c.append("-");
                } else {
                    c.append(board[i][j]);
                }
            }
            //System.out.println(c.toString() + " " + winPattern.matcher(c.toString()).matches());
            if(winPattern.matcher(c.toString()).matches()) {
                return true;
            }
        }

        //Check top half of the square
        for (int i=0; i < board[0].length; i++) {
            if (checkDiagonalDown(board, i, 0)) {
                return true;
            }
        }

        // Check bottom half
        for (int i = 1; i < board.length; i++) {
            if (checkDiagonalDown(board, 0, i)) {
                return true;
            }
        }

        //Check top half of the square
        for (int i=board.length - 1; i>= 0; i--) {
            if (checkDiagonalUp(board, 0, i)) {
                return true;
            }
        }

        // Check bottom half
        for (int i = 1; i < board[0].length; i++) {
            if (checkDiagonalUp(board, i, board.length - 1)) {
                return true;
            }
        }

        return false;
    }

    //Helper Functions
    private boolean checkDiagonalDown(String[][] board, int startX, int startY) {
        StringBuilder  c = new StringBuilder();
        while (startX < board[0].length && startY < board.length) {
            String curFieldValue = board[startY++][startX++];
            if (curFieldValue == null || curFieldValue.isEmpty()){
                c.append("-");
            } else {
                c.append(curFieldValue);
            }
        }
        System.out.println(c.toString() + " " + winPattern.matcher(c.toString()).matches());
        return winPattern.matcher(c.toString()).matches();
    }

    private boolean checkDiagonalUp(String[][] board, int startX, int startY) {
        StringBuilder  c = new StringBuilder();
        while (startX < board[0].length && startY >= 0) {
            String curFieldValue = board[startY--][startX++];
            if (curFieldValue == null || curFieldValue.isEmpty()){
                c.append("-");
            } else {
                c.append(curFieldValue);
            }
        }
        System.out.println(c.toString() + " " + winPattern.matcher(c.toString()).matches());
        return winPattern.matcher(c.toString()).matches();
    }

}
