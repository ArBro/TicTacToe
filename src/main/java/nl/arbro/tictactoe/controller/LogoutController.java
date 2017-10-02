package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.User;
import nl.arbro.tictactoe.model.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

@Controller
public class LogoutController {

    @PostMapping(value = "logout")
    public String processLogout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("loggedInUsername");

        UserRepository userRepository = new UserRepository();
        User user = userRepository.getUserByName(username);
        user.setLoggedIn(false);
        userRepository.updateUser(user);

        session.removeAttribute("loggedInUsername");
        session.removeAttribute("loggedInUserRole");

        return "logout";
    }
}
