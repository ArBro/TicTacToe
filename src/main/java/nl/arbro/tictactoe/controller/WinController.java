package nl.arbro.tictactoe.controller;

import nl.arbro.tictactoe.model.Player;

/**
 * Created by ArBro on 18-6-2017.
 */
public interface WinController {

    boolean hasWinner(Object b);
    void checkWinner(Object b, Object p); //Method with Board and Player as variables
    String announceWinner();
    String announceDraw();

}
