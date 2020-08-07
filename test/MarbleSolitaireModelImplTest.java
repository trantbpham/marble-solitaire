import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for marble solitaire implementation.
 */
public class MarbleSolitaireModelImplTest {
  private MarbleSolitaireModelImpl solitaireModel = new MarbleSolitaireModelImpl();
  private MarbleSolitaireModelImpl solitaireNoArguments = new MarbleSolitaireModelImpl();
  private MarbleSolitaireModelImpl solitaireThreeSlot
          = new MarbleSolitaireModelImpl(3, 2);
  private MarbleSolitaireModelImpl solitaireArmThickness
          = new MarbleSolitaireModelImpl(5);
  private MarbleSolitaireModelImpl solitaireAllArguments
          = new MarbleSolitaireModelImpl(5, 2, 5);

  private String testBoardArrayThree =
          "    O O O\n"
                  + "    O O O\n"
                  + "O O O O O O O\n"
                  + "O O O _ O O O\n"
                  + "O O O O O O O\n"
                  + "    O O O\n"
                  + "    O O O";


  private String testBoardArrayAllArguments =
          "        O O O O O\n"
                  + "        O O O O O\n"
                  + "        O _ O O O\n"
                  + "        O O O O O\n"
                  + "O O O O O O O O O O O O O\n"
                  + "O O O O O O O O O O O O O\n"
                  + "O O O O O O O O O O O O O\n"
                  + "O O O O O O O O O O O O O\n"
                  + "O O O O O O O O O O O O O\n"
                  + "        O O O O O\n"
                  + "        O O O O O\n"
                  + "        O O O O O\n"
                  + "        O O O O O";

  /**
   * Creating a game state before adding the empty slot.
   */
  @Test
  public void testGetGameState() {

    String testBoardArrayThree =
            "    O O O\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O O O O O O O\n"
                    + "O O O O O O O\n"
                    + "    O O O\n"
                    + "    O O O";
    solitaireModel.createBoard(3);
    assertEquals(testBoardArrayThree, solitaireModel.getGameState());

    String testBoardArrayFive =
            "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O";
    solitaireModel.createBoard(5);
    assertEquals(testBoardArrayFive, solitaireModel.getGameState());
  }

  /**
   * Create board and add empty slot.
   */
  @Test
  public void testEachTypeBeforePlay() {
    assertEquals(testBoardArrayThree, solitaireNoArguments.getGameState());
    String testBoardArrayThreeSlot = "    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O _ O O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O";
    assertEquals(testBoardArrayThreeSlot, solitaireThreeSlot.getGameState());
    String testBoardArrayFive = "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O\n"
            + "        O O O O O";
    assertEquals(testBoardArrayFive, solitaireArmThickness.getGameState());
    assertEquals(testBoardArrayAllArguments, solitaireAllArguments.getGameState());
  }

  /**
   * Test invalid input to create a board.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidBoardCreate() {
    MarbleSolitaireModelImpl noArguments = new MarbleSolitaireModelImpl();
    System.out.print(noArguments.getGameState());
    MarbleSolitaireModelImpl negativeInput = new MarbleSolitaireModelImpl(-3, -2);
    System.out.print(negativeInput.getGameState());
    MarbleSolitaireModelImpl evenArmThickness = new MarbleSolitaireModelImpl(4);
    System.out.print(evenArmThickness.getGameState());
    MarbleSolitaireModelImpl invalidMove
            = new MarbleSolitaireModelImpl(5, 0, 1);
    System.out.print(invalidMove.getGameState());
    MarbleSolitaireModelImpl evenInvalidMove
            = new MarbleSolitaireModelImpl(10, 2, -1);
    System.out.print(evenInvalidMove.getGameState());
  }

  /**
   * Test move method in the 3 arm thickness board.
   */
  @Test
  public void testMoveThree() {
    solitaireNoArguments.move(3, 1, 3, 3);

    testBoardArrayThree =
            "    O O O\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O _ _ O O O O\n"
                    + "O O O O O O O\n"
                    + "    O O O\n"
                    + "    O O O";
    assertEquals(testBoardArrayThree, solitaireNoArguments.getGameState());
    assertEquals(31, solitaireNoArguments.getScore());

    solitaireNoArguments.move(3, 4, 3, 2);

    testBoardArrayThree =
            "    O O O\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O _ O _ _ O O\n"
                    + "O O O O O O O\n"
                    + "    O O O\n"
                    + "    O O O";
    assertEquals(testBoardArrayThree, solitaireNoArguments.getGameState());
    assertEquals(30, solitaireNoArguments.getScore());

    solitaireNoArguments.move(5, 3, 3, 3);
    testBoardArrayThree =
            "    O O O\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O _ O O _ O O\n"
                    + "O O O _ O O O\n"
                    + "    O _ O\n"
                    + "    O O O";
    assertEquals(testBoardArrayThree, solitaireNoArguments.getGameState());
    assertEquals(29, solitaireNoArguments.getScore());

  }

