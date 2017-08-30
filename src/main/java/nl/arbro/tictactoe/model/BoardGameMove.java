package nl.arbro.tictactoe.model;

/**
 * Created By: arbro
 * Date: 25-8-17 - 11:14
 * Project: tictactoe
 **/

public class BoardGameMove {
    private String input;
    private Token token;

    public BoardGameMove(String input, Token token){
        this.input = input;
        this.token = token;
    }

    public String getInput() {
        return input;
    }

    public Token getToken() {
        return token;
    }
}
