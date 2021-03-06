package nl.arbro.tictactoe.model;

import java.util.EnumSet;
import java.util.regex.Pattern;

/**
 * Created By: arbro
 * Date: 23-8-17 - 11:27
 * Project: tictactoe
 **/

public class TicTacToeGame extends BoardGame {

    @Override
    public void createGame() {
        setBoard(BoardFactory.getBoard(BoardGameType.TICTACTOE));
        setPlayers(new PlayerSet());
        setGameStatus(GameStatus.NOT_STARTED);
        setWinPattern(WinPatternFactory.getPattern(BoardGameType.TICTACTOE));

        EnumSet<? extends Token> tokens = EnumSet.allOf(TicTacToeToken.class);
        setTokenSet(tokens);
    }

    @Override
    public BoardGameMoveCommand createMoveCommand(BoardGameMove move) {
        TicTacToeMoveCommand moveCommand = new TicTacToeMoveCommand(move, this.getBoard());
        return moveCommand;
    }

}
