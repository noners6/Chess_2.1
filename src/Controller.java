public class Controller {
  private Game game;
  public StringBuilder gameData;

  /**
   * Controller controls the game. It creates a game object, and then calls playGame to control the game execution.
   */
  Controller() {
    this.game = new Game();
    this.gameData = new StringBuilder();
    playGame();
  }

  /**
   * playGame controls the execution of the game, determines who won, and prints the status of the game each turn.
   */
  public void playGame() {
    for (int i = 0; i < 15; i++) {
      String currentTurn = this.game.playTurn().toString();
      System.out.println(currentTurn);
      gameData.append(currentTurn);

      // If at the end of the turn the black rook is on the same tile as the white bishop, it means it has captures it
      // And the game ends with the Rook's capture of the bishop
      if (this.game.blackRook.getRow() == this.game.whiteBishop.getRow()) {
        if ((this.game.blackRook.getColumn() == this.game.whiteBishop.getColumn())) {
          System.out.println("Black Rook won!\n");
          //System.out.println(this.game.toString());
          return;
        }
      }
      // If by the end of a rook's turn the bishop can move to capture it, the rook has lost

      if (this.game.whiteBishop.canMove(this.game.blackRook.getRow(),
              this.game.blackRook.getColumn())) {
        System.out.println("White bishop can capture rook from:\n" + this.game.whiteBishop.getRow() + " row " +
                this.game.whiteBishop.getColumn() + " column\n" + "to:\n" + this.game.blackRook.getRow() + " row " +
                this.game.blackRook.getColumn() + " column.\n");
        System.out.println("White Bishop won!\n");
        return;
      }
    }
    System.out.println("Black Rook survived!");
    System.out.println(this.game.toString());

  }
  public static void main(String[] args) {
    new Controller();
  }
}