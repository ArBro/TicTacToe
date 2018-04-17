package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.BoardGameHandler;
import nl.arbro.tictactoe.model.GameStatus;
import nl.arbro.tictactoe.model.InvalidInputException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By: arbro
 * Date: 26-7-17 - 16:23
 * Project: tictactoe
 **/

@Controller
@SessionAttributes("game")
public class GameController {

    @PostMapping(value = "/game")
    public String handleGame(Model model,
                             @ModelAttribute("game") BoardGameHandler gameCtrl,
                             @RequestParam("input") String nextMoveInput
    ) {

        Map<String, String> messages = new HashMap<>();
        model.addAttribute("messages", messages);

        try {
            gameCtrl.processMove(nextMoveInput);
//        } catch (NumberFormatException e) {
//            messages.put("invalidInt", "Your input is not a valid integer");
        } catch (InvalidInputException e) {
            messages.put("invalidInput", e.getMessage());
        } finally {
            if (gameCtrl.nextMoveAllowed()) {
                return "redirect:game.html";
            } else {
                return "winner";
            }
        }
    }

    @GetMapping(value = "/game")
    public String doGet(ModelMap modelMap) {
        if (modelMap.containsAttribute("game")){
            BoardGameHandler gameCtrl = (BoardGameHandler) modelMap.get("game");
            GameStatus gameStatus = gameCtrl.getGame().getGameStatus();
            if (gameStatus == GameStatus.WINNER || gameStatus == GameStatus.DRAW) {
                return "winner";
            } else {
                return "game";
            }
        } else {
            return "redirect:tictactoe.html";
        }

    }

}
