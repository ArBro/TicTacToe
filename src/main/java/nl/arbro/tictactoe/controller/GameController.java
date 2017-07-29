package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.Board;
import nl.arbro.tictactoe.model.Player;
import nl.arbro.tictactoe.model.TicTacToeGame;

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

        String nextMoveInput = request.getParameter("input");

        int move;
        session.setAttribute("errorMsg", new String());

        try {
            move = Integer.parseInt(nextMoveInput);
            if (move <= 0 || move > 9) {
                request.setAttribute("errorMsg", "Your input is not in the range 1-9");
                doGet(request, response);
            }

            if (board.getIsFilledField(move)){
                request.setAttribute("errorMsg", "Please fill in a non-empty field");
                doGet(request, response);
            }

            board.fillBoard(move, curPlayer.getPlayToken());
            session.setAttribute("game", game);

            //Check for a winner or a draw
            TicTacToeWinController winCtrl = new TicTacToeWinController();
            if (!board.getEmptyFieldsLeft() || winCtrl.hasWinner(board.getBoard())) {
                if (winCtrl.hasWinner(board.getBoard())) {
                    session.setAttribute("winner", curPlayer);
                } else {
                    session.setAttribute("winner", "draw");
                }
                request.getServletContext().getRequestDispatcher("/WEB-INF/winner.jsp").forward(request, response);
            }

            game.getPlayers().switchCurPlayer();
            doGet(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("errorMsg", "Your input is not a valid integer");
            doGet(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
    }
}
