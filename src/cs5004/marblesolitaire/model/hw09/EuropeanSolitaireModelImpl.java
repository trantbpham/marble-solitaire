package cs5004.marblesolitaire.model.hw09;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

/**
 * This class implements the Marble Solitaire model interface, creates an octagonal board.
 */
public class EuropeanSolitaireModelImpl extends AbstractMarbleSolitaireModel
        implements MarbleSolitaireModel {

  /**
   * 1st constructor: Take no parameters. Initialize the game board with arm thickness 3 & empty
   * slot at the center.
   */
  public EuropeanSolitaireModelImpl() {
    super();
  }

  /**
   * 2nd constructor: takes 2 parameters: sRow and sCol. Initialize the game board with arm
   * thickness 3 & empty slot is at the position (sRow, sCol). Throw an IllegalArgumentException:
   * "Invalid empty cell position (r,c)".
   */
  public EuropeanSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);
  }

  /**
   * 3rd constructor: parameter takes in the arm thickness integer. Initialize a game board with the
   * empty slot at the center. Throw an IllegalArgumentException if the arm thickness is not a
   * positive odd number.
   */
  public EuropeanSolitaireModelImpl(int armThickness) throws IllegalArgumentException {
    super(armThickness);
  }

  /**
   * 4th constructor: take the arm thickness, row and column of the empty slot in that order. Throw
   * IllegalArgumentException if arm thickness not positive odd num/invalid empty cell.
   */
  public EuropeanSolitaireModelImpl(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
  }

  /**
   * Initialize a board taking in armThickness.
   */
  public String[][] createBoard(int armThickness) throws IllegalArgumentException {
    int boardLength = getBoardLength(armThickness);
    boardArray = new String[boardLength][boardLength];

    for (int r = 0; r < boardLength; r++) {
      for (int c = 0; c < boardLength; c++) {
        if (c + r + 1 >= armThickness && c - r - 1 <= armThickness && r < armThickness) {
          boardArray[r][c] = O;
          totalPeg++;
        } else if (r > armThickness - 1 && r < armThickness + armThickness - 2) {
          boardArray[r][c] = O;
          totalPeg++;
        } else if (c + (boardLength - r) + 1 > armThickness && c - (boardLength - r) - 1 <
                armThickness && r > armThickness) {
          boardArray[r][c] = O;
          totalPeg++;
        } else {
          boardArray[r][c] = BOARD_BORDER;
        }
      }
    }
    return boardArray;
  }

}



