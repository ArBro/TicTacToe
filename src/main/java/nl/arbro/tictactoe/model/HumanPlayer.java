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
    @Override
    public int playMove(){
        Scanner moveSc = new Scanner(System.in);
        int nextMove;

        try {
            String nextMoveInput = moveSc.next();
            nextMove = Integer.parseInt(nextMoveInput);
        } catch (NumberFormatException e) {
            System.out.print("Your input is not valid. ");
            return playMove();
        }

        if (nextMove <= 0 || nextMove > 9) {
            System.out.print("Your input is not valid. ");
            return playMove();
        }

        return nextMove;
    }

}
