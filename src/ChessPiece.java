/**
 * a public interface for ChessPiece.
 */
public interface ChessPiece {
  /**
   * getRow method returns integer.
   * @return integer
   */
  int getRow();

  /**
   * getColumn method returns integer.
   * @return integer
   */
  int getColumn();

  /**
   * getColor method returns color.
   * @return enum
   */
  Color getColor();

  /**
   * canMove method returns a boolean expression.
   * @param row integer
   * @param column integer
   * @return boolean
   */
  boolean canMove(int row, int column);

  /**
   * canKill method returns a boolean expression.
   * @param piece ChessPiece object
   * @return boolean
   */
  boolean canKill(ChessPiece piece);

  /**
   * movePiece method changes the location of the piece
   * @param row to be moved to
   * @param column to be moved to
   */
  void movePiece(int row, int column);

  /**
   * returns a string with the type of the piece
   * @return string
   */
  String toString();
}