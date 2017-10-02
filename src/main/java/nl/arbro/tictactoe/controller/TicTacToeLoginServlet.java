package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.LoginHandler;
import nl.arbro.tictactoe.model.User;
import nl.arbro.tictactoe.model.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By: arbro
 * Date: 25-9-17 - 15:56
 * Project: tictactoe
 **/

@WebServlet(name = "TicTacToeLoginServlet", urlPatterns = {"/login"})
public class TicTacToeLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> messages = new HashMap<>();
        request.setAttribute("messages", messages);

        UserRepository userRepo = new UserRepository();
        LoginHandler handler = new LoginHandler(userRepo);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //Validations
        if (username == null || username.isEmpty()) {
            messages.put("name", "Please enter a username");
        }
        if (password == null || password.isEmpty()) {
            messages.put("password", "Please enter a password");
        }

        if (messages.isEmpty()){
            if (handler.processLogin(username, password)){

                User user = userRepo.getUserByName(username);
                user.setLoggedIn(true);
                userRepo.updateUser(user);

                request.getSession().setAttribute("loggedInUsername", user.getUsername());
                request.getSession().setAttribute("loggedInUserRole", user.getUserRole());
                request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/loginsuccess.jsp").forward(request, response);
            } else {
                messages.put("loginError", "Username and password do not match.");
                request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            }
        } else {
            request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loggedInUsername = (String) request.getSession().getAttribute("loggedInUsername");
        if (loggedInUsername == null) {
            request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        } else {
            if (new UserRepository().getUserByName(loggedInUsername) == null) {
                request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            } else {
                request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/loginsuccess.jsp").forward(request, response);
            }
        }

    }
}
