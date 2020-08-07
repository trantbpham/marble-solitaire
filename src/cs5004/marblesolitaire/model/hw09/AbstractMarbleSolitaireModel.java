package cs5004.marblesolitaire.model.hw09;

/**
 * Abstract Solitaire model that extends to European, Triangle, and Marble model.
 */
public class AbstractMarbleSolitaireModel {
  public static final String EMPTY = "_";
  public static final String BOARD_BORDER = " ";
  public static final String O = "O";

  protected int armThickness;
  protected String[][] boardArray;
  protected int totalPeg = 0;

  /**
   * 1st constructor: Take no parameters. Initialize the game board with arm thickness 3 & empty
   * slot at the center.
   */
  public AbstractMarbleSolitaireModel() {
    boardArray = createBoard(3);
    int emptySlotPos = getBoardLength(3) / 2;
    boardArray[emptySlotPos][emptySlotPos] = EMPTY;
    totalPeg -= 1;
  }

  /**
   * 2nd constructor: takes 2 parameters: sRow and sCol. Initialize the game board with arm
   * thickness 3 & empty slot is at the position (sRow, sCol). Throw an IllegalArgumentException:
   * "Invalid empty cell position (r,c)".
   */
  public AbstractMarbleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    boardArray = createBoard(3);

    if (sRow < 0 || sCol < 0 || sRow >= boardArray.length || sCol >= boardArray.length) {
      throw new IllegalArgumentException("Can not be negative");
    }

    if (boardArray[sRow][sCol].equals(BOARD_BORDER)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }

