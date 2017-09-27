package nl.arbro.tictactoe.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created By: arbro
 * Date: 25-9-17 - 14:35
 * Project: tictactoe
 **/

public class UserFetcher {

    public User getUserByName(String username) {
        TicTacToeDbConnection dbConn = TicTacToeDbConnection.getInstance();
        User resultUser = null;

        try( Connection conn = dbConn.getConnection();
             PreparedStatement prepStatement =
                     conn.prepareStatement(
                             "select u.username, r.rolename from users u " +
                             "left join roles r on u.role = r.roleid " +
                             "where u.username = ?");
        ){
            prepStatement.setString(1, username);
            try (ResultSet result = prepStatement.executeQuery()){
                while (result.next()) {
                    resultUser = new User(
                            result.getString("username"),
                            UserRoles.valueOf(result.getString("rolename"))
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return resultUser;
    }

    public String getPassword(String username) {
        TicTacToeDbConnection dbConn = TicTacToeDbConnection.getInstance();
        String password = null;

        try( Connection conn = dbConn.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement("select password from users where username = ?");
        ){
            prepStatement.setString(1, username);
            try (ResultSet result = prepStatement.executeQuery()){
                result.next();
                password = result.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return password;
    }

}
