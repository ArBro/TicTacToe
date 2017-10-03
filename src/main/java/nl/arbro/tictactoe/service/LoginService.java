package nl.arbro.tictactoe.service;

import nl.arbro.tictactoe.model.LoginCredentials;
import nl.arbro.tictactoe.model.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * Created By: arbro
 * Date: 25-9-17 - 14:17
 * Project: tictactoe
 **/

@Service
public class LoginService {

    private UserRepository userRepo;

    public LoginService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public Boolean processLogin(LoginCredentials credentials) {

        if(userRepo.getUserByName(credentials.getUsername()) != null){
            String userPass = userRepo.getUserByName(credentials.getUsername()).getPassword();

            if (userPass != null){
                return BCrypt.checkpw(credentials.getPassword(), userPass);
            }
        }

        return false;
    }
}
