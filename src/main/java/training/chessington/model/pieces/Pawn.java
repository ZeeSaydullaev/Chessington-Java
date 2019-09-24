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

        Move moveForward = getColour() == PlayerColour.WHITE ?
                new Move(from, from.plus(-1,0)) :
                new Move(from, from.plus(1,0));

        moves.add(moveForward);

        return moves;
    }
}
