package nl.arbro.tictactoe.model;

/**
 * Created By: arbro
 * Date: 13-4-18 - 14:23
 * Project: tictactoe
 **/

public class ConnectFourMoveCommand implements BoardGameMoveCommand {

    private Board board;
    private BoardGameMove boardGameMove;

    public ConnectFourMoveCommand(BoardGameMove boardGameMove, Board board) {
        this.boardGameMove = boardGameMove;
        this.board = board;
    }

    @Override
    public void execute() {
        int move = Integer.parseInt(boardGameMove.getInput()); //Throws IllegalArgumentException

        if (!board.isEmptyField(move)){
            throw new InvalidInputException("Please select a non-empty column");
        }

        board.fillBoard(move, boardGameMove.getToken());
    }
}
