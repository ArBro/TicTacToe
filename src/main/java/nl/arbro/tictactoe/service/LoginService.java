package nl.arbro.tictactoe.service;

import nl.arbro.tictactoe.model.LoginCredentials;

/**
 * Created By: arbro
 * Date: 3-10-17 - 15:55
 * Project: TicTacToe
 **/

public interface LoginService {

    Boolean processLogin(LoginCredentials credentials);
}
