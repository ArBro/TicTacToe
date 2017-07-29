package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.Player;

import java.util.regex.Pattern;

/**
 * Created by ArBro on 18-6-2017.
 */
public class TicTacToeWinController implements WinController {
    String winningToken;
    static final Pattern THREE_IN_A_ROW = Pattern.compile("(\\w+)(?:\\1){2}");

    @Override
    public boolean hasWinner(Object o) {
        String [][] board = (String[][]) o;

        // Check Rows
        for(String[] row : board){

            String r = String.join("", row);
            if(THREE_IN_A_ROW.matcher(r).matches()){
                //winningToken = r.substring(0,1);
                return true;
            }
        }

        //Check Columns
        for(int j = 0; j < board.length; j++){
            StringBuilder c = new StringBuilder();
            for(int i = 0; i < board.length; i++){
                c.append(board[i][j]);
            }
            if(THREE_IN_A_ROW.matcher(c.toString()).matches()) {
                //winningToken = c.substring(0,1);
                return true;
            }
        }

        //TODO: Check crossrows nog dynamisch maken. Nu hardcoded.
        //Check CrossRows
        StringBuilder cr = new StringBuilder();
        cr.append(board[0][0]);
        cr.append(board[1][1]);
        cr.append(board[2][2]);
        if(THREE_IN_A_ROW.matcher(cr.toString()).matches()) {
            //winningToken = cr.toString().substring(0,1);
            return true;
        }

        cr = new StringBuilder();
        cr.append(board[0][2]);
        cr.append(board[1][1]);
        cr.append(board[2][0]);
        if(THREE_IN_A_ROW.matcher(cr.toString()).matches()) {
            //winningToken = cr.toString().substring(0,1);
            return true;
        }

        return false;

    }

    @Override
    public void announceWinner(Object o) {
        Player winner = (Player) o;
        System.out.println(winner.getPlayerName() + " has won. Congratulations!");
    }

    @Override
    public void announceDraw() {
        System.out.println("I can't decide who has won. It is a draw.");
    }

}
