package cs5004.marblesolitaire.model.hw09;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

/**
 * This class implements the Marble Solitaire model interface, creates a Triangular board.
 */
public class TriangleSolitaireModelImpl extends AbstractMarbleSolitaireModel
        implements MarbleSolitaireModel {

  /**
   * 1st constructor: Take no parameters. Initialize the game board with arm thickness 5 & empty
   * slot at [0][0].
   */
  public TriangleSolitaireModelImpl() {
    armThickness = 5;
    boardArray = createBoard(armThickness);
    boardArray[0][0] = EMPTY;
    totalPeg -= 1;
  }

  /**
   * 2nd constructor: takes 2 parameters: sRow and sCol. Initialize the game board with arm
   * thickness 5 & empty slot is at the position (sRow, sCol). Throw an IllegalArgumentException:
   * "Invalid empty cell position (r,c)".
   */
  public TriangleSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
    armThickness = 5;
    boardArray = createBoard(armThickness);
    boardArray[sRow][sCol] = EMPTY;
    totalPeg -= 1;
  }

  /**
   * 3rd constructor: parameter takes in the arm thickness integer. Initialize a game board with the
   * empty slot at [0][0]. Throw an IllegalArgumentException if the arm thickness is not a positive
   * number and less than 3.
   */
  public TriangleSolitaireModelImpl(int armThickness) throws IllegalArgumentException {
    super(armThickness);
    if (armThickness < 3) {
      throw new IllegalArgumentException("must be equal or larger than 3");
    }
    boardArray = createBoard(armThickness);
    this.armThickness = armThickness;
    boardArray[0][0] = EMPTY;
    totalPeg -= 1;
  }

  /**
   * 4th constructor: take the arm thickness, row and column of the empty slot in that order. Throw
   * IllegalArgumentException if arm thickness not positive odd num/invalid empty cell.
   */
  public TriangleSolitaireModelImpl(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
  }


  /**
   * Initialize a board taking in armThickness.
   */
  public String[][] createBoard(int armThickness) {
    boardArray = new String[armThickness][armThickness];
    for (int r = 0; r < armThickness; r++) {
      for (int c = 0; c <= r; c++) {
        boardArray[r][c] = O;
        totalPeg++;

      }
    }

    for (int r = 0; r < armThickness; r++) {
      for (int c = 0; c < armThickness; c++) {
        if (boardArray[r][c] == null) {
          boardArray[r][c] = BOARD_BORDER;
        }
      }
    }
    return boardArray;
  }


  /**
   * Helper method take in arm thickness to calculate the actual board length.
   */
  @Override
  protected int getBoardLength(int armThickness) {
    return armThickness;
  }


  /**
   * Return a string that represents the current state of the board.
   */
  public String getGameState() {
    StringBuilder sb = new StringBuilder();
    String rowStr = "";
    for (int r = 1; r <= boardArray.length; r++) {
      for (int c = r; c <= boardArray.length; c++) {
        sb.append(rowStr);
      }

      for (int c = 1; c <= r; c++) {
        sb.append(rowStr);
      }
      sb.append(System.lineSeparator());
    }
    return sb.toString();
  }
}