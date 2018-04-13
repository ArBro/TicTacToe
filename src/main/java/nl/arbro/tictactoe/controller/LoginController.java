package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.*;
import nl.arbro.tictactoe.repository.UserRepository;
import nl.arbro.tictactoe.repository.UserRepositoryImpl;
import nl.arbro.tictactoe.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginService loginService;
    @Autowired
    private LoginCredentials loginCredentials;


    @PostMapping (value = "/login")
    public String processLogin (Model model,
                                @Valid @ModelAttribute("loginCredentials") LoginCredentials credentials,
                                BindingResult result
    ){

        if (result.hasErrors()) {
            return "login";
        }

        if (loginService.processLogin(credentials)){

            User user = userRepository.getUserByName(credentials.getUsername());
            user.setLoggedIn(true);
            userRepository.updateUser(user);

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
        model.addAttribute("loginCredentials", loginCredentials);
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
