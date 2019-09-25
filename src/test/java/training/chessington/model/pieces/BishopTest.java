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
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, bishop);
        
        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);
        
        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
        }
    
    @Test
    public void blackBishopsCanMoveOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, bishop);
        
        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);
        
        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(1, 1)));
        assertThat(moves).contains(new Move(coords, coords.plus(1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, -1)));
        assertThat(moves).contains(new Move(coords, coords.plus(-1, 1)));
    }

    @Test
    public void whiteBishopsCanMoveTwoSquares() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 2)));    }

    @Test
    public void blackBishopsCanMoveTwoSquare() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(2, 2)));
        assertThat(moves).contains(new Move(coords, coords.plus(2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, -2)));
        assertThat(moves).contains(new Move(coords, coords.plus(-2, 2)));    }
    
    @Test
    public void blackBishopsCanMoveToTheEndOFTheBoard() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.BLACK);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, bishop);
        
        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);
        
        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(3, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 3)));
    }
    
    @Test
    public void whiteBishopsCanMoveToTheEndOFTheBoard() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, bishop);
        
        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);
        
        // Assert
        assertThat(moves).contains(new Move(coords, coords.plus(3, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(3, 3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, -3)));
        assertThat(moves).contains(new Move(coords, coords.plus(-3, 3)));
    }
    
    @Test
    public void bishopCannotMovePastIfPieceIsInTheWay() {
        // Arrange
        Board board = Board.empty();
        
        Piece blackBishop = new Bishop(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(3, 4);
        board.placePiece(blackCoords, blackBishop);
        
        Piece whiteBishop = new Bishop(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(4, 5);
        board.placePiece(whiteCoords, whiteBishop);
        
        // Act
        List<Move> blackMoves = blackBishop.getAllowedMoves(blackCoords, board);
        List<Move> whiteMoves = whiteBishop.getAllowedMoves(whiteCoords, board);
        
        // Assert
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, blackCoords.plus(3,5)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, whiteCoords.plus(6,5)));
    }
    
    
    
    
}
