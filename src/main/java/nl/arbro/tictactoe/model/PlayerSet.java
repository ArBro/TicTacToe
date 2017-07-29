package nl.arbro.tictactoe.model;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

/**
 * Created by ArBro on 18-6-2017.
 */
public class PlayerSet extends LinkedHashSet<Player> {

    //This method probably won't work for very large or very many player sets
    public Player getPlayerById(int id) {
        Iterator<Player> playerIterator = this.iterator();

        while(playerIterator.hasNext()){
            Player p = playerIterator.next();
            if (p.getPlayerId() == id){
                return p;
            }
        }

        throw new RuntimeException("PlayerId not found.");

    }

    public Player getCurrentPlayer(){
        Iterator<Player> playerIterator = this.iterator();

        while(playerIterator.hasNext()){
            Player p = playerIterator.next();
            if (p.getIsCurrentPlayer()){
                return p;
            }
        }

        throw new RuntimeException("No current player found.");
    }

    public void addPlayer(int id, String name, Token token) throws Exception {

        while (!add(new HumanPlayer(id, name, token))){
            throw new Exception("Duplicate player names");
        }

        return;
    }

    public void chooseFirstPlayer(){
        Random playerChooser = new Random();
        this.getPlayerById(playerChooser.nextInt(1)).setIsCurrentPlayer(true);
    }

    public void switchCurPlayer(){
        //TODO: What to do if players have all kind of ids?
        //TODO: SwitchCurrentplayer gives nullexception
        Iterator<Player> playerIterator = this.iterator();

        while(playerIterator.hasNext()){
            Player p = playerIterator.next();
            p.setIsCurrentPlayer(!p.getIsCurrentPlayer());
        }
    }

}
