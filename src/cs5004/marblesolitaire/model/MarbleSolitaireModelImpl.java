package cs5004.marblesolitaire.model;

import cs5004.marblesolitaire.model.hw09.AbstractMarbleSolitaireModel;

/**
 * This class implements the Marble Solitaire model interface.
 */
public class MarbleSolitaireModelImpl extends AbstractMarbleSolitaireModel
        implements MarbleSolitaireModel {

  public MarbleSolitaireModelImpl() {
    super();
  }

  public MarbleSolitaireModelImpl(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);
  }

  public MarbleSolitaireModelImpl(int armThickness) throws IllegalArgumentException {
    super(armThickness);
  }

  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol)
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
        if (r < (boardLength - armThickness) / 2
                || r > (boardLength - armThickness) / 2 + armThickness - 1) {
          if (c < (boardLength - armThickness) / 2
                  || c > (boardLength - armThickness) / 2 + armThickness - 1) {
            boardArray[r][c] = BOARD_BORDER;
          } else {
            boardArray[r][c] = O;
            totalPeg++;
          }
        } else {
          boardArray[r][c] = O;
          totalPeg++;
        }
      }
    }
    return boardArray;
  }

}