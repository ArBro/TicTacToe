package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.Board;
import nl.arbro.tictactoe.exceptions.InvalidInputException;
import nl.arbro.tictactoe.model.Player;
import nl.arbro.tictactoe.model.TicTacToeGame;
import nl.arbro.tictactoe.model.WinStatus;

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
@WebServlet (name = "GameController", urlPatterns = {"/game"})
public class GameController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        TicTacToeGame game = (TicTacToeGame) session.getAttribute("game");
        Player curPlayer = game.getPlayers().getCurrentPlayer();
        Board board = game.getBoard();
        TicTacToeWinController winCtrl = game.getWinCtrl();

        String nextMoveInput = request.getParameter("input");

        int move;

        try {
            move = Integer.parseInt(nextMoveInput); //Throws IllegalArgumentException
            if (move <= 0 || move > 9) {
                throw new InvalidInputException("Your input is not in the range 1-9");
            }

            if (board.getIsFilledField(move)){
                throw new InvalidInputException("Please fill in a non-empty field");
            }

            board.fillBoard(move, curPlayer.getPlayToken());


            //Check for a winner or a draw
            winCtrl.checkWinner(board, curPlayer);
            if (winCtrl.getWinCategory() != WinStatus.Playing) {
                session.setAttribute("game", game);
                response.sendRedirect("winner");
            }

            game.getPlayers().switchCurPlayer();

        } catch (NumberFormatException e) {
            request.setAttribute("errorMsg", "Your input is not a valid integer");
        } catch (InvalidInputException e) {
            request.setAttribute("errorMsg", e.getMessage());
        } finally {
            session.setAttribute("game", game);
            if(winCtrl.getWinCategory() == WinStatus.Playing) {
                doGet(request, response);
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
