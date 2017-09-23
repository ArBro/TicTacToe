package nl.arbro.tictactoe.model;

import nl.arbro.tictactoe.model.Score;
import nl.arbro.tictactoe.model.TicTacToeDbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By: arbro
 * Date: 23-9-17 - 19:15
 * Project: tictactoe
 **/

public class ScoresFetcher {

    public List<Score> fetchScores() {

        List<Score> result = new ArrayList<>();

        TicTacToeDbConnection dbConn = TicTacToeDbConnection.getInstance();

        try (
                Connection conn = dbConn.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet results = stmt.executeQuery("select * from highscores");
        ){
            while (results.next()){
                Score score = new Score(
                        results.getLong("equip_id")
                        ,results.getString("name")
                        ,results.getInt("score")
                );
                result.add(score);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }
}