    boardArray[sRow][sCol] = EMPTY;
    totalPeg -= 1;
  }

  /**
   * 3rd constructor: parameter takes in the arm thickness integer. Initialize a game board with the
   * empty slot at the center. Throw an IllegalArgumentException if the arm thickness is not a
   * positive odd number.
   */
  public AbstractMarbleSolitaireModel(int armThickness) throws IllegalArgumentException {
    if (armThickness < 0) {
      throw new IllegalArgumentException("must be larger than 0");
    }

    int emptySlotPos = getBoardLength(armThickness) / 2;

    boardArray = createBoard(armThickness);
    boardArray[emptySlotPos][emptySlotPos] = EMPTY;
    totalPeg -= 1;
  }

  /**
   * 4th constructor: take the arm thickness, row and column of the empty slot in that order. Throw
   * IllegalArgumentException if arm thickness not positive odd num/invalid empty cell.
   */
  public AbstractMarbleSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {

    boardArray = createBoard(armThickness);
    if (sRow < 0 || sCol < 0 || sRow > boardArray.length || sCol > boardArray.length) {
      throw new IllegalArgumentException("Can not be negative");
    }
    if (boardArray[sRow][sCol].equals(BOARD_BORDER)) {
      throw new IllegalArgumentException("Invalid empty cell position (" + sRow + "," + sCol + ")");
    }
    boardArray[sRow][sCol] = EMPTY;
    totalPeg -= 1;
  }

  /**
   * Move a single marble from a given position to another given position. A move is valid only if
   * the from and to positions are valid. Specific implementations may place additional constraints
   * on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if the move is not possible
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (fromRow < 0 || fromCol < 0 || toRow < 0 || toCol < 0) {
      throw new IllegalArgumentException("Can not be negative");
    }

    if (fromRow >= boardArray.length
            || fromCol >= boardArray.length || toCol >= boardArray.length
            || toRow >= boardArray.length) {
      throw new IllegalArgumentException("Can not be larger than board length");
    }
    if (boardArray[fromRow][fromCol].equals(O) && toRow == (fromRow + 2) && toCol == fromCol
            && boardArray[toRow][toCol].equals(EMPTY)) {  //move vertical downward
      boardArray[fromRow][fromCol] = EMPTY;
      boardArray[fromRow + 1][fromCol] = EMPTY;
      boardArray[toRow][toCol] = O;
      totalPeg -= 1;
    } else if (boardArray[fromRow][fromCol].equals(O) && toRow == (fromRow - 2)
            && toCol == fromCol && boardArray[toRow][toCol].equals(EMPTY)) { //move vertical upward
      boardArray[fromRow][fromCol] = EMPTY;
      boardArray[fromRow - 1][fromCol] = EMPTY;
      boardArray[toRow][toCol] = O;
      totalPeg -= 1;
    } else if (boardArray[fromRow][fromCol].equals(O) && toRow == fromRow
            && toCol == (fromCol - 2) && boardArray[toRow][toCol].equals(EMPTY)) {
      //move horizontal right to left
      boardArray[fromRow][fromCol] = EMPTY;
      boardArray[fromRow][fromCol - 1] = EMPTY;
      boardArray[toRow][toCol] = O;
      totalPeg -= 1;
    } else if ((boardArray[fromRow][fromCol].equals(O)) && (toRow == fromRow)
            && (toCol == (fromCol + 2)) && (boardArray[toRow][toCol].equals(EMPTY))) {
      //move horizontal left to right
      boardArray[fromRow][fromCol] = EMPTY;
      boardArray[fromRow][fromCol + 1] = EMPTY;
      boardArray[toRow][toCol] = O;
      totalPeg -= 1;
    } else {
      throw new IllegalArgumentException("invalid position");
    }
  }


  /**
   * Determine and return if the game is over or not. A game is over if no more moves can be made.
   *
   * @return true if the game is over, false otherwise
   */
  public boolean isGameOver() {
    for (int r = 0; r < boardArray.length; r++) {
      for (int c = 0; c < boardArray[r].length; c++) {
        if (boardArray[r][c].equals("O")) {
          if ((totalPeg != 1) && ((c + 2) < boardArray[r].length - 1) &&
                  (boardArray[r][c + 2].equals("_")) && (boardArray[r][c + 1].equals("O"))
                  && ((c + 1) < boardArray[r].length - 1)) {
            return false;
          } else if ((totalPeg != 1) && ((c - 2) > 0) && (boardArray[r][c - 2].equals("_")) &&
                  ((c - 1) > 0) && (boardArray[r][c - 1].equals("O"))) {
            return false;
          } else if ((totalPeg != 1) && ((r - 2) > 0) && (boardArray[r - 2][c].equals("_"))
                  && ((r - 1) > 0) && (boardArray[r - 1][c].equals("O"))) {
            return false;
          } else if ((totalPeg != 1) && ((r + 2) < boardArray.length - 1)
                  && (boardArray[r + 2][c].equals("_")) && ((r + 1) < boardArray.length - 1)
                  && (boardArray[r + 1][c].equals("O"))) {
            return false;
          }
        }
      }
    }
    return true;
  }

  /**
   * Helper method take in arm thickness to calculate the actual board length.
   */
  protected int getBoardLength(int armThickness) {
    return armThickness * 3 - 2;
  }

  /**
   * Helper method creates board that is used for all constructors.
   */
  protected String[][] createBoard(int armThickness) throws IllegalArgumentException {
    if (armThickness < 3 || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("Arm thickness must be positive odd num bigger than 3");
    }
    int boardLength = getBoardLength(armThickness);
    boardArray = new String[boardLength][boardLength];

    return boardArray;
  }


  /**
   * Return a string that represents the current state of the board.
   */
  public String getGameState() {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < boardArray.length; row++) {
      String rowStr = "";
      for (int column = 0; column < boardArray[row].length; column++) {
        String spaceInBetween = BOARD_BORDER;
        if (column == 0) {
          spaceInBetween = "";
        }
        rowStr += spaceInBetween;
        rowStr += boardArray[row][column];
      }
      String regex = "\\s+$";
      rowStr = rowStr.replaceAll(regex, "");
      sb.append(rowStr);
      if (row < boardArray.length - 1) {
        sb.append("\n");
      }
    }
    return sb.toString();
  }


  /**
   * Return the number of marbles currently on the board.
   */

  public int getScore() {
    getGameState();
    return totalPeg;
  }
}