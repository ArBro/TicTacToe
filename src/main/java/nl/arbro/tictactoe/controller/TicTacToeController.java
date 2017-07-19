package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.Board;
import nl.arbro.tictactoe.model.Player;
import nl.arbro.tictactoe.model.PlayerSet;
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
 * Created by arbro on 10-7-17.
 */
//TODO: Avoid Code break when navigating backwards without an existing game
//TODO: Make sure that on different requests, multiple instances are created

@SuppressWarnings("ALL")
@WebServlet (name = "TicTacToeController", urlPatterns = {"/game"})
public class TicTacToeController extends HttpServlet {

    static final private Set<Token> tokenSet = EnumSet.allOf(Token.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action){
            case "Start":
                HttpSession session = request.getSession();
                Board board = new Board();
                PlayerController playerCtrl = new PlayerController();

                Iterator<Token> it = tokenSet.iterator();
                try {
                    playerCtrl.addPlayerWeb(0, request.getParameter("player1"), it.next());
                    playerCtrl.addPlayerWeb(1, request.getParameter("player2"), it.next());
                    session.setAttribute("playerCtrl", playerCtrl);

                } catch (Exception e) {
                    request.setAttribute("errorMsg", "Please fill in different player names");
                    request.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                }

                session.setAttribute("players", playerCtrl.getPlayers());
                session.setAttribute("curPlayer", playerCtrl.chooseFirstPlayer());
                board.emptyBoard();
                session.setAttribute("board", board);
                session.setAttribute("boardDisplay", board.getBoard());
                session.setAttribute("errorMsg", new String());
                request.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
                break;

            case "Play move":
                //Capture and process moves
                session = request.getSession();
                String nextMoveInput = request.getParameter("input");
                Player curPlayer = (Player) session.getAttribute("curPlayer");
                playerCtrl = (PlayerController) session.getAttribute("playerCtrl");
                int move;
                session.setAttribute("errorMsg", new String());
                try {
                    move = Integer.parseInt(nextMoveInput);
                    if (move <= 0 || move > 9) {
                        request.setAttribute("errorMsg", "Your input is not in the range 1-9");
                        request.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
                    }

                    board = (Board) session.getAttribute("board");
                    if (board.getIsFilledField(move)){
                        request.setAttribute("errorMsg", "Please fill in a non-empty field");
                        request.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
                    }

                    board.fillBoard(move, curPlayer.getPlayToken());
                    session.setAttribute("board", board);

                    //Check for a winner or a draw
                    TicTacToeWinController winCtrl = new TicTacToeWinController();
                    if (!board.getEmptyFieldsLeft() || winCtrl.hasWinner(board.getBoard())) {
                        if (winCtrl.hasWinner(board.getBoard())) {
                            //TODO: What to do if players have all kind of ids?
                            request.setAttribute("winner", curPlayer);
                        } else {
                            request.setAttribute("winner", "draw");
                        }
                        request.setAttribute("board", board.getBoard());
                        session.setAttribute("boardDisplay", board.getBoard());
                        request.getServletContext().getRequestDispatcher("/WEB-INF/winner.jsp").forward(request, response);
                    }
                    session.setAttribute("curPlayer", playerCtrl.switchCurPlayer(curPlayer));
                    request.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
                } catch (NumberFormatException e) {
                    request.setAttribute("errorMsg", "Your input is not a valid integer");
                    request.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
                }
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

    }
}
