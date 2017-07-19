package nl.arbro.tictactoe;

import nl.arbro.tictactoe.controller.GameController;
import nl.arbro.tictactoe.model.HighScoreListGenerator;
import nl.arbro.tictactoe.model.Score;
import nl.arbro.tictactoe.model.ScoreList;

public class TicTacToeApplication {

    public static void main(String[] args) {

        GameController myGame = new GameController();
        myGame.initGame();

//        HighScoreListGenerator scoreCtrl = new HighScoreListGenerator();
//        ScoreList scores = scoreCtrl.getScoresTopX(10);
//        for (Score score : scores){
//            System.out.println(score.getPlayerName() + " " + score.getScore());
//        }

    }


}
