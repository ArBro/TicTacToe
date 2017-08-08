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

    static final private Set<Token> TOKENSET = EnumSet.allOf(Token.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GameController gameCtrl = new GameController();

        Iterator<Token> it = TOKENSET.iterator();
        try {
            gameCtrl.getPlayers().addPlayer(0, request.getParameter("player1"), it.next());
            gameCtrl.getPlayers().addPlayer(1, request.getParameter("player2"), it.next());
            gameCtrl.getBoard().emptyBoard();
            gameCtrl.getPlayers().chooseFirstPlayer();

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
