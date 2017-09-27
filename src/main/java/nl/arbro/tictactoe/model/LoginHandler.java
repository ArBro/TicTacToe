package nl.arbro.tictactoe.model;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Created By: arbro
 * Date: 25-9-17 - 14:17
 * Project: tictactoe
 **/

public class LoginHandler {

    private UserFetcher fetcher;

    public LoginHandler(UserFetcher fetcher) {
        this.fetcher = fetcher;
    }

    public Boolean processLogin(String username, String password) {

        String pass = fetcher.getPassword(username);

        if (pass != null){
            return BCrypt.checkpw(password, fetcher.getPassword(username));
        }
        return false;

    }
}
