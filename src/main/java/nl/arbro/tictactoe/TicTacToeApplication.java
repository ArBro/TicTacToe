package nl.arbro.tictactoe;

import nl.arbro.tictactoe.controller.GameController;
import nl.arbro.tictactoe.controller.ScoreController;
import nl.arbro.tictactoe.model.ScoreList;
import nl.arbro.tictactoe.model.Score;

public class TicTacToeApplication {

    public static void main(String[] args) {

        GameController myGame = new GameController();
        myGame.initGame();

        //ScoreController scoreCtrl = new ScoreController();
        //ScoreList scores = scoreCtrl.getScoresTopX(10);
        //for (Score score : scores){
        //    System.out.println(score.getPlayerName() + " " + score.getScore());
        //}

    }


}
