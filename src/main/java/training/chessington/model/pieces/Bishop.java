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

        for(int i = 1 ; i <= 7; i++){
            diagonals.add(from.plus(i, i));
            diagonals.add(from.plus(-i, i));
            diagonals.add(from.plus(i, -i));
            diagonals.add(from.plus(-i, -i));
        }

        for(Coordinates coords : diagonals){
            if(isValidMove(coords)) {
                moves.add(new Move(from, coords));
            }
        }

        return moves;

    }

    private boolean isValidMove(Coordinates to) {
        return  (to.getRow() >= 0 && to.getRow() <= 7) && (to.getCol() >= 0 && to.getCol() <= 7) ;
    }

}
