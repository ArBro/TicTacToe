package com.ArBro.tictactoe;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by ArBro on 18-6-2017.
 */
public class PlayerSet<P> extends LinkedHashSet<P> {

    //This method probably won't work for large player sets
    public Player getPlayerById(int id) {
        Iterator playerIterator = this.iterator();
        Player p;

        do {
            p = (Player) playerIterator.next();
        } while (playerIterator.hasNext() && p.getPlayerId() != id);

        return p;
    }

}
