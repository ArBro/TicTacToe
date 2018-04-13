package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.Score;
import nl.arbro.tictactoe.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static nl.arbro.tictactoe.model.ScoreComparator.BY_SCORE;

/**
 * Created By: arbro
 * Date: 29-8-17 - 14:09
 * Project: tictactoe
 **/

@Controller
public class HighScoreController {

    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = {"/highscores"})
    public String showScores(Model model) {

        final List<Score> scores = scoreService.getScores(BY_SCORE);
        model.addAttribute("highScores", scores);
        return "highscores";

    }
}
