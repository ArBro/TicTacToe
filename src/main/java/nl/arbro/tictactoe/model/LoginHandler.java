package nl.arbro.tictactoe.model;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Created By: arbro
 * Date: 25-9-17 - 14:17
 * Project: tictactoe
 **/

public class LoginHandler {

    private UserRepository userRepo;

    public LoginHandler(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public Boolean processLogin(String username, String inputPass) {

        if(userRepo.getUserByName(username) != null){
            String userPass = userRepo.getUserByName(username).getPassword();

            if (userPass != null){
                return BCrypt.checkpw(inputPass, userPass);
            }
        }

        return false;
    }
}
