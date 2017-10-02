package nl.arbro.tictactoe.model;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created By: arbro
 * Date: 25-9-17 - 14:35
 * Project: tictactoe
 **/

@Repository
@SuppressWarnings("Duplicates")
public class UserRepository {

    public User getUserByName(String username) {
        TicTacToeDbConnection dbConn = TicTacToeDbConnection.getInstance();
        User resultUser = null;

        try( Connection conn = dbConn.getConnection();
             PreparedStatement prepStatement =
                     conn.prepareStatement(
                             "select u.username, u.password, r.rolename, u.isloggedin from users u " +
                             "left join roles r on u.role = r.roleid " +
                             "where u.username = ?");
        ){
            prepStatement.setString(1, username);
            try (ResultSet result = prepStatement.executeQuery()){
                while (result.next()) {
                    resultUser = new User(
                            result.getString("username"),
                            result.getString("password"),
                            UserRoles.valueOf(result.getString("rolename")),
                            result.getBoolean("isloggedin")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultUser;
    }

    public void updateUser(User user){
        TicTacToeDbConnection dbConn = TicTacToeDbConnection.getInstance();

        try( Connection conn = dbConn.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement("update users set (password, role, isloggedin) = (?,?,?) where username = ?");
        ){
            prepStatement.setString(1, user.getPassword());
            prepStatement.setString(2, user.getUserRole().toString());
            prepStatement.setBoolean(3, user.isLoggedIn());
            prepStatement.setString(4, user.getUsername());
            prepStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
