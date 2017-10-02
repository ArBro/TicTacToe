package nl.arbro.tictactoe.model;

/**
 * Created By: arbro
 * Date: 25-9-17 - 14:05
 * Project: tictactoe
 **/

public class User {

    private String username;
    private String password;
    //private String email;
    private UserRoles userRole;
    private boolean isLoggedIn = false;

    public User(String userName, String password, UserRoles role, boolean isLoggedIn){
        this.username = userName;
        this.password = password;
        this.userRole = role;
        this.isLoggedIn = isLoggedIn;
    }

    public String getUsername() {
        return username;
    }

    public UserRoles getUserRole() {
        return userRole;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
