package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.User;
import nl.arbro.tictactoe.model.UserRepository;
import nl.arbro.tictactoe.model.UserRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created By: arbro
 * Date: 26-9-17 - 21:00
 * Project: tictactoe
 **/

@Controller
@SessionAttributes({"loggedInUsername", "loggedInUserRole"})
public class LogoutController {

    @GetMapping(value = "logout")
    public String processLogout(ModelMap model, SessionStatus status) {
        if(model.containsAttribute("loggedInUsername")){
            String username = (String) model.get("loggedInUsername");

            UserRepository userRepository = new UserRepositoryImpl();
            User user = userRepository.getUserByName(username);
            user.setLoggedIn(false);
            userRepository.updateUser(user);

            status.setComplete();
        }

        return "logout";
    }
}
