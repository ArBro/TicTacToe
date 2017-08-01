package nl.arbro.tictactoe.errorhandlers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created By: arbro
 * Date: 31-7-17 - 10:05
 * Project: tictactoe
 **/

@WebServlet(name = "PageNotFoundHandler", urlPatterns = "/pagenotfound")
public class PageNotFoundHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("tictactoe");
    }
}
