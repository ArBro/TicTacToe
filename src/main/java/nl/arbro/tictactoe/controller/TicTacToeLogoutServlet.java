package nl.arbro.tictactoe.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created By: arbro
 * Date: 26-9-17 - 21:00
 * Project: tictactoe
 **/

@WebServlet(name = "TicTacToeLogoutServlet", urlPatterns = {"/logout"})
public class TicTacToeLogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        request.getServletContext().getRequestDispatcher("/WEB-INF/logout.jsp").forward(request, response);
    }
}
