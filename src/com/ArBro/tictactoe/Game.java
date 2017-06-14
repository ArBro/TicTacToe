package com.ArBro.tictactoe;

/**
 * Created by ABrouwer on 24-5-2017.
 */

import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner gameScanner = new Scanner(System.in);
    private Player Player1 = new HumanPlayer(1, Token.X);
    private Player Player2 = new HumanPlayer(2, Token.O);
    private Player curPlayer;
    private Board board;

    public void initGame(){

        System.out.println("Welcome to TicTacToe - A game full of surprises!");
        System.out.println("First I would like to know who your are.");

        //Get player Names
        System.out.print("Player1, please tell me your name: ");
        Player1.setPlayerName(gameScanner.next());
        System.out.print("Now it's time for Player2 to announce who your are: ");
        Player2.setPlayerName(gameScanner.next());

        this.askForNewGame();
    }

    private void askForNewGame() {
        //Ask to start a tictactoe
        String userInput;
        do {
            System.out.print(Player1.getPlayerName() + " and " + Player2.getPlayerName() + " do you like to start a new game? (Y/N) ");
            userInput = gameScanner.next();
        } while (!userInput.equalsIgnoreCase("Y") && !userInput.equalsIgnoreCase("N"));

        if (userInput.equalsIgnoreCase("Y")){
            System.out.println("A new game will start. Good luck!");
            this.startNewGame();
        } else {
            System.out.println("What a pity! Hopefully I will see you back soon!");
        }
    }

    private void startNewGame(){
        //Generate Board
        board = new Board();

        //Determine First Player
        Random playerChooser = new Random();
        int firstPlayer = playerChooser.nextInt(2) + 1;

        switch(firstPlayer){
            case 1:
                Player1.isFirstToMove = true;
                Player2.isFirstToMove = false;
                curPlayer = Player1;
                break;
            case 2:
                Player1.isFirstToMove = false;
                Player2.isFirstToMove = true;
                curPlayer = Player2;
                break;
        }
        System.out.println("I randomly picked a player to start first. " + curPlayer.playerName + " it's your lucky day!");

        //NextMove
        board.displayBoard();
        this.playMoves();
    }

    private void playMoves(){
        //Get next move
        System.out.print(curPlayer.getPlayerName() + " please enter a value from 1 - 9 for an empty field: ");
        String nextMoveInput = gameScanner.next();
        int nextMove;

        try {
            nextMove = Integer.parseInt(nextMoveInput);
        } catch(NumberFormatException e) {
            System.out.print("Your input is not valid. ");
            this.playMoves();
            return;
        }

        if (nextMove <= 0 || nextMove > 9) {
            System.out.print("Your input is not valid. ");
            this.playMoves();
            return;
        }

        if (board.getIsFilledField(nextMove)){
            System.out.print("You have not entered an empty field. ");
            this.playMoves();
            return;
        }

        board.fillBoard(nextMove, curPlayer.getPlayToken());
        board.displayBoard();

        if (!board.getEmptyFieldsLeft() || board.hasWinner()){
            this.announceWinner();
        } else {
            this.switchCurPlayer();
            this.playMoves();
            return;
        }
    }

    private void switchCurPlayer(){
        if(curPlayer.getPlayerId() == 1){
            curPlayer = Player2;
        } else {
            curPlayer = Player1;
        }
    }

    private void announceWinner() {
        if (board.hasWinner()) {
            if (board.winningToken.equals(Player1.playToken.toString())) {
                System.out.println(Player1.getPlayerName() + " has won. Congratulations!");
            } else {
                System.out.println(Player2.getPlayerName() + " has won. Congratulations!");
            }
        } else {
            System.out.println("I can't decide who has won. It is a draw.");
        }

        this.askForNewGame();
    }

}

