package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.Player;

/**
 * Created by ArBro on 18-6-2017.
 */
public class TicTacToeWinController implements WinController {
    String winningToken;

    @Override
    public boolean hasWinner(Object o) {
        //Possible wins
        // (0,0),(0,1),(0,2)
        // (1,0),(1,1),(1,2)
        // (2,0),(2,1),(2,2)
        // (0,0),(1,0),(2,0)
        // (0,1),(1,1),(2,1)
        // (0,2),(1,2),(2,2)
        // (0,0),(1,1),(2,2)
        // (0,2),(1,1),(2,0)
        String [][] board = (String[][]) o;

        //TODO: Opschonen code Ook bruikbaar maken voor meer op een rij?
        if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]) &&
                !board[0][0].equals("[ ]")) {
            winningToken = board[0][0].substring(1, 2);
            return true;
        } else if (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]) &&
                !board[1][0].equals("[ ]")) {
            winningToken = board[1][0].substring(1, 2);
            return true;
        } else if (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]) &&
                !board[2][0].equals("[ ]")) {
            winningToken = board[2][0].substring(1, 2);
            return true;
        } else if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) &&
                !board[0][0].equals("[ ]")) {
            winningToken = board[0][0].substring(1, 2);
            return true;
        } else if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]) &&
                !board[0][1].equals("[ ]")) {
            winningToken = board[0][1].substring(1, 2);
            return true;
        } else if (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]) &&
                !board[0][2].equals("[ ]")) {
            winningToken = board[0][2].substring(1, 2);
            return true;
        } else if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) &&
                !board[0][0].equals("[ ]")) {
            winningToken = board[0][0].substring(1, 2);
            return true;
        } else if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) &&
                !board[0][2].equals("[ ]")) {
            winningToken = board[0][2].substring(1, 2);
            return true;
        } else {
            return false;
        }
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
