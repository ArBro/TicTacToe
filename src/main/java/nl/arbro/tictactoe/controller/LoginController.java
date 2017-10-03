package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.*;
import nl.arbro.tictactoe.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created By: arbro
 * Date: 25-9-17 - 15:56
 * Project: tictactoe
 **/

@Controller
@SessionAttributes({"loggedInUsername", "loggedInUserRole"})
public class LoginController {

    @PostMapping (value = "/login")
    public String processLogin (Model model,
                                @Valid @ModelAttribute("loginCredentials") LoginCredentials credentials,
                                BindingResult result
    ){
        UserRepository userRepo = new UserRepositoryImpl();
        LoginService handler = new LoginService(userRepo);

        if (result.hasErrors()) {
            return "login";
        }

        if (handler.processLogin(credentials)){

            User user = userRepo.getUserByName(credentials.getUsername());
            user.setLoggedIn(true);
            userRepo.updateUser(user);

            model.addAttribute("loggedInUsername", user.getUsername());
            model.addAttribute("loggedInUserRole", user.getUserRole());
            return "loginsuccess";
        } else {
            result.addError(new ObjectError("loginError", "Username and password do not match"));
            return "login";
        }

    }

    @GetMapping (value = "/login")
    public String showLoginPage(ModelMap model) {
        model.addAttribute("loginCredentials", new LoginCredentials());
        String loggedInUsername = (String) model.get("loggedInUsername");
        if (loggedInUsername == null) {
            return "login";
        } else {
            if (new UserRepositoryImpl().getUserByName(loggedInUsername) == null) {
                return "login";
            } else {
                return "loginsuccess";
            }
        }

    }
}
