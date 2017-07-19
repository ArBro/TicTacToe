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
import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by arbro on 10-7-17.
 */
//TODO: Avoid Code break when navigating backwards without an existing game

@SuppressWarnings("ALL")
@WebServlet (name = "TicTacToeController", urlPatterns = {"/game"})
public class TicTacToeController extends HttpServlet {

    private PlayerController playerCtrl;
    private TicTacToeWinController winCtrl = new TicTacToeWinController();
    private PlayerSet players;
    private Board board = new Board();
    private Player curPlayer;
    private Set<Token> tokenSet = EnumSet.allOf(Token.class);
    private String errorMsg;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "Start":
                Iterator<Token> it = tokenSet.iterator();
                try {
                    playerCtrl = new PlayerController();
                    playerCtrl.addPlayerWeb(0, request.getParameter("player1"), it.next());
                    playerCtrl.addPlayerWeb(1, request.getParameter("player2"), it.next());

                } catch (Exception e) {
                    errorMsg = "Please fill in different player names";
                    request.setAttribute("errorMsg", errorMsg);
                    request.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                }

                players = playerCtrl.getPlayers();
                curPlayer = playerCtrl.chooseFirstPlayer();
                board.emptyBoard();
                forwardGameRequest(request, response);
                break;

            case "Play move":
                //Capture and process moves
                String nextMoveInput = request.getParameter("input");
                int move;
                errorMsg = new String();
                try {
                    move = Integer.parseInt(nextMoveInput);
                    if (move <= 0 || move > 9) {
                        errorMsg = "Your input is not in the range 1-9";
                        forwardGameRequest(request, response);
                    }

                    if (board.getIsFilledField(move)){
                        errorMsg = "Please fill in a non-empty field";
                        forwardGameRequest(request, response);
                    }

                    board.fillBoard(move, curPlayer.getPlayToken());

                    //Check for a winner of a draw
                    if (!board.getEmptyFieldsLeft() || winCtrl.hasWinner(board.getBoard())) {
                        if (winCtrl.hasWinner(board.getBoard())) {
                            //TODO: What to do if players have all kind of ids?
                            request.setAttribute("winner", curPlayer);
                        } else {
                            request.setAttribute("winner", "draw");
                        }
                        request.setAttribute("board", board.getBoard());
                        request.getServletContext().getRequestDispatcher("/WEB-INF/winner.jsp").forward(request, response);
                    }
                    curPlayer = playerCtrl.switchCurPlayer(curPlayer);
                    forwardGameRequest(request, response);
                } catch (NumberFormatException e) {
                    String errorMsg = "Your input is not a valid integer";
                    forwardGameRequest(request, response);

                }
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

    }

    protected void forwardGameRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (this.errorMsg != null){
            request.setAttribute("errorMsg", this.errorMsg);
        }
        request.setAttribute("players", this.players);
        request.setAttribute("curPlayer", this.curPlayer);
        request.setAttribute("board", this.board.getBoard());
        request.getServletContext().getRequestDispatcher("/WEB-INF/game.jsp").forward(request, response);
    }
}
