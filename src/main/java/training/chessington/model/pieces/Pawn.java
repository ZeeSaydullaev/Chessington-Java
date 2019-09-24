package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> moves = new ArrayList<>();

        if (isStartingPawnRow(from)) {
            Move initMove = getColour() == PlayerColour.BLACK ?
                    new Move(from, from.plus(2, 0)) :
                    new Move(from, from.plus(-2, 0));
            moves.add(initMove);
        }

        Move moveForward = getColour() == PlayerColour.WHITE ?
                new Move(from, from.plus(-1, 0)) :
                new Move(from, from.plus(1, 0));
        moves.add(moveForward);

        return moves;
    }

    private boolean isStartingPawnRow(Coordinates start) {
        if (start.getRow() == 1 && getColour() == PlayerColour.BLACK || start.getRow() == 6 && getColour() == PlayerColour.WHITE) {
            return true;
        } else {
            return false;
        }
    }
}
