package nl.arbro.tictactoe.exceptions;

/**
 * Created By: arbro
 * Date: 31-7-17 - 10:19
 * Project: tictactoe
 **/

public class InvalidInputException extends IllegalArgumentException {

    private String message;

    public InvalidInputException(String s) {
        this.setMessage(s);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
