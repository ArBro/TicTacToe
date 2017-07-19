package nl.arbro.tictactoe.model;

import java.util.Scanner;

/**
 * Created by ArBro on 14-6-2017.
 */

public class HumanPlayer extends Player {

    public HumanPlayer(int id, String name, Token t) {
        super(id, name);
        this.setPlayToken(t);
    }

    //Methods
    //TODO: Method will not work with gameController
    //TODO: Update game controller to work with TicTacToeContoller

    @Override
    public int playMove(){
        Scanner nextMvScan = new Scanner(System.in);
        int move;

        try {
            String nextMoveInput = nextMvScan.next();
            move = Integer.parseInt(nextMoveInput);
        } catch (NumberFormatException e) {
            System.out.print("Your input is not valid. ");
            return playMove();
        }

        if (move <= 0 || move > 9) {
            System.out.print("Your input is not valid. ");
            return playMove();
        }

        return move;
    }

}
