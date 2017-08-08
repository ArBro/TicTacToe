package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.exceptions.InvalidInputException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by arbro on 10-7-17.
 */

//TODO: Avoid Code break when navigating backwards without an existing game
//TODO: Make sure that on different requests, multiple instances are created

@SuppressWarnings("ALL")
@WebServlet (name = "TicTacToeServlet", urlPatterns = {"/game"})
public class TicTacToeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GameController gameCtrl = (GameController) session.getAttribute("game");
        String nextMoveInput = request.getParameter("input");

        try {
            gameCtrl.progressMove(nextMoveInput);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMsg", "Your input is not a valid integer");
        } catch (InvalidInputException e) {
            request.setAttribute("errorMsg", e.getMessage());
        } finally {
            session.setAttribute("game", gameCtrl);
            if (gameCtrl.nextMoveAllowed()){
                doGet(request, response);
            } else {
                response.sendRedirect("winner");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("errorMsg", new String());
        request.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
    }
}
