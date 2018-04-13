package nl.arbro.tictactoe.service;


import nl.arbro.tictactoe.model.Score;
import nl.arbro.tictactoe.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by arbro on 28-6-17.
 */

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

    private static List<Score> scores = new ArrayList<>();
    private ScoreRepository scoreRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository){
        this.scoreRepository = scoreRepository;
    }

    @Override
    public void addScore(Score score){
        scores.add(score);
    }

    @Override
    public List<Score> getScores(Comparator<Score> scoreOrder) {
        getScores();
        scores.sort(scoreOrder);
        return scores;
    }

    @Override
    public List<Score> getScores() {
        scores.clear();

        for (Score score : scoreRepository.findAll() ) {
            addScore(score);
        }

        return scores;
    }
}
