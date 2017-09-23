package nl.arbro.tictactoe.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by arbro on 28-6-17.
 */
public class ScoreList implements ScoreComparator {

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

    public List<Score> getScores(ScoresFetcher fetcher) {
        scores.clear();

        for (Score score : fetcher.fetchScores() ) {
            addScore(score);
        }

        return scores;
    }

}
