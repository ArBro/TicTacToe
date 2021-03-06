package nl.arbro.tictactoe.repository;

import nl.arbro.tictactoe.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created By: arbro
 * Date: 3-10-17 - 9:58
 * Project: TicTacToe
 **/

@Repository
public interface UserRepository {
    User getUserByName(String username);
    void updateUser(User user);
}
