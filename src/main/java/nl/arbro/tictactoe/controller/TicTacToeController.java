package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.InvalidInputException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By: arbro
 * Date: 26-7-17 - 16:23
 * Project: tictactoe
 **/

@Controller
public class TicTacToeController {

    @PostMapping(value = "/game")
    public String handleGame(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String nextMoveInput = request.getParameter("input");
        BoardGameService gameCtrl = (BoardGameService) session.getAttribute("game");

        Map<String, String> messages = new HashMap<>();
        request.setAttribute("messages", messages);

        try {
            gameCtrl.processMove(nextMoveInput);
        } catch (NumberFormatException e) {
            messages.put("invalidInt", "Your input is not a valid integer");
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
    public String doGet() {
        return "game";
    }

}
