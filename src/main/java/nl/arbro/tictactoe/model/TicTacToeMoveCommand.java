package nl.arbro.tictactoe.model;

/**
 * Created By: arbro
 * Date: 25-8-17 - 11:02
 * Project: tictactoe
 **/

public class TicTacToeMoveCommand implements BoardGameMoveCommand {

    private Board board;
    private BoardGameMove boardGameMove;

    public TicTacToeMoveCommand(BoardGameMove boardGameMove, Board board){
        this.board = board;
        this.boardGameMove = boardGameMove;
    }

    @Override
    public void execute() {
        int move = Integer.parseInt(boardGameMove.getInput()); //Throws IllegalArgumentException

        if (move <= 0 || move > 9) {
            throw new InvalidInputException("Your move is not in the range 1-9");
        }

        if (!board.isEmptyField(move)){
            throw new InvalidInputException("Please fill in a non-empty field");
        }

        board.fillBoard(move, boardGameMove.getToken());

    }
}
