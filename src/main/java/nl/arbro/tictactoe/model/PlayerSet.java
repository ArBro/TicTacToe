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

        throw new RuntimeException("PlayerId not found");

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

    public void addPlayer(String name, Token token) throws IllegalArgumentException {

        while (!players.add(new HumanPlayer(name, token))){
            throw new IllegalArgumentException("Player name already exists, duplicate player name submitted");
        }

        return;
    }

    public void chooseFirstPlayer(){
        for (Player player : players){
            player.setIsCurrentPlayer(false);
        }

        Random playerChooser = new Random();
        int randomNumber = playerChooser.nextInt(players.size());
        Object[] arr = players.toArray();

        long id = ((Player) arr[randomNumber]).getPlayerId();
        getPlayerById(id).setIsCurrentPlayer(true);
    }

    public void setNextPlayer(){
        Iterator<Player> it = players.iterator();
        while (it.hasNext()) {
            Player p = it.next();
            if (p.getIsCurrentPlayer() && it.hasNext()){
                p.setIsCurrentPlayer(false);
                it.next().setIsCurrentPlayer(true);
            } else {
                p.setIsCurrentPlayer(false);
                Iterator<Player> itnew = players.iterator();
                itnew.next().setIsCurrentPlayer(true);
            }
        }

    }
}
