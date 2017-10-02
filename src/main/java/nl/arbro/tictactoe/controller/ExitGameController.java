package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.GameStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By: arbro
 * Date: 27-9-17 - 11:21
 * Project: tictactoe
 **/

@Controller
public class ExitGameController {

    @GetMapping(value={"/exitgame"})
    public String exitGame (HttpServletRequest request) {
        BoardGameService gameCtrl = (BoardGameService) request.getSession().getAttribute("game");

        if (gameCtrl == null){
            return "redirect:tictactoe.html";
        } else {
            GameStatus gameStatus = gameCtrl.getGame().getGameStatus();

            if (gameStatus == GameStatus.WINNER || gameStatus == GameStatus.DRAW) {
                request.getSession().removeAttribute("game");
                return "redirect:tictactoe.html";

            } else {
                return "redirect:game.html";
            }
        }
    }
}
