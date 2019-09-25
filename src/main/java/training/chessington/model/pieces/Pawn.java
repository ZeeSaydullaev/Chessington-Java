package training.chessington.model.pieces;

import com.sun.corba.se.spi.transport.CorbaAcceptor;
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

        int direction = getColour() == PlayerColour.WHITE ? -1 : 1;
        Coordinates moveOneSquare = from.plus(direction, 0);
        
        if(isValidMove(moveOneSquare) && board.get(moveOneSquare) == null) {
            canCapture(from,board,moves);
            Move moveForward = new Move(from, moveOneSquare);
            moves.add(moveForward);

            if (isStartingPawnRow(from) && board.get(from.plus(2 * direction,0)) == null) {
                Move initMove = new Move(from, from.plus(2 * direction, 0));
                moves.add(initMove);
            }
        }
        
        return moves;
    }

    private boolean isStartingPawnRow(Coordinates start) {
        return (start.getRow() == 1 && getColour() == PlayerColour.BLACK || start.getRow() == 6 && getColour() == PlayerColour.WHITE);
    }
    
    
    private boolean isValidMove(Coordinates to) {
        return  (to.getRow() >= 0 && to.getRow() <= 7) && (to.getCol() >= 0 && to.getCol() <= 7) ;
    }
    
    private void canCapture(Coordinates to, Board spot, List<Move> moves)  {
        Coordinates moveDiagonallyRight = to.plus(1,1);
        Coordinates moveDiagonallyLeft = to.plus(1,-1);

        if (spot.get(moveDiagonallyRight) != null) {
            Move moveDR = new Move(to, moveDiagonallyRight);
            moves.add(moveDR);
        } else if(spot.get(moveDiagonallyLeft) != null) {
            Move moveDL = new Move(to, moveDiagonallyLeft);
            moves.add(moveDL);
        }
    }

}