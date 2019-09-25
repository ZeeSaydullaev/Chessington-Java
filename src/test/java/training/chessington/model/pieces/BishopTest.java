package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BishopTest {
    @Test
    public void whiteBishopsCanMoveOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, bishop);
        
        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);
        
        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
    }
    
    @Test
    public void blackBishopsCanMoveOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(6, 4);
        board.placePiece(coords, bishop);
        
        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);
        
        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 0)));
    }
}
