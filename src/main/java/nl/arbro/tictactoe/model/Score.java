package nl.arbro.tictactoe.model;

/**
 * Created by arbro on 28-6-17.
 */
public class Score {

    private long id;
    private String playerName;
    private int score;

    public Score(long id, String playerName, int score) {
        this(playerName, score);
        this.id = id;
    }

    private Score(String name, int score) {
        this.playerName = name;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public String toString(){
        return "[id: " + id + ", playerName: " + playerName + ", score: " + score + "]";
    }

}
