package nl.arbro.tictactoe.model;

import java.util.regex.Pattern;

/**
 * Created By: arbro
 * Date: 13-4-18 - 15:23
 * Project: tictactoe
 **/

public interface WinCalculator {

   boolean hasWinner(Board b, Pattern winPat);

}
