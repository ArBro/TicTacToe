package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.ScoreComparator;
import nl.arbro.tictactoe.model.ScoreList;
import nl.arbro.tictactoe.model.Score;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by arbro on 28-6-17.
 */
public class ScoreController {

    public static ScoreList highScores = new ScoreList();

    private static final void GET_HIGHSCORES() {
        File scoreFile = new File("src/resources/scores.txt");
        try (Scanner sc = new Scanner(scoreFile)){
            while (sc.hasNextLine()){
                String name = sc.next();
                int score = sc.nextInt();
                Score curScore = new Score(name, score);
                highScores.add(curScore);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public final ScoreList getScoresTopX(int x){
        GET_HIGHSCORES();
        Collections.sort(highScores, ScoreComparator.BY_SCORE);
        if (highScores.size() < x){
            return highScores;
        } else {
            //TODO: Can this be made more efficient? Without adding all to a new list?
            ScoreList outputList = new ScoreList();
            outputList.addAll(highScores.subList(0, x));
            return outputList;
        }
    }
}
