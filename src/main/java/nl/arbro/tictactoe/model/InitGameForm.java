package nl.arbro.tictactoe.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

/**
 * Created By: arbro
 * Date: 6-10-17 - 11:16
 * Project: TicTacToe
 **/

@Component("initGameForm")
@Scope("prototype")
public class InitGameForm {

    @NotEmpty
    private String playername1;

    @NotEmpty
    private String playername2;

    private BoardGameType gameType = BoardGameType.TICTACTOE;

    public String getPlayername1() {
        return playername1;
    }

    public void setPlayername1(String playername1) {
        this.playername1 = playername1;
    }

    public String getPlayername2() {
        return playername2;
    }

    public void setPlayername2(String playername2) {
        this.playername2 = playername2;
    }

    public BoardGameType getGameType() {
        return gameType;
    }

    public void setGameType(BoardGameType gameType) {
        this.gameType = gameType;
    }
}
