package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.Board;
import nl.arbro.tictactoe.model.Player;
import nl.arbro.tictactoe.model.WinStatus;

import java.util.regex.Pattern;

/**
 * Created by ArBro on 18-6-2017.
 */
public class TicTacToeWinController implements WinController {
    static final Pattern THREE_IN_A_ROW = Pattern.compile("(\\w+)(?:\\1){2}");
    private Board board;
    private Player winner;
    private WinStatus winCategory = WinStatus.Playing;

    @Override
    public boolean hasWinner(Object b) {
        String [][] board = (String[][]) b;

        // Check Rows
        for(String[] row : board){

            String r = String.join("", row);
            if(THREE_IN_A_ROW.matcher(r).matches()){
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
            return true;
        }

        cr = new StringBuilder();
        cr.append(board[0][2]);
        cr.append(board[1][1]);
        cr.append(board[2][0]);
        if(THREE_IN_A_ROW.matcher(cr.toString()).matches()) {
            return true;
        }

        return false;

    }

    public void checkWinner(Object b, Object p){
        board = (Board) b;
        winner = (Player) p;
        if (this.hasWinner(board.getBoard())) {
            this.setWinCategory(WinStatus.Winner);
        } else if (!board.getEmptyFieldsLeft()) {
            this.setWinCategory(WinStatus.Draw);
        }
    }

    @Override
    public String announceWinner() {
        String message = winner.getPlayerName() + " has won. Congratulations!";
        return message;
    }

    @Override
    public String announceDraw() {
        String message = "I can't decide who has won. It is a draw.";
        return message;
    }

    public void setWinCategory(WinStatus w) {
        this.winCategory = w;
    }

    public WinStatus getWinCategory() {
        return this.winCategory;
    }
}
