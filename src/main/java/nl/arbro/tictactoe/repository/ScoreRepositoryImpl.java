package nl.arbro.tictactoe.repository;

import nl.arbro.tictactoe.model.Score;
import nl.arbro.tictactoe.model.TicTacToeDbConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By: arbro
 * Date: 23-9-17 - 19:15
 * Project: tictactoe
 **/

@Repository("scoreRepository")
public class ScoreRepositoryImpl implements ScoreRepository {

    @Override
    public List<Score> findAll() {

        List<Score> fetchedScores = new ArrayList<>();

        TicTacToeDbConnection dbConn = TicTacToeDbConnection.getInstance();

        StringBuilder query = new StringBuilder();
        query.append("select hs.score, u.username, hs.achieved_date ");
        query.append("from highscores as hs ");
        query.append("left join users as u on ");
        query.append("hs.playerid = u.userid");

        try (
                Connection conn = dbConn.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet results = stmt.executeQuery(query.toString())
        ){
            while (results.next()){
                Score score = new Score(
                        results.getString("username")
                        ,results.getInt("score")
                        ,results.getDate("achieved_date").toLocalDate()
                );
                fetchedScores.add(score);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fetchedScores;

    }
}
