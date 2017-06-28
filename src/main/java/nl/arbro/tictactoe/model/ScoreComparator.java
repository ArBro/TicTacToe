package nl.arbro.tictactoe.model;

import java.util.Comparator;

/**
 * Created by arbro on 28-6-17.
 */
public class ScoreComparator {

    public static final Comparator<Score> BY_SCORE = new Comparator<Score>() {
        @Override
        public int compare(final Score s1, final Score s2) {
            if (s1.getScore() == s2.getScore()) {
                return s1.getPlayerName().compareTo(s2.getPlayerName());
            } else {
                return s2.getScore() - s1.getScore();
            }
        }
    };
    public static final Comparator<Score> BY_NAME = new Comparator<Score>() {
        @Override
        public int compare(final Score s1, final Score s2) {
            if (s1.getPlayerName().equals(s2.getPlayerName())) {
                return s2.getScore() - s1.getScore();
            } else {
                return s1.getPlayerName().compareTo(s2.getPlayerName());
            }
        }
    };
}
