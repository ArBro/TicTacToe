package nl.arbro.tictactoe.controller;

/**
 * Created by ArBro on 18-6-2017.
 */
public interface WinController {

    boolean hasWinner(Object o);
    void announceWinner(Object o);
    void announceDraw();

}