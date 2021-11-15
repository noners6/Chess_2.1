import java.util.ArrayList;
import java.util.Random;

/**
 * Game represents the game itself, and initializes a board and its pieces.
 */
public class Game {
  private int turnNumber;
  private final BoardPiece[][] board;
  public AbstractPiece whiteBishop;
  public AbstractPiece blackRook;
  public ArrayList<Turn> turn;

  /**
   * A constructor that initializes the board and the pieces in the right location
   */
  Game() {
    this.board = new BoardPiece[8][8];
    this.turnNumber = 0;
    this.turn = new ArrayList<>();
    initBoard();
    assignPieces();
  }

  /**
   * upTurn increments the turn by one at the end of the turn
   */
  private void upTurn() {this.turnNumber++;}


  /**
   * initBoard initializes the board pieces into a multidimensional array that represents their location.
   */
  private void initBoard() {
    for (int row = 0; row < 8; row++) {
      for (int column = 0; column < 8; column++) {
        if (row % 2 == 0) {
          if (column % 2 == 0) {
            this.board[row][column] = new BoardPiece(row, column, Color.WHITE);
          }
          else {
            this.board[row][column] = new BoardPiece(row, column, Color.BLACK);
          }
        }
        else {
          if (column % 2 == 0) {
            this.board[row][column] = new BoardPiece(row, column, Color.BLACK);
          }
          else {
            this.board[row][column] = new BoardPiece(row, column, Color.WHITE);
          }
        }
      }
    }
  }

  /**
   * assignPieces creates the appropriate pieces, and assigns them to their location on the board.
   */
  private void assignPieces() {
    this.whiteBishop = new Bishop(2,2, Color.WHITE);
    this.blackRook = new Rook(7,0, Color.BLACK);
    this.board[0][5].setPiece(whiteBishop);
    this.board[7][0].setPiece(blackRook);
  }

  /**
   * playTurn creates a Turn object, appends it to the list of turns, and calls on the move method
   * @return returns currentTurn, a Turn object
   */
  public Turn playTurn() {
    Turn thisTurn = new Turn(turnNumber);
    this.turn.add(thisTurn);
    move();
    return thisTurn;
  }

  /**
   * updateBoard sets the appropriate piece in its new location, removing the piece from its previous location.
   * @param rowFrom the origin row
   * @param columnFrom the origin column
   * @param rowTo the new row
   * @param columnTo the new column
   * @param piece the piece being moved
   */
  private void updateBoard(int rowFrom, int columnFrom, int rowTo, int columnTo,
                          AbstractPiece piece) {
    this.board[rowFrom][columnFrom].setPiece(null);
    this.board[rowTo][columnTo].setPiece(piece);
  }

  /**
   * move calls flipCoin and throwDice to determine how to move the Rook. Based on the results it will move the Rook to
   * its new location by calling on its public movePiece method. After moving it, it will update the string builder
   * that represents the action taken in that turn. Finally, it will update the board to reflect the changes.
   */
  private void move() {
    int flipCoin = flipCoin();
    int dieOne = throwDice();
    int dieTwo = throwDice();
    int move = dieOne + dieTwo;
    int currentRow = this.blackRook.getRow();
    int currentColumn = this.blackRook.getColumn();
    // if coin flip is 0, move rows
    if (flipCoin == 0) {
      int newRow = currentRow + move;
      this.blackRook.movePiece(currentRow + move, currentColumn);
      this.turn.get(this.turnNumber).updateStringBuilder(flipCoin, dieOne, dieTwo, currentRow, currentColumn, this.blackRook);
    }
    // if coin flip is 1, move columns
    else {
      int newColumn = currentColumn + move;
      this.blackRook.movePiece(currentRow, newColumn);
      this.turn.get(this.turnNumber).updateStringBuilder(flipCoin, dieOne, dieTwo, currentRow, currentColumn, this.blackRook);
    }
    updateBoard(currentRow, currentColumn, this.blackRook.getRow(), this.blackRook.getColumn(), blackRook);
    upTurn();
  }


  /**
   * throwDice throws one die
   * @return the value of the die
   */
  private int throwDice() {
    Random randOne = new Random();
    int bound = 6;
    return randOne.nextInt(bound) + 1;
  }

  /**
   * flipCoin flips a coin and returns 1 for head 2 for tail
   * @return 0 or 1
   */
  private int flipCoin() {
    Random rand = new Random();
    int bound = 2;
    return rand.nextInt(bound);
  }

  /**
   * toString override. It uses the StringBuilder to build a string with data from every board piece, and returns it as
   * a string.
   * @return the current status of the board in the game
   */
  @Override
  public String toString() {
    StringBuilder gameString = new StringBuilder();
    for (BoardPiece[] rows: this.board) {
      for (BoardPiece columns: rows) {
        gameString.append(columns.toString());
      }
    }
    gameString.append("Final positions of the board\n");
    return gameString.toString();
  }
}
