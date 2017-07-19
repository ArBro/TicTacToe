package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.HumanPlayer;
import nl.arbro.tictactoe.model.Player;
import nl.arbro.tictactoe.model.PlayerSet;
import nl.arbro.tictactoe.model.Token;

import java.util.Random;

/**
 * Created by ArBro on 28-6-17.
 */
public class PlayerController {

    private PlayerSet players = new PlayerSet();

    public PlayerSet getPlayers() {
        return players;
    }

    public Boolean addPlayer(int id, String name, Token token) throws Exception {

        while (!players.add(new HumanPlayer(id, name, token))){
            return false;
        }

        return true;
    }

    public void addPlayerWeb(int id, String name, Token token) throws Exception {

        while (!players.add(new HumanPlayer(id, name, token))){
            throw new Exception("Duplicate player names");
        }

        return;
    }

    public Player chooseFirstPlayer(){
        Random playerChooser = new Random();
        return this.getPlayers().getPlayerById(playerChooser.nextInt(2));
    }

    public Player switchCurPlayer(Player curPlayer){
        //TODO: What to do if players have all kind of ids?
        return players.getPlayerById(curPlayer.equals(players.getPlayerById(0)) ? 1 : 0);
    }


}
