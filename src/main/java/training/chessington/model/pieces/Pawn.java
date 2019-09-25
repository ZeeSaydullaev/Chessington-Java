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

        int direction = getDirection();
        Coordinates moveOneSquare = from.plus(direction, 0);

        
        if(isValidMove(moveOneSquare) && board.get(moveOneSquare) == null) {
            Move moveForward = new Move(from, moveOneSquare);
            moves.add(moveForward);

            if (isStartingPawnRow(from) && board.get(from.plus(2 * direction,0)) == null) {
                Move initMove = new Move(from, from.plus(2 * direction, 0));
                moves.add(initMove);
            }
            captureDiagonally(from, board, moves);
        }
        
        return moves;
    }

    private boolean isStartingPawnRow(Coordinates start) {
        return (start.getRow() == 1 && getColour() == PlayerColour.BLACK || start.getRow() == 6 && getColour() == PlayerColour.WHITE);
    }

    private boolean isValidMove(Coordinates to) {
        return  (to.getRow() >= 0 && to.getRow() <= 7) && (to.getCol() >= 0 && to.getCol() <= 7) ;
    }
    
    private void captureDiagonally(Coordinates from, Board board, List<Move> moves)  {

        if(isValidMove(from)) {
            Coordinates DiagonallyRight = from.plus(getDirection(),1);
            Coordinates DiagonallyLeft = from.plus(getDirection(),-1);

            if (board.get(DiagonallyRight) != null && getColour() != board.get(DiagonallyRight).getColour()) {
                Move moveDiagonallyRight = new Move(from, DiagonallyRight);
                moves.add(moveDiagonallyRight);
            } else if(board.get(DiagonallyLeft) != null && getColour() != board.get(DiagonallyRight).getColour()) {
                Move moveDiagonallyLeft = new Move(from, DiagonallyLeft);
                moves.add(moveDiagonallyLeft);
            }
        }
    }

    private int getDirection(){
        return getColour() == PlayerColour.WHITE ? -1 : 1;
    }
}