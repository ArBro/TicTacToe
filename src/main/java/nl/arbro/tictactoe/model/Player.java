package nl.arbro.tictactoe.model;

/**
 * Created by ArBro on 24-5-2017.
 */

public abstract class Player {

    int playerId;
    public String playerName;
    public Token playToken;

    //Constructors
    Player(int id, String name){
        this.setPlayerId(id);
        this.setPlayerName(name);
    }

    //Getters & Setters

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Token getPlayToken() {
        return playToken;
    }

    public void setPlayToken(Token playToken) {
        this.playToken = playToken;
    }

    //Equals and Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return playerName != null ? playerName.equals(player.playerName) : player.playerName == null;
    }

    @Override
    public int hashCode() {
        return playerName != null ? playerName.hashCode() : 0;
    }

    //Methods
    public abstract int playMove();

    /*
    savemethod(id, name, winningstreaks)
    1
    Arco
     4 7 5 3 2 6 8
     */

    /*
    loadmethod()
     */

}