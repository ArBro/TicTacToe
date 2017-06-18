package com.ArBro.tictactoe;

/**
 * Created by ArBro on 24-5-2017.
 */


import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Game {

    private PlayerSet<Player> players = new PlayerSet<>();
    private Set<Token> tokenSet = EnumSet.of(Token.O, Token.X);
    private Scanner scanner = new Scanner(System.in);
    private Board board;

    public void initGame(){
        System.out.println("Welcome to TicTacToe - A game full of surprises!");
        System.out.println("First I would like to know who your are.");

        //add 2 Players with their tokens
        Iterator<Token> it = tokenSet.iterator();
        for (int i = 0; i<2; i++){
            addPlayer(i, it.next());
        }

        this.askForNewGame();
    }

    public void addPlayer(int id, Token token){
        System.out.print("Player" + (id+1) + " , please tell me your name: ");
        String name = scanner.next();

        while (!players.add(new HumanPlayer(id, name, token))){
            System.out.println("You are trying to trick me! The player with that name already signed up!");
            System.out.print("Player" + (id+1) + ", please enter a new player name: ");
            name = scanner.next();
        }
        return;
    }

    private void askForNewGame() {
        //Ask to start a tictactoe
        String userInput;
        do {
            System.out.print("Do you like to start a new game? (Y/N) ");
            userInput = scanner.next();
        } while (!userInput.equalsIgnoreCase("Y") && !userInput.equalsIgnoreCase("N"));

        if (userInput.equalsIgnoreCase("Y")){
            System.out.println("A new game will start. Good luck!");
            this.startNewGame();
            return;
        } else {
            System.out.println("What a pity! Hopefully I will see you back soon!");
        }
    }

    private void startNewGame(){
        //Generate Board
        board = new Board();

        //Determine First Player
        Random playerChooser = new Random();
        Player curPlayer = players.getPlayerById(playerChooser.nextInt(2));
        System.out.println("I randomly picked a player to start first. " + curPlayer.playerName + " it's your lucky day!");

        //NextMove
        board.displayBoard();
        this.playMoves(curPlayer);
        return;
    }

    private void playMoves(Player curPlayer){
        //Get next move
        System.out.print(curPlayer.getPlayerName() + " please enter a value from 1 - 9 for an empty field: ");
        int nextMove = curPlayer.playMove();

        while (board.getIsFilledField(nextMove)) {
            System.out.print("You have not entered an empty field. ");
            System.out.print(curPlayer.getPlayerName() + " please enter a value from 1 - 9 for an empty field: ");
            nextMove = curPlayer.playMove();
        }

        board.fillBoard(nextMove, curPlayer.getPlayToken());
        board.displayBoard();


        TicTacToeWinController winCtrl = new TicTacToeWinController();

        if (!board.getEmptyFieldsLeft() || winCtrl.hasWinner(board.board)){
            if (winCtrl.hasWinner(board.board)) {
                Player winner = players.getPlayerById(winCtrl.winningToken.equals(players.getPlayerById(0).playToken.toString()) ? 0 : 1);
                winCtrl.announceWinner(winner);
            } else {
                winCtrl.announceDraw();
            }

            this.askForNewGame();
            return;
        } else {
            this.playMoves(this.switchCurPlayer(curPlayer));
            return;
        }
    }

    private Player switchCurPlayer(Player curPlayer){
        return players.getPlayerById(curPlayer.equals(players.getPlayerById(0)) ? 1 : 0);
    }

}

