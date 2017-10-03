package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.BoardGameHandler;
import nl.arbro.tictactoe.model.GameStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

/**
 * Created By: arbro
 * Date: 27-9-17 - 11:21
 * Project: tictactoe
 **/

@Controller
@SessionAttributes("game")
public class ExitGameController {

    @GetMapping(value={"/exitgame"})
    public String exitGame (ModelMap model, SessionStatus status) {

        if (model.containsAttribute("game")){
            BoardGameHandler gameCtrl = (BoardGameHandler) model.get("game");
            GameStatus gameStatus = gameCtrl.getGame().getGameStatus();

            if (gameStatus == GameStatus.WINNER || gameStatus == GameStatus.DRAW) {
                status.setComplete();
                return "redirect:tictactoe.html";

            } else {
                return "redirect:game.html";
            }

        } else {
            return "redirect:tictactoe.html";
        }
    }
}
