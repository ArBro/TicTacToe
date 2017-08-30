package nl.arbro.tictactoe.model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arbro on 28-6-17.
 */
public class ScoreList extends ScoreComparator {

    private static ScoreList instance = null;
    private static List<Score> scores = new ArrayList<>();

    private ScoreList(){
        this.fetchScores();
    }

    private void addScore(Score score){
        scores.add(score);
    }

    public static ScoreList getInstance(){
        if (instance == null) {
            synchronized (ScoreList.class){
                if (instance == null) {
                    instance = new ScoreList();
                }
            }
        }
        return instance;
    }

    public List<Score> getScores() {
        fetchScores();
        return scores;
    }

    private void fetchScores() {

        TicTacToeDbConnection dbConn = TicTacToeDbConnection.getInstance();

        try (
                Connection conn = dbConn.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet results = stmt.executeQuery("select * from highscores");
        ){
            scores.clear();
            while (results.next()){
                Score score = new Score(results.getLong("equip_id"), results.getString("name"), results.getInt("score"));
                this.addScore(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
