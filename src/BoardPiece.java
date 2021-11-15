public class BoardPiece {
  private int row;
  private int column;
  private Color color;
  private AbstractPiece piece;

  public BoardPiece(int row, int column, Color color) {
    this.color = color;
    this.row = row;
    this.column = column;
    this.piece = null;
  }

  public void setPiece(AbstractPiece inputPiece) {
    this.piece = inputPiece;
  }

  public AbstractPiece getPiece() {
    return this.piece;
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
  @Override
  public String toString() {
    if(this.piece == null) {
      return "Row: " + this.row + " Column: " + this.column + " is empty\n";
    }
    return "Row: " + this.row + " Column: " + this.column + " has " + this.piece.toString() + "\n";
  }
}