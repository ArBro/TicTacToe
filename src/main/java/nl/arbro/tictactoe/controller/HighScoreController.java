package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.ScoreRepository;
import nl.arbro.tictactoe.model.Score;
import nl.arbro.tictactoe.model.ScoreList;
import nl.arbro.tictactoe.model.ScoreRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static nl.arbro.tictactoe.model.ScoreComparator.BY_SCORE;

/**
 * Created By: arbro
 * Date: 29-8-17 - 14:09
 * Project: tictactoe
 **/

@Controller
public class HighScoreController {

    @RequestMapping(value = {"/highscores"})
    public String showScores(Model model) {

        final List<Score> scores = ScoreList.getInstance().getScores(new ScoreRepositoryImpl(), BY_SCORE);
        model.addAttribute("highScores", scores);
        return "highscores";

    }
}
