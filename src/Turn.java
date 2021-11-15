import java.util.Random;

public class Turn {
  private final StringBuilder turn;
  private final int turnNumber;

  /**
   * The constructor for Turn. Takes the associated turn number as a parameter, and initializes an empty string builder
   * @param turnNumber current turn number
   */
  Turn(int turnNumber) {
    this.turnNumber = turnNumber;
    this.turn = new StringBuilder();
  }

  /**
   * updateStringBuilder is a void method that adds to the current turn's stringBuilder all the
   * actions that happened this turn: the coin flip's outcome, the outcome of each die rolled,
   * where did the rook move from, and where did the rook move to.
   * @param coin flip value
   * @param dieOne roll value
   * @param dieTwo roll value
   * @param previousRow where the piece started
   * @param previousColumn where the piece started
   */
  void updateStringBuilder(int coin, int dieOne, int dieTwo, int previousRow,
                           int previousColumn, AbstractPiece piece) {

    // Adding current turn to the StringBuilder
    this.turn.append("In turn number ");
    this.turn.append(this.turnNumber + 1);
    this.turn.append(":\n");

    // Checking for head or tail, and appending result
    if (coin == 0) {
      this.turn.append("The coin flip resulted in a head.\n");
    }
    else {
      this.turn.append("The  coin flip resulted in a tail.\n");
    }

    // Appending the results of the dice rolls
    this.turn.append("The first die rolled was: ");
    this.turn.append(dieOne);
    this.turn.append("\n");
    this.turn.append("And the second die rolled was: ");
    this.turn.append(dieTwo);
    this.turn.append("\n");

    // Appending the movement the rook (or any piece) took
    this.turn.append("The ").append(piece.toString()).append(" was moved from:\n");
    this.turn.append("Row ").append(previousRow).append(", Column: ").append(previousColumn).append("\n");
    this.turn.append("To:\n" + "Row: ").append(piece.getRow()).append(", Column:").append(piece.getColumn());
    this.turn.append("\nEnd of turn.\n");
  }

  public String toString() {
    return turn.toString();
  }

}
