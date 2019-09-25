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
 
        List<Coordinates> diagonals = new ArrayList<>();
        diagonals.add(from.plus(1, -1));
        diagonals.add(from.plus(1,1));
        diagonals.add(from.plus(-1,-1));
        diagonals.add(from.plus(-1,1));
        
        for(Coordinates coords : diagonals){
            moves.add(new Move(from, coords));
        }
        
        return moves;
        
        
        
        
    }

}
