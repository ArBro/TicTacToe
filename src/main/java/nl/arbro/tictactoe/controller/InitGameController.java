package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.BoardGameFactory;
import nl.arbro.tictactoe.model.BoardGameHandler;
import nl.arbro.tictactoe.model.BoardGameType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By: arbro
 * Date: 26-7-17 - 14:58
 * Project: tictactoe
 **/

@Controller
@SessionAttributes("game")
public class InitGameController {

    @PostMapping("/tictactoe")
    public String processInitialization(Model model, @RequestParam Map<String, String> requestParams) {
        Map<String, String> messages = new HashMap<>();
        model.addAttribute("messages", messages);

        String playerName1 = requestParams.get("player1");
        String playerName2 = requestParams.get("player2");

        BoardGameHandler gameCtrl = new BoardGameHandler(BoardGameFactory.getBoardGame(BoardGameType.TICTACTOE));

        try {
            gameCtrl.initGame(playerName1, playerName2);
            model.addAttribute("game", gameCtrl);
            return "redirect:game.html";
        } catch (IllegalArgumentException e) {
            messages.put("names", "Please fill in different player names");
            return "tictactoe";
        }
    }

    @GetMapping("/tictactoe")
    public String checkForActiveGame(Model model) {
        Map<String, Object> modelMap = model.asMap();
        if(model.containsAttribute("game")){
            BoardGameHandler gameCtrl = (BoardGameHandler) modelMap.get("game");
            gameCtrl.resetGame();
            return "redirect:game.html";
        } else {
            return "tictactoe";
        }
    }


}
