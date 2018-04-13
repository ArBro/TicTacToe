package nl.arbro.tictactoe.service;

import nl.arbro.tictactoe.model.Score;
import nl.arbro.tictactoe.repository.ScoreRepository;

import java.util.Comparator;
import java.util.List;

/**
 * Created By: arbro
 * Date: 5-10-17 - 10:49
 * Project: TicTacToe
 **/

public interface ScoreService {

    void addScore(Score score);
    List<Score> getScores(Comparator<Score> scoreOrder);
    List<Score> getScores();
}
