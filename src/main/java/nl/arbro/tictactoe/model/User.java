package nl.arbro.tictactoe.model;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Created By: arbro
 * Date: 25-9-17 - 14:05
 * Project: tictactoe
 **/

public class User {

    private String username;
    private String email;
    private UserRoles userRole;

    public User(String userName, UserRoles role){
        this.username = userName;
        this.userRole = role;
    }

    public String getUsername() {
        return username;
    }

    public UserRoles getUserRole() {
        return userRole;
    }
}
