package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        List<Move> moves = new ArrayList<>();

        Coordinates moveOneSquareDL = from.plus(1, -1);
        Coordinates moveOneSquareDR = from.plus(1, 1);
        Coordinates moveOneSquareUL = from.plus(-1, -1);
        Coordinates moveOneSquareUR = from.plus(-1, 1);

        Move moveForwardL = new Move(from, moveOneSquareDL);
        Move moveForwardR = new Move(from, moveOneSquareDR);
        Move moveBackwardsL = new Move(from, moveOneSquareUL);
        Move moveBackwardsR = new Move(from, moveOneSquareUR);


        moves.add(moveForwardL);
        moves.add(moveForwardR);
        moves.add(moveBackwardsL);
        moves.add(moveBackwardsR);


        return moves;
    }

}
