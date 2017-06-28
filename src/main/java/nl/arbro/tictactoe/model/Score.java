package nl.arbro.tictactoe.model;

/**
 * Created by arbro on 28-6-17.
 */
public class Score {

    private String playerName;
    private int score;

    public Score(String name, int score) {
        this.playerName = name;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
