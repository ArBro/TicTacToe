package nl.arbro.tictactoe.model;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by ArBro on 18-6-2017.
 */
public class PlayerSet {

    private Set<Player> players = new LinkedHashSet<>();

    //This method probably won't work for very large or very many player sets
    public Player getPlayerById(long id) {
        Iterator<Player> playerIterator = players.iterator();

        while(playerIterator.hasNext()){
            Player p = playerIterator.next();
            if (p.getPlayerId() == id){
                return p;
            }
        }

        throw new RuntimeException("PlayerId not found.");

    }

    public Player getCurrentPlayer(){
        Iterator<Player> playerIterator = players.iterator();

        while(playerIterator.hasNext()){
            Player p = playerIterator.next();
            if (p.getIsCurrentPlayer()){
                return p;
            }
        }

        throw new RuntimeException("No current player found.");
    }

    public void addPlayer(String name, Token token) throws Exception {

        while (!players.add(new HumanPlayer(name, token))){
            throw new Exception("Duplicate player names");
        }

        return;
    }

    public void chooseFirstPlayer(){
        for (Player player : players){
            player.setIsCurrentPlayer(false);
        }

        Random playerChooser = new Random();
        getPlayerById(playerChooser.nextInt(players.size())).setIsCurrentPlayer(true);
    }

    public void setNextPlayer(){
        long curPlayerId = this.getCurrentPlayer().getPlayerId();
        long nextPlayerId;
        if (curPlayerId < players.size()){
            nextPlayerId = curPlayerId + 1;
        } else {
            nextPlayerId = 1L;
        }

        for (Player player : players) {
            if ((player.getPlayerId() == nextPlayerId)) {
                player.setIsCurrentPlayer(true);
            } else {
                player.setIsCurrentPlayer(false);
            }
        }

    }

}
