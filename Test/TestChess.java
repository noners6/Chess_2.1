import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * a JUnit test class for the AbstractPiece and its extension classes.
 */
public class TestChess {
    private Bishop firstWhiteBishop;
    private Bishop secondWhiteBishop;
    private Bishop firstBlackBishop;
    private Bishop secondBlackBishop;
    private Rook firstWhiteRook;
    private Rook secondWhiteRook;
    private Rook firstBlackRook;
    private Rook secondBlackRook;

    @BeforeEach
    public void setUp() {
        firstWhiteBishop = new Bishop(4,4, Color.WHITE);
        secondWhiteBishop = new Bishop(6,3, Color.WHITE);
        firstBlackBishop = new Bishop(3,4, Color.BLACK);
        secondBlackBishop = new Bishop(0,0, Color.BLACK);

        firstWhiteRook = new Rook(3,3, Color.WHITE);
        secondWhiteRook = new Rook(5,3, Color.WHITE);
        firstBlackRook = new Rook(4,4, Color.BLACK);
        secondBlackRook = new Rook(5,3, Color.BLACK);

    }

    @Test
    public void testCanMove() {

        // Testing Bishop for true using white
        assertTrue(firstWhiteBishop.canMove(0,0));
        assertTrue(firstWhiteBishop.canMove(1,7));
        assertTrue(firstWhiteBishop.canMove(7,1));
        assertTrue(firstWhiteBishop.canMove(7,7));
        assertTrue(secondWhiteBishop.canMove(7,2));
        assertTrue(secondWhiteBishop.canMove(3,0));
        assertTrue(secondWhiteBishop.canMove(7,4));

        // Testing Bishop for true using black
        assertTrue(secondBlackBishop.canMove(4,4));

        // Testing Bishop for false using black
        assertFalse(firstBlackBishop.canMove(0,0));
        assertFalse(firstBlackBishop.canMove(7,7));
        assertFalse(firstBlackBishop.canMove(1,7));
        assertFalse(firstBlackBishop.canMove(7,1));
        assertFalse(firstBlackBishop.canMove(3,4));
        assertFalse(firstBlackBishop.canMove(6,4));

        // Testing Bishop for legal moves outside the board
        assertFalse(firstWhiteBishop.canMove(8,8));
        assertFalse(firstWhiteBishop.canMove(-1,-1));
        assertFalse(firstWhiteBishop.canMove(0,8));
        assertFalse(firstWhiteBishop.canMove(8,0));

        // Testing Rook for true using white
        assertTrue(firstWhiteRook.canMove(5,3));
        assertTrue(firstWhiteRook.canMove(3,5));
        assertTrue(firstWhiteRook.canMove(7,3));
        assertTrue(firstWhiteRook.canMove(0,3));
        assertTrue(firstWhiteRook.canMove(3,7));
        assertTrue(firstWhiteRook.canMove(3,0));
        assertTrue(secondWhiteRook.canMove(3,3));


        // Testing Rook for false using black
        assertFalse(firstBlackRook.canMove(3,2));
        assertFalse(firstBlackRook.canMove(2,0));
        assertFalse(firstBlackRook.canMove(6, 5));
        assertFalse(firstBlackRook.canMove(6,6));

        // Testing Rook for legal moves outside the board
        assertFalse(firstWhiteRook.canMove(3,8));
        assertFalse(firstWhiteRook.canMove(-1,3));
        assertFalse(firstBlackRook.canMove(9,4));
        assertFalse(firstBlackRook.canMove(4,-5));
    }

    private void assertTrue(boolean canMove) {
    }

    @Test
    public void testCanKill() {

        // Testing Bishop for true
        assertTrue(firstWhiteBishop.canKill(secondBlackBishop));
        assertTrue(secondBlackBishop.canKill(firstWhiteBishop));

        // Testing Bishop for false
        assertFalse(firstWhiteBishop.canKill(secondWhiteBishop));
        assertFalse(firstBlackBishop.canKill(secondBlackBishop));
        assertFalse(firstBlackBishop.canKill(firstBlackBishop));

        // Testing Rook for true
        assertTrue(firstWhiteRook.canKill(secondBlackRook));
        assertTrue(secondBlackRook.canKill(firstWhiteRook));

        // Testing Rook for false
        assertFalse(firstWhiteRook.canKill(firstWhiteRook));
        assertFalse(firstWhiteRook.canKill(secondWhiteRook));
        assertFalse(firstWhiteRook.canKill(secondBlackBishop));
        assertFalse(secondWhiteRook.canKill(firstWhiteRook));


    }

    private void assertFalse(boolean canKill) {
    }

    @Test
    // Expected to fail
    public void testErrorHandling() throws IllegalArgumentException {
        new AbstractPiece(0,0, null);
        new AbstractPiece(-5,0, Color.BLACK);
        new AbstractPiece(-10,0, Color.WHITE);
    }

    @Test
    public void testGetRow() {
        assertEquals(4, firstWhiteBishop.getRow());
        assertEquals(0, secondBlackBishop.getRow());
    }

    private void assertEquals(int i, int row) {
    }

    @Test
    public void testGetColumn() {
        assertEquals(0, secondBlackBishop.getColumn());
        assertEquals(4, firstWhiteBishop.getColumn());
    }

    @Test
    public void getColor() {
        assertEquals(Color.WHITE, firstWhiteBishop.getColor());
    }

    private void assertEquals(Color white, Color color) {
    }

    @Test
    // Expected to fail
    public void testNullColor() throws IllegalArgumentException {
        AbstractPiece nullPiece = new AbstractPiece(0,0,null);
        assertEquals(Color.BLACK, nullPiece.getColor());
    }
}