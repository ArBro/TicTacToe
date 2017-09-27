package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.BoardGameFactory;
import nl.arbro.tictactoe.model.BoardGameType;
import nl.arbro.tictactoe.model.InvalidInputException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By: arbro
 * Date: 26-7-17 - 14:58
 * Project: tictactoe
 **/

@WebServlet(name = "TicTacToeInitGameServlet", urlPatterns = {"/initgame"})
public class TicTacToeInitGameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> messages = new HashMap<>();
        request.setAttribute("messages", messages);

        HttpSession session = request.getSession();
        String playerName1 = request.getParameter("player1");
        String playerName2 = request.getParameter("player2");

        BoardGameController gameCtrl = new BoardGameController(BoardGameFactory.getBoardGame(BoardGameType.TICTACTOE));

        try {
            gameCtrl.initGame(playerName1, playerName2);
            session.setAttribute("game", gameCtrl);
            response.sendRedirect("game");
        } catch (IllegalArgumentException e) {
            messages.put("names", "Please fill in different player names");
            request.getServletContext().getRequestDispatcher("/WEB-INF/tictactoehome.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("game") != null){
            BoardGameController gameCtrl = (BoardGameController) session.getAttribute("game");
            gameCtrl.resetGame();
            session.setAttribute("game", gameCtrl);
            response.sendRedirect("game");
        } else {
            response.sendRedirect("tictactoe");
        }

    }
}
