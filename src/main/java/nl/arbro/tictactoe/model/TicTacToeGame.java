package nl.arbro.tictactoe.model;

import java.util.EnumSet;
import java.util.regex.Pattern;

/**
 * Created By: arbro
 * Date: 23-8-17 - 11:27
 * Project: tictactoe
 **/

public class TicTacToeGame extends BoardGame {

    @Override
    public void createGame() {
        setBoard(BoardFactory.getBoard(BoardGameType.TICTACTOE));
        setPlayers(new PlayerSet());
        setGameStatus(GameStatus.NOT_STARTED);

        EnumSet<? extends Token> tokens = EnumSet.allOf(TicTacToeToken.class);
        setTokenSet(tokens);
    }

    @Override
    public BoardGameMoveCommand createMoveCommand(BoardGameMove move) {
        TicTacToeMoveCommand moveCommand = new TicTacToeMoveCommand(move, this.getBoard());
        return moveCommand;
    }

    @Override
    public boolean hasWinner(Board b) {
        String[][] board = b.getBoard();
        final Pattern THREE_IN_A_ROW = Pattern.compile("(\\w+)(?:\\1){2}");

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

        //TODO: Make check Crossrows more dynamic. Its now hardcoded
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

}
