package nl.arbro.tictactoe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created By: arbro
 * Date: 2-10-17 - 12:43
 * Project: TicTacToe
 **/

@Controller
public class HomeController {

    @RequestMapping (value = {"/home"})
    public String greeting(Model model) {
        model.addAttribute("hello", "Hello World");
        return "index";
    }

}
