package nl.arbro.tictactoe;

import nl.arbro.tictactoe.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created By: arbro
 * Date: 20-9-17 - 13:57
 * Project: tictactoe
 **/

public class TicTacToeGameTest {

    private static final BoardGameMoveHandler MOVE_HANDLER = new BoardGameMoveHandler();

    private BoardGameMove mockMove = mock(BoardGameMove.class);
    private BoardGame game;

    @Before
    public void initTicTacToeGame(){
        game = BoardGameFactory.getBoardGame(BoardGameType.TICTACTOE);
        game.createGame();
    }


    @Test
    public void test_createGame_TicTacToeGame() throws ClassNotFoundException {

        //then
        assertEquals(Class.forName("nl.arbro.tictactoe.model.TicTacToeGame"), game.getClass());
        assertEquals(Class.forName("nl.arbro.tictactoe.model.TicTacToeBoard"), game.getBoard().getClass());
    }

    @Test
    public void test_hasWinner_WinnerHorizontal(){
        String[][] exampleBoard = {{"O", "O", "O"},{},{}};

        Board mockBoard = mock(Board.class);
        when(mockBoard.getBoard()).thenReturn(exampleBoard);

        assertEquals(true,  game.hasWinner(mockBoard));
    }

    @Test
    public void test_hasWinner_WinnerVertical(){
        String[][] exampleBoard = {{"O","",""},{"O","",""},{"O","",""}};

        Board mockBoard = mock(Board.class);
        when(mockBoard.getBoard()).thenReturn(exampleBoard);

        assertEquals(true,  game.hasWinner(mockBoard));
    }

    @Test
    public void test_hasWinner_WinnerDiagonal(){
        String[][] exampleBoard = {{"O", "X", "X"},{"","O",""},{"","","O"}};
        Board mockBoard = mock(Board.class);
        when(mockBoard.getBoard()).thenReturn(exampleBoard);

        assertEquals(true,  game.hasWinner(mockBoard));
    }

    @Test
    public void test_hasWinner_NoWinnerAtFullBoard(){
        String[][] exampleBoard = {{"O", "X", "O"},{"X", "X", "O"},{"O", "O", "X"}};
        Board mockBoard = mock(Board.class);
        when(mockBoard.getBoard()).thenReturn(exampleBoard);

        assertEquals(false,  game.hasWinner(mockBoard));
    }

    @Test
    public void test_processMove_Success(){
        when(mockMove.getInput()).thenReturn("2");
        when(mockMove.getToken()).thenReturn(TicTacToeToken.O);

        Board board = new TicTacToeBoard();

        BoardGameMoveCommand moveCommand = new TicTacToeMoveCommand(mockMove, board);
        MOVE_HANDLER.processMove(moveCommand);

        String result = board.getBoard()[0][1];
        assertEquals(TicTacToeToken.O.toString(), result);
        assertEquals(false, board.isEmptyField(2));
    }

    @Test (expected = NumberFormatException.class)
    public void test_processMove_NonIntInput() {
        //given
        when(mockMove.getInput()).thenReturn("abcd");
        when(mockMove.getToken()).thenReturn(TicTacToeToken.O);

        BoardGameMoveCommand moveCommand = new TicTacToeMoveCommand(mockMove, new TicTacToeBoard());

        MOVE_HANDLER.processMove(moveCommand);

    }

    @Test (expected = InvalidInputException.class)
    public void test_processMove_IntGreaterThanNine() {
        //given
        when(mockMove.getInput()).thenReturn("12");
        when(mockMove.getToken()).thenReturn(TicTacToeToken.O);

        BoardGameMoveCommand moveCommand = new TicTacToeMoveCommand(mockMove, new TicTacToeBoard());

        MOVE_HANDLER.processMove(moveCommand);
    }

}
