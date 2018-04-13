package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.BoardGameFactory;
import nl.arbro.tictactoe.model.BoardGameHandler;
import nl.arbro.tictactoe.model.BoardGameType;
import nl.arbro.tictactoe.model.InitGameForm;
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
 * Date: 26-7-17 - 14:58
 * Project: tictactoe
 **/

@Controller
@SessionAttributes("game")
public class InitGameController {

    private final InitGameForm initGameForm;

    @Autowired
    public InitGameController(InitGameForm initGameForm) {
        this.initGameForm = initGameForm;
    }

    @PostMapping("/tictactoe")
    public String processInitialization(Model model,
                                        @Valid @ModelAttribute("initGameForm") InitGameForm initGameForm,
                                        BindingResult result
    ) {

        if (result.hasErrors()){
            return "tictactoe";
        }

        BoardGameHandler gameCtrl = new BoardGameHandler(BoardGameFactory.getBoardGame(BoardGameType.TICTACTOE));

        try {
            gameCtrl.initGame(initGameForm.getPlayername1(), initGameForm.getPlayername2());
            model.addAttribute("game", gameCtrl);
            return "redirect:game.html";
        } catch (IllegalArgumentException e) {
            result.addError(new ObjectError("duplicateNames", "Please fill in different player names"));
            return "tictactoe";
        }
    }

    @GetMapping("/tictactoe")
    public String checkForActiveGame(Model model, ModelMap modelMap) {
        model.addAttribute("initGameForm", initGameForm);
        if(model.containsAttribute("game")){
            BoardGameHandler gameCtrl = (BoardGameHandler) modelMap.get("game");
            gameCtrl.resetGame();
            return "redirect:game.html";
        } else {
            return "tictactoe";
        }
    }


}
