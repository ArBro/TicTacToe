package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.Board;
import nl.arbro.tictactoe.model.TicTacToeGame;
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

@WebServlet(name = "InitGameController", urlPatterns = {"/initgame"})
public class InitGameController extends HttpServlet {

    static final private Set<Token> TOKENSET = EnumSet.allOf(Token.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        TicTacToeGame game = new TicTacToeGame();

        Iterator<Token> it = TOKENSET.iterator();
        try {
            game.getPlayers().addPlayer(0, request.getParameter("player1"), it.next());
            game.getPlayers().addPlayer(1, request.getParameter("player2"), it.next());
            game.getBoard().emptyBoard();
            game.getPlayers().chooseFirstPlayer();

            session.setAttribute("game", game);
            response.sendRedirect("game");

        } catch (Exception e) {
            session.setAttribute("errorMsg", "Please fill in different player names");
            response.sendRedirect("home");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("game") != null){
            TicTacToeGame game = (TicTacToeGame) session.getAttribute("game");
            game.resetGame();
            session.setAttribute("game", game);
            response.sendRedirect("game");
        } else {
            response.sendRedirect("tictactoe");
        }

    }
}
