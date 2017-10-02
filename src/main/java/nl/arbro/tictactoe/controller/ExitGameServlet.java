package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.GameStatus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By: arbro
 * Date: 27-9-17 - 11:21
 * Project: tictactoe
 **/

@WebServlet(name = "ExitGameServlet", urlPatterns = {"/exitgame"})
public class ExitGameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoardGameController gameCtrl = (BoardGameController) request.getSession().getAttribute("game");

        if (gameCtrl == null){
            response.sendRedirect("tictactoe");
        } else {
            GameStatus gameStatus = gameCtrl.getGame().getGameStatus();

            if (gameStatus == GameStatus.WINNER || gameStatus == GameStatus.DRAW) {
                request.getSession().removeAttribute("game");
                response.sendRedirect("tictactoe");

            } else {
                response.sendRedirect("game");
            }
        }


    }
}
