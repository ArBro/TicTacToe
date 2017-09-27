package nl.arbro.tictactoe;

import nl.arbro.tictactoe.model.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.mockito.verification.PrivateMethodVerification;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;

/**
 * Created By: arbro
 * Date: 22-9-17 - 13:43
 * Project: tictactoe
 **/

public class TicTacToeBoardTest {

    private static final BoardGameType BOARD_GAME_TYPE = BoardGameType.TICTACTOE;
    private static final int BOARD_LENGTH = 3;
    private static final int BOARD_HEIGHT = 3;
    private static final Token DEFAULT_TOKEN = TicTacToeToken.O;

    private static Board board;

    @Before
    public void initBoard() {
        board = BoardFactory.getBoard(BOARD_GAME_TYPE);
    }

    @Test
    public void boardIsNotNull(){
        assertNotEquals("Board is null", null, board);
    }

    @Test
    public void boardFactoryCreatesRightBoard() throws ClassNotFoundException {

        assertEquals(
                "Not the right type of board class created",
                Class.forName("nl.arbro.tictactoe.model.TicTacToeBoard"),
                board.getClass()
        );
    }

    @Test
    public void boardSizeIsThreeByThree() {

        String[][] outputBoard = board.getBoard();

        assertEquals("Board has not the right amount of rows", outputBoard.length, BOARD_HEIGHT);
        for (String[] row : outputBoard) {
            assertEquals("Board has not the amount of right columns", row.length, BOARD_LENGTH);
        }

    }

    @Test
    public void boardIsEmptyWhenCreated() {
        String[][] testBoard = board.getBoard();

        int countEmptyFields = 0;
        for (int row = 0; row < testBoard.length; row++){
            for (int col = 0; col < testBoard[row].length; col++){
                if (testBoard[row][col] == null || testBoard[row][col].isEmpty()){
                    countEmptyFields++;
                }
            }
        }

        assertEquals(BOARD_HEIGHT * BOARD_LENGTH, countEmptyFields);
    }

    @Test
    public void boardCanBeFilledCorrectly() {
        board.fillBoard(1, DEFAULT_TOKEN);
        board.fillBoard(5, DEFAULT_TOKEN);
        board.fillBoard(9, DEFAULT_TOKEN);

        String[][] expectedBoard = new String [3][3];
        for (String[] row : expectedBoard){
            for (int i = 0; i < row.length; i++) {
                row[i] = "";
            }
        }

        expectedBoard[0][0] = DEFAULT_TOKEN.toString();
        expectedBoard[1][1] = DEFAULT_TOKEN.toString();
        expectedBoard[2][2] = DEFAULT_TOKEN.toString();

        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test
    public void boardContainsEmptyStringsAfterReset() {
        board.resetBoard();

        String[][] expectedBoard = new String [3][3];
        for (String[] row : expectedBoard) {
            for (int i = 0; i < row.length; i++) {
                row[i] = "";
            }
        }

        assertArrayEquals(expectedBoard, board.getBoard());
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void boardCannotFillInputGreaterThanBoardSize() {
        board.fillBoard((BOARD_HEIGHT * BOARD_LENGTH) + 3, DEFAULT_TOKEN);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void boardCannotFillNegativeInput() {
        board.fillBoard(-1, DEFAULT_TOKEN);
    }

    @Test
    public void isEmptyFieldReturnsFalseWhenFieldIsFilled(){
        final int moveInput = 1;
        board.fillBoard(moveInput, DEFAULT_TOKEN);
        assertFalse(board.isEmptyField(moveInput));
    }

    @Test
    public void isEmptyFieldReturnsTrueWhenFieldIsNotFilled(){
        final int moveInput = 1;
        assertTrue(board.isEmptyField(moveInput));
    }

    @Test
    public void hasEmptyFieldsReturnsTrueWhenBoardIsEmpty(){
        board.resetBoard();
        assertTrue(board.hasEmptyFields());
    }

}
