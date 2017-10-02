package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.LoginHandler;
import nl.arbro.tictactoe.model.User;
import nl.arbro.tictactoe.model.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

@Controller
public class LoginController {

    @PostMapping (value = "/login")
    public String processLogin (HttpServletRequest request){

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
                return "loginsuccess";
            } else {
                messages.put("loginError", "Username and password do not match.");
                return "login";
            }
        } else {
            return "login";
        }

    }

    @GetMapping (value = "/login")
    public String showLoginPage(HttpServletRequest request) {
        String loggedInUsername = (String) request.getSession().getAttribute("loggedInUsername");
        if (loggedInUsername == null) {
            return "login";
        } else {
            if (new UserRepository().getUserByName(loggedInUsername) == null) {
                return "login";
            } else {
                return "loginsuccess";
            }
        }

    }
}
