package nl.arbro.tictactoe.model;

import javax.validation.constraints.NotEmpty;

/**
 * Created By: arbro
 * Date: 3-10-17 - 12:37
 * Project: TicTacToe
 **/

public class LoginCredentials {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
