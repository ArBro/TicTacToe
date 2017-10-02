package nl.arbro.tictactoe.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By: arbro
 * Date: 26-7-17 - 16:23
 * Project: tictactoe
 **/

@WebServlet(name = "TicTacToeServlet", urlPatterns = {"/tictactoe", ""})
public class TicTacToeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/tictactoe.jsp").forward(request, response);
    }
}
