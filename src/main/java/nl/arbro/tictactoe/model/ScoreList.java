package nl.arbro.tictactoe.model;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by arbro on 28-6-17.
 */

public class ScoreList {

    private static ScoreList instance = null;
    private static List<Score> scores = new ArrayList<>();

    private ScoreList(){
    }

    private void addScore(Score score){
        scores.add(score);
    }

    public static ScoreList getInstance(){
        if (instance == null) {
            synchronized (ScoreList.class) {
                if (instance == null) {
                    instance = new ScoreList();
                }
            }
        }
        return instance;
    }

    public List<Score> getScores(ScoreRepository fetcher, Comparator<Score> order) {
        getScores(fetcher);
        scores.sort(order);
        return scores;
    }

    public List<Score> getScores(ScoreRepository fetcher) {
        scores.clear();

        for (Score score : fetcher.getAllScores() ) {
            addScore(score);
        }

        return scores;
    }
}
