/**
 * AbstractPiece is an abstract class that represents chess pieces. It will work with Bishop,
 * Rook, Knight, Queen, and Pawn.
 */
public class AbstractPiece implements ChessPiece {
  private int row;
  private int column;
  private final Color color;

  /**
   * AbstractPiece constructor will construct any chess piece classes: Bishop, Rook, Knight,
   * Queen, Pawn. It assigns color, row, and column. It calls at the end a validChecks to
   * validate input. Will throw an error if any of the input is bad.
   *
   * @param color enum, BLACK or WHITE, the color of the piece
   * @param row integer, between 0 and 7
   * @param column integer, between 0 and 7
   */
  public AbstractPiece(int row, int column, Color color) {
    this.color = color;
    this.row = row;
    this.column = column;
    validChecks();
  }

  /**
   * getRow method returns the row of an object.
   *
   * @return row, an integer
   */
  @Override
  public int getRow() {
    return this.row;
  }

  /**
   * getColumn method returns the column of an object.
   *
   * @return column, an integer
   */
  @Override
  public int getColumn() {
    return this.column;
  }

  /**
   * getColor returns the color of an object.
   *
   * @return color, enum
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * canMove is a placeholder for the method that will be written in each class individually.
   * This method will determine if an object can move to a square, represented by its row and
   * column.
   *
   * @param row integer
   * @param column integer
   * @return boolean
   */
  @Override
  public boolean canMove(int row, int column) {
    return false;
  }

  /**
   * canKill determines if one piece can kill another. It checks if the other piece is of
   * opposing colors, and if it is, it checks if the current piece can go there. If that is true,
   * then it returns true. Else, it will return false.
   * This method will be overwritten only on Pawn.
   *
   * @param piece an instanced object
   * @return boolean
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    int pieceRow = piece.getRow();
    int pieceColumn = piece.getColumn();
    if (!this.canMove(pieceRow, pieceColumn)) {
      return false;
    }
    return this.sameColor(piece);
  }

  @Override
  public void movePiece(int row, int column) {
    //this.color = color;
    while (row > 7) {
     row = row - 8;
    }
    while (column > 7) {
      column = column - 8;
    }
    this.row = row;
    this.column = column;
    //validChecks();
  }

  /**
   * toString is a placeholder to be implemented in the specific pieces
   * @return null string
   */
  @Override
  public String toString() {
    return null;
  }

  /**
   * outsideBoard method is a helper method that determines if row and column are legal input. If
   * they are between (including) 0-7, it's legal. Else, it's an illegal move.
   *
   * @param row integer
   * @param column integer
   * @return boolean. True if illegal, false if legal
   */
  protected boolean outsideBoard(int row, int column) {
    return row < 0 || row > 7 || column < 0 || column > 7;
  }

  /**
   * validChecks method is a helper method that determines if all input is valid. It calls
   * outsideBoard to validate row and column, in addition to looking for null color. If any of
   * the input is invalid, it throws an error.
   *
   * @throws IllegalArgumentException if any of the input is invalid
   */
  private void validChecks() throws IllegalArgumentException {
    if (this.color == null || outsideBoard(this.row, this.column)) {
      throw new IllegalArgumentException("invalid values");
    }
  }

  /**
   * sameColor is a helper method that checks if two pieces are of the same color.
   *
   * @param piece an instanced object of ChessPiece
   * @return boolean
   */
  protected boolean sameColor(ChessPiece piece) {
    return this.getColor() != piece.getColor();
  }

  /**
   * sameTile method is a helper method that checks if two tiles are the same.
   *
   * @param myRow integer
   * @param myColumn integer
   * @param targetRow integer
   * @param targetColumn integer
   * @return boolean. True if it is the same tile, false otherwise.
   */
  protected boolean sameTile(int myRow, int myColumn, int
          targetRow, int targetColumn) {
    return ((myRow == targetRow) && (myColumn == targetColumn));
  }
}