package nl.arbro.tictactoe;

import nl.arbro.tictactoe.controller.GameController;

public class TicTacToeApplication {

    public static void main(String[] args) {

        GameController myGame = new GameController();
        myGame.initGame();

    }
}
