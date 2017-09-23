package nl.arbro.tictactoe.model;

import java.util.Comparator;

/**
 * Created by arbro on 28-6-17.
 */
public interface ScoreComparator {

    enum SortMethod {BY_SCORE, BY_NAME};

    Comparator<Score> BY_SCORE = (s1, s2) -> {
        if (s1.getScore() == s2.getScore()) {
            return s1.getPlayerName().compareTo(s2.getPlayerName());
        } else {
            return s2.getScore() - s1.getScore();
        }
    };

    Comparator<Score> BY_NAME = (s1, s2) -> {
        if (s1.getPlayerName().equals(s2.getPlayerName())) {
            return s2.getScore() - s1.getScore();
        } else {
            return s1.getPlayerName().compareTo(s2.getPlayerName());
        }
    };
}
