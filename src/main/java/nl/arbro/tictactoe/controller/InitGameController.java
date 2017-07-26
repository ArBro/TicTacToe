package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.Board;
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
        Board board = new Board();
        PlayerController playerCtrl = new PlayerController();

        Iterator<Token> it = TOKENSET.iterator();
        try {
            playerCtrl.addPlayerWeb(0, request.getParameter("player1"), it.next());
            playerCtrl.addPlayerWeb(1, request.getParameter("player2"), it.next());
            session.setAttribute("playerCtrl", playerCtrl);

        } catch (Exception e) {
            request.setAttribute("errorMsg", "Please fill in different player names");
            request.getServletContext().getRequestDispatcher("/").forward(request, response);
        }

        session.setAttribute("players", playerCtrl.getPlayers());
        session.setAttribute("curPlayer", playerCtrl.chooseFirstPlayer());
        board.emptyBoard();
        session.setAttribute("board", board);
        session.setAttribute("boardDisplay", board.getBoard());
        session.setAttribute("errorMsg", new String());
        session.setAttribute("gameStarted", "true");

        response.sendRedirect("game");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
