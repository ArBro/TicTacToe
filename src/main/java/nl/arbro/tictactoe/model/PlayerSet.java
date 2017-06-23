package nl.arbro.tictactoe.model;

import java.util.Iterator;
import java.util.LinkedHashSet;

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

}
