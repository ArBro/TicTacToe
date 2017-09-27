package nl.arbro.tictactoe.model;

import java.time.LocalDate;

/**
 * Created by arbro on 28-6-17.
 */
public class Score {

    private String playerName;
    private int score;
    private LocalDate achievedDate;

    public Score(String name, int score, LocalDate achievedDate) {
        this.playerName = name;
        this.score = score;
        this.achievedDate = achievedDate;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public LocalDate getAchievedDate() {
        return achievedDate;
    }

    public String toString(){
        return "[playerName: " + playerName + ", score: " + score + "achievedDate: " + achievedDate.toString() + "]";
    }

}
