package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.Token;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created By: arbro
 * Date: 26-7-17 - 14:58
 * Project: tictactoe
 **/

@WebServlet(name = "InitGameServlet", urlPatterns = {"/initgame"})
public class InitGameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String playerName1 = request.getParameter("player1");
        String playerName2 = request.getParameter("player2");

        GameController gameCtrl = new GameController();

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
            GameController gameCtrl = (GameController) session.getAttribute("game");
            gameCtrl.resetGame();
            session.setAttribute("game", gameCtrl);
            response.sendRedirect("game");
        } else {
            response.sendRedirect("tictactoe");
        }

    }
}
