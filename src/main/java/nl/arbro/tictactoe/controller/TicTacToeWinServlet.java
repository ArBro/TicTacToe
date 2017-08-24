package nl.arbro.tictactoe.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By: arbro
 * Date: 31-7-17 - 11:56
 * Project: tictactoe
 **/

@WebServlet(name = "TicTacToeWinServlet", urlPatterns = "/winner")
public class TicTacToeWinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/WEB-INF/winner.jsp").forward(request, response);
    }
}
