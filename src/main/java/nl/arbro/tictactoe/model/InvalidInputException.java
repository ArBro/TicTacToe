package nl.arbro.tictactoe.model;

/**
 * Created By: arbro
 * Date: 31-7-17 - 10:19
 * Project: tictactoe
 **/

public class InvalidInputException extends IllegalArgumentException {

    public InvalidInputException(String s) {
        super(s);
    }

}
