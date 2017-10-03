package nl.arbro.tictactoe.model;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By: arbro
 * Date: 3-10-17 - 10:00
 * Project: TicTacToe
 **/

@Repository
public interface ScoreRepository {
    List<Score> findAll();
}