  /**
   * Test move method in the 5 arm thickness board.
   */
  @Test
  public void testMoveFive() {
    solitaireAllArguments.move(4, 5, 2, 5);
    testBoardArrayAllArguments =
            "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O _ O O O\n"
                    + "O O O O O _ O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "O O O O O O O O O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O\n"
                    + "        O O O O O";

    assertEquals(testBoardArrayAllArguments, solitaireAllArguments.getGameState());
    assertEquals(103, solitaireAllArguments.getScore());

  }

  /**
   * Test invalid move input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    solitaireAllArguments.move(-4, -5, -2, -5);
    System.out.println("negative number");

    solitaireNoArguments.move(7, 7, 6, 7);
    System.out.println("index out of bound");

    solitaireNoArguments.move(2, 2, 3, 3);
    System.out.println("cannot move diagonally");
  }

  /**
   * Play a real game and test if the game is over.
   */
  @Test
  public void testIsGameOver() {
    testBoardArrayThree =
            "    O O O\n"
                    + "    O O O\n"
                    + "O O O O O O O\n"
                    + "O O O O O O O\n"
                    + "O O O _ O O O\n"
                    + "    O _ O\n"
                    + "    O O O";


    solitaireNoArguments.move(5, 3, 3, 3);
    assertEquals(31, solitaireNoArguments.getScore());

    solitaireNoArguments.move(4, 5, 4, 3);
    assertEquals(30, solitaireNoArguments.getScore());

    solitaireNoArguments.move(6, 4, 4, 4);
    assertFalse(solitaireNoArguments.isGameOver());
    assertEquals(29, solitaireNoArguments.getScore());

    solitaireNoArguments.move(6, 2, 6, 4);
    assertEquals(28, solitaireNoArguments.getScore());
    String printCurrentState1 = solitaireNoArguments.getGameState();
    System.out.print(printCurrentState1 + "\n\n");

    solitaireNoArguments.move(4, 2, 6, 2);
    assertEquals(27, solitaireNoArguments.getScore());

    solitaireNoArguments.move(2, 2, 4, 2);
    assertEquals(26, solitaireNoArguments.getScore());

    solitaireNoArguments.move(2, 0, 2, 2);
    assertEquals(25, solitaireNoArguments.getScore());
    assertFalse(solitaireNoArguments.isGameOver());

    solitaireNoArguments.move(3, 0, 3, 2);
    assertEquals(24, solitaireNoArguments.getScore());

    solitaireNoArguments.move(3, 2, 5, 2);
    assertEquals(23, solitaireNoArguments.getScore());

    solitaireNoArguments.move(3, 4, 5, 4);
    assertEquals(22, solitaireNoArguments.getScore());
    String printCurrentState2 = solitaireNoArguments.getGameState();
    System.out.print(printCurrentState2 + "\n\n");

    solitaireNoArguments.move(4, 0, 4, 2);
    assertEquals(21, solitaireNoArguments.getScore());

    solitaireNoArguments.move(4, 2, 4, 4);
    assertEquals(20, solitaireNoArguments.getScore());


    solitaireNoArguments.move(3, 6, 3, 4);
    assertEquals(19, solitaireNoArguments.getScore());
    String printCurrentState3 = solitaireNoArguments.getGameState();
    System.out.print(printCurrentState3 + "\n\n");

    solitaireNoArguments.move(3, 3, 3, 5);
    assertEquals(18, solitaireNoArguments.getScore());

    solitaireNoArguments.move(2, 5, 4, 5);
    assertEquals(17, solitaireNoArguments.getScore());

    solitaireNoArguments.move(1, 2, 3, 2);
    assertEquals(16, solitaireNoArguments.getScore());
    assertFalse(solitaireNoArguments.isGameOver());

    solitaireNoArguments.move(2, 4, 2, 2);
    assertEquals(15, solitaireNoArguments.getScore());

    solitaireNoArguments.move(0, 3, 2, 3);
    assertEquals(14, solitaireNoArguments.getScore());

    solitaireNoArguments.move(2, 3, 2, 1);
    assertEquals(13, solitaireNoArguments.getScore());

    solitaireNoArguments.move(0, 4, 2, 4);
    assertEquals(12, solitaireNoArguments.getScore());
    String printCurrentState4 = solitaireNoArguments.getGameState();
    System.out.print(printCurrentState4 + "\n\n");

    solitaireNoArguments.move(4, 5, 4, 3);
    assertEquals(11, solitaireNoArguments.getScore());

    solitaireNoArguments.move(6, 2, 4, 2);
    assertEquals(10, solitaireNoArguments.getScore());

    solitaireNoArguments.move(6, 4, 4, 4);
    assertEquals(9, solitaireNoArguments.getScore());

    solitaireNoArguments.move(4, 3, 4, 1);
    assertEquals(8, solitaireNoArguments.getScore());

    String printFinalState = solitaireNoArguments.getGameState();
    System.out.print(printFinalState);

    assertTrue(solitaireNoArguments.isGameOver());
  }
}
