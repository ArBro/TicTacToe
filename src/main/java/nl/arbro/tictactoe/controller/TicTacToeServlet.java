package nl.arbro.tictactoe.controller;

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
 * Created by arbro on 10-7-17.
 */

@WebServlet (name = "TicTacToeServlet", urlPatterns = {"/game"})
public class TicTacToeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nextMoveInput = request.getParameter("input");
        BoardGameController gameCtrl = (BoardGameController) session.getAttribute("game");

        Map<String, String> messages = new HashMap<>();
        request.setAttribute("messages", messages);

        try {
            gameCtrl.processMove(nextMoveInput);
        } catch (NumberFormatException e) {
            messages.put("invalidInt", "Your input is not a valid integer");
        } catch (InvalidInputException e) {
            messages.put("invalidInput", e.getMessage());
        } finally {
            if (gameCtrl.nextMoveAllowed()){
                response.sendRedirect("game");
            } else {
                request.getServletContext().getRequestDispatcher("/WEB-INF/winner.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
    }
}
