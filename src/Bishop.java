/**
 * A class to represent a Bishop. Attributes are:
 * color, row and column. Row and column represent the piece's location on the board.
 * A bishop can move diagonally in any direction, and kills the same way.
 */
public class Bishop extends AbstractPiece {


  /**
   * AbstractPiece constructor will construct any chess piece classes: Bishop, Rook, Knight, Queen,
   * Pawn. It assigns color, row, and column. It calls at the end a validChecks to validate input.
   * Will throw an error if any of the input is bad.
   *
   * @param row    integer, between 0 and 7
   * @param column integer, between 0 and 7
   * @param color  enum, BLACK or WHITE, the color of the piece
   */
  public Bishop(int row, int column, Color color) {
    super(row, column, color);
  }

  /**
   * canMove overrides the abstract method. It takes an row and column, and determines if a
   * Bishop can move there. A bishop can move diagonally.
   *
   * @param row integer
   * @param column integer
   * @return boolean. True if it can move, false otherwise.
   */
  @Override
  public boolean canMove(int row, int column) {
    // checking if the input is valid, or if it's the same tile on the board. If either are true.
    // returns false.
    if (this.outsideBoard(row, column) || sameTile(this.getRow(), this.getColumn(), row, column)) {
      return false;
    }
    else {
      // checking if the absolute value of the difference between the old and new row and column
      // stays constant. If it does, return true.
      return Math.abs(this.getRow() - row) == Math.abs(this.getColumn() - column);
    }
  }

  @Override
  public String toString() {
    if (this.getColor() == Color.WHITE) {
      return "white bishop";
    }
    else {
      return "black bishop";
    }
  }
}