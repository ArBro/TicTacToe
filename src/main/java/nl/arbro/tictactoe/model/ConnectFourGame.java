package nl.arbro.tictactoe.model;

import java.util.EnumSet;

/**
 * Created By: arbro
 * Date: 13-4-18 - 13:39
 * Project: tictactoe
 **/

public class ConnectFourGame extends BoardGame {


    @Override
    public void createGame() {
        setBoard(BoardFactory.getBoard(BoardGameType.CONNECT_FOUR));
        setPlayers(new PlayerSet());
        setGameStatus(GameStatus.NOT_STARTED);
        setWinPattern(WinPatternFactory.getPattern(BoardGameType.CONNECT_FOUR));

        EnumSet<? extends Token> tokens = EnumSet.allOf(TicTacToeToken.class);
        setTokenSet(tokens);
    }

    @Override
    public BoardGameMoveCommand createMoveCommand(BoardGameMove move) {
        ConnectFourMoveCommand moveCommand = new ConnectFourMoveCommand(move, this.getBoard());
        return moveCommand;
    }

}
