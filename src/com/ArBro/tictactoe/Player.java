package com.ArBro.tictactoe;

/**
 * Created by ABrouwer on 24-5-2017.
 */

public class Player {

    private int playerId;
    Token playToken;
    boolean isFirstToMove;
    String playerName;

    //Constructors
    Player(int id, Token x){
        setPlayerId(id);
        setPlayToken(x);
    }

    //Getters
    int getPlayerId(){
        return this.playerId;
    }
    Token getPlayToken(){
        return this.playToken;
    }
    public boolean getIsFirstToMove(){
        return this.isFirstToMove;
    }
    String getPlayerName() {
        return playerName;
    }

    //Setters
    public void setPlayerId(int id){
        this.playerId = id;
    }
    public void setPlayToken(Token x){
        this.playToken = x;
    }
    public void setIsFirstToMove(boolean x){
        this.isFirstToMove = x;
    }
    void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}