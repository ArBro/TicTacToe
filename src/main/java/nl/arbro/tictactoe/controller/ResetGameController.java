package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.BoardGameHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created By: arbro
 * Date: 2-10-17 - 16:59
 * Project: TicTacToe
 **/

@Controller
@SessionAttributes("game")
public class ResetGameController {

    @GetMapping("/resetgame")
    public String initGame(ModelMap model) {

        if(model.containsAttribute("game")){
            BoardGameHandler gameCtrl = (BoardGameHandler) model.get("game");
            gameCtrl.resetGame();
            return "redirect:game.html";
        } else {
            return "redirect:tictactoe.html";
        }

    }
}
