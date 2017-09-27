package nl.arbro.tictactoe.model;

/**
 * Created by ArBro on 24-5-2017.
 */

public abstract class Player {

    static private long playerID_seq = 1L;

    private long playerId;
    private String playerName;
    private Token playToken;
    private Boolean isCurrentPlayer = false;

    //Constructors
    Player(String name, Token token){
        this.playerId = (playerID_seq++);
        this.playToken = token;
        this.playerName = name;
    }

    //Getters & Setters

    public long getPlayerId() {
        return this.playerId;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public Token getPlayToken() {
        return this.playToken;
    }

    public Boolean getIsCurrentPlayer() {
        return isCurrentPlayer;
    }

    public void setIsCurrentPlayer(Boolean b) {
        isCurrentPlayer = b;
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


}