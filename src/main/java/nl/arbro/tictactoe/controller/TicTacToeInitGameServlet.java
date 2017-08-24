package nl.arbro.tictactoe.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created By: arbro
 * Date: 26-7-17 - 14:58
 * Project: tictactoe
 **/

@WebServlet(name = "TicTacToeInitGameServlet", urlPatterns = {"/initgame"})
public class TicTacToeInitGameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String playerName1 = request.getParameter("player1");
        String playerName2 = request.getParameter("player2");

        TicTacToeGameController gameCtrl = new TicTacToeGameController();

        try {
            gameCtrl.initGame(playerName1, playerName2);
            session.setAttribute("game", gameCtrl);
            response.sendRedirect("game");
        } catch (Exception e) {
            session.setAttribute("errorMsg", "Please fill in different player names");
            response.sendRedirect("home");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("game") != null){
            TicTacToeGameController gameCtrl = (TicTacToeGameController) session.getAttribute("game");
            gameCtrl.resetGame();
            session.setAttribute("game", gameCtrl);
            response.sendRedirect("game");
        } else {
            response.sendRedirect("tictactoe");
        }

    }
}
