package u5pp;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChessPieceTests {
    private class ChessPieceChild extends ChessPiece {
        public ChessPieceChild(ChessPiece[][] board, int row, int col, boolean isWhite) {
            super(board, row, col, isWhite);
        }
        @Override
        public String toString() {
            return NAME;
        }
    }

    private final String NAME = "TEST";
    private final boolean IS_WHITE = true;

    private ChessPieceChild testPiece;
    private ChessPiece[][] board;

    @BeforeEach
    public void beforeEach() {

        board = new ChessPiece[8][8];
        testPiece = new ChessPieceChild(board, 1, 1, IS_WHITE);
    }

    @Test 
    public void ChessPiece_canMoveTo_Exists() {
        assertDoesNotThrow(() -> ChessPiece.class.getMethod("canMoveTo", int.class, int.class),
            "ChessPiece should have a method canMoveTo(int, int)");
    }

    @Test
    public void ChessPiece_moveTo_Exists() {
        assertDoesNotThrow(() -> ChessPiece.class.getMethod("moveTo", int.class, int.class),
            "ChessPiece should have a method doMove(int, int)");
    }

    @Test
    public void ChessPiece_constructorAndGetIsWhite_Works() {
        testPiece = new ChessPieceChild(board, 1, 1, IS_WHITE);
        assertEquals(IS_WHITE, testPiece.getIsWhite(), 
            "ChessPiece.isWhite() is returning false when constructed with true");

        testPiece = new ChessPieceChild(board, 1, 1, !IS_WHITE);
        assertEquals(!IS_WHITE, testPiece.getIsWhite(),
            "ChessPiece.isWhite() is returning true when constructed with false");
    }

    @Test
    public void ChessPiece_toString_Exists() {
        assertDoesNotThrow(() -> ChessPiece.class.getMethod("toString"),
            "ChessPiece should have a method toString()");
    }
}
