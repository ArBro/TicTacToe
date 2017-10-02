package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.BoardGameFactory;
import nl.arbro.tictactoe.model.BoardGameType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By: arbro
 * Date: 26-7-17 - 14:58
 * Project: tictactoe
 **/

@Controller
public class InitGameController {

    @PostMapping("/tictactoe")
    public String processInitialization(HttpServletRequest request) {
        Map<String, String> messages = new HashMap<>();
        request.setAttribute("messages", messages);

        HttpSession session = request.getSession();
        String playerName1 = request.getParameter("player1");
        String playerName2 = request.getParameter("player2");

        BoardGameService gameCtrl = new BoardGameService(BoardGameFactory.getBoardGame(BoardGameType.TICTACTOE));

        try {
            gameCtrl.initGame(playerName1, playerName2);
            session.setAttribute("game", gameCtrl);
            return "redirect:game.html";
        } catch (IllegalArgumentException e) {
            messages.put("names", "Please fill in different player names");
            return "tictactoe";
        }
    }

    @GetMapping("/tictactoe")
    public String checkForActiveGame(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session.getAttribute("game") != null){
            BoardGameService gameCtrl = (BoardGameService) session.getAttribute("game");
            gameCtrl.resetGame();
            session.setAttribute("game", gameCtrl);
            return "redirect:game.html";
        } else {
            return "tictactoe";
        }
    }

    @GetMapping("/resetgame")
    public String initGame(HttpServletRequest request) {
        HttpSession session = request.getSession();
        BoardGameService gameCtrl = (BoardGameService) session.getAttribute("game");

        if (gameCtrl != null){
            return "redirect:tictactoe.html";
        } else {
            gameCtrl.resetGame();
            return "forward:game.html";
        }

    }

}
