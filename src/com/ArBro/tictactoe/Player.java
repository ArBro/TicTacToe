package com.ArBro.tictactoe;

/**
 * Created by ABrouwer on 24-5-2017.
 */


public class Player {

    private int playerId;
    String playerName;
    Token playToken;
    boolean isFirstToMove;
    private boolean isAI = false;

    //Constructors
    Player(int id, Token x){
        this.playerId = id;
        this.playToken = x;
    }

    //Getters
    int getPlayerId(){
        return this.playerId;
    }

    String getPlayerName(){
        return this.playerName;
    }

    Token getPlayToken(){
        return this.playToken;
    }

    public boolean getIsFirstToMove(){
        return this.isFirstToMove;
    }

    public boolean getIsAI(){
        return this.isAI;
    }


    //Setters

    public void setPlayerId(int id){
        this.playerId = id;
    }

    void setPlayerName(String name){
        this.playerName = name;
    }

    public void setPlayToken(Token x){
        this.playToken = x;
    }

    public void setIsFirstToMove(boolean x){
        this.isFirstToMove = x;
    }

    public void setIsAI(boolean x){
        this.isAI = x;
    }

}