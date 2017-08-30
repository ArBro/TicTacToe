package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.Score;
import nl.arbro.tictactoe.model.ScoreList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created By: arbro
 * Date: 29-8-17 - 14:09
 * Project: tictactoe
 **/

@WebServlet(name = "TicTacToeHighScoreServlet", urlPatterns = {"/highscores"})
public class TicTacToeHighScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Score> scores = ScoreList.getInstance().getScores();
        request.setAttribute("highScores", scores);
        request.getServletContext().getRequestDispatcher("/WEB-INF/highscores.jsp").forward(request, response);
    }
}
