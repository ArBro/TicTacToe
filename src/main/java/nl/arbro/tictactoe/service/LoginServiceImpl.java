package nl.arbro.tictactoe.service;

import nl.arbro.tictactoe.model.LoginCredentials;
import nl.arbro.tictactoe.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created By: arbro
 * Date: 25-9-17 - 14:17
 * Project: tictactoe
 **/

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    private UserRepository userRepository;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean processLogin(LoginCredentials credentials) {

        if (userRepository.getUserByName(credentials.getUsername()) != null) {
            String userPass = userRepository.getUserByName(credentials.getUsername()).getPassword();

            if (userPass != null) {
                return BCrypt.checkpw(credentials.getPassword(), userPass);

            }
        }

        return false;
    }
}
