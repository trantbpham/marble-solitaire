import org.junit.Test;

import cs5004.marblesolitaire.model.hw09.EuropeanSolitaireModelImpl;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for european solitaire implementation.
 */
public class EuropeanSolitaireModelImplTest {
  EuropeanSolitaireModelImpl regular = new EuropeanSolitaireModelImpl();
  EuropeanSolitaireModelImpl europeanRowColumn = new EuropeanSolitaireModelImpl(4, 4);
  EuropeanSolitaireModelImpl europeanArmRowColumn = new EuropeanSolitaireModelImpl(3, 4, 4);
  EuropeanSolitaireModelImpl europeanArm = new EuropeanSolitaireModelImpl(5);


  @Test
  public void createBoardTest() {
    String testBoardArrayThreeSlot =
              "    O O O\n"
            + "  O O O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "  O O O O O\n"
            + "    O O O";
//    assertEquals(testBoardArrayThreeSlot, regular.getGameState());
//    assertEquals(36, regular.getScore());

    EuropeanSolitaireModelImpl europeanArm2 = new EuropeanSolitaireModelImpl(7);
    System.out.print(europeanArm2.getGameState());

    String testBoardArrayFive =
              "        O O O O O\n"
            + "      O O O O O O O\n"
            + "    O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O _ O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "O O O O O O O O O O O O O\n"
            + "  O O O O O O O O O O O\n"
            + "    O O O O O O O O O \n"
            + "      O O O O O O O\n"
            + "        O O O O O";
    assertEquals(testBoardArrayFive, europeanArm.getGameState());
    //assertEquals(36, europeanArm.getScore());
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

  @Test
  public void testMove() {
    regular.move(3, 1, 3, 3);
    String testBoardArrayThreeSlot =
            "    O O O\n"
                    + "  O O O O O\n"
                    + "O O O O O O O\n"
                    + "O _ _ O O O O\n"
                    + "O O O O O O O\n"
                    + "  O O O O O\n"
                    + "    O O O";
    assertEquals(testBoardArrayThreeSlot, regular.getGameState());
    assertEquals(35, regular.getScore());

    regular.move(3, 4, 3, 2);
    String testBoardArrayThreeSlot2 =
            "    O O O\n"
                    + "  O O O O O\n"
                    + "O O O O O O O\n"
                    + "O _ O _ _ O O\n"
                    + "O O O O O O O\n"
                    + "  O O O O O\n"
                    + "    O O O";
    assertEquals(testBoardArrayThreeSlot2, regular.getGameState());
    assertEquals(34, regular.getScore());
  }

  /**
   * Test invalid move input.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMove() {
    regular.move(-4, -5, -2, -5);
    System.out.println("negative number");

    regular.move(7, 7, 6, 7);
    System.out.println("index out of bound");

    regular.move(2, 2, 3, 3);
    System.out.println("cannot move diagonally");
  }

  @Test
  public void testGameOver() {
    System.out.print("\n0 : \n" + regular.getGameState());

    regular.move(3, 1, 3, 3);
    assertFalse(regular.isGameOver());
    assertEquals(35, regular.getScore());
    System.out.print("\n1: \n" + regular.getGameState());

    regular.move(3, 4, 3, 2);
    assertFalse(regular.isGameOver());
    assertEquals(34, regular.getScore());
    System.out.print("\n2: \n" + regular.getGameState());

    regular.move(5, 1, 3, 1);
    assertFalse(regular.isGameOver());
    assertEquals(33, regular.getScore());
    System.out.print("\n3: \n" + regular.getGameState());

    regular.move(5, 3, 3, 3);
    assertFalse(regular.isGameOver());
    assertEquals(32, regular.getScore());
    System.out.print("\n4: \n" + regular.getGameState());

    regular.move(5, 4, 3, 4);
    assertFalse(regular.isGameOver());
    assertEquals(31, regular.getScore());
    System.out.print("\n5: \n" + regular.getGameState());

    regular.move(4, 6, 4, 4);
    assertFalse(regular.isGameOver());
    assertEquals(30, regular.getScore());
    System.out.print("\n6: \n" + regular.getGameState());

    regular.move(2, 1, 4, 1);
    assertFalse(regular.isGameOver());
    assertEquals(29, regular.getScore());
    System.out.print("\n7: \n" + regular.getGameState());

    regular.move(3, 4, 5, 4);
    assertFalse(regular.isGameOver());
    assertEquals(28, regular.getScore());
    System.out.print("\n8: \n" + regular.getGameState());

    regular.move(3, 6, 3, 4);
    assertFalse(regular.isGameOver());
    assertEquals(27, regular.getScore());
    System.out.print("\n9: \n" + regular.getGameState());

    regular.move(4, 1, 4, 3);
    assertFalse(regular.isGameOver());
    assertEquals(26, regular.getScore());
    System.out.print("\n10: \n" + regular.getGameState());

    regular.move(3, 3, 3, 5);
    assertFalse(regular.isGameOver());
    assertEquals(25, regular.getScore());
    System.out.print("\n11: \n" + regular.getGameState());

    regular.move(6, 4, 4, 4);
    assertFalse(regular.isGameOver());
    assertEquals(24, regular.getScore());
    System.out.print("\n12: \n" + regular.getGameState());

    regular.move(2, 3, 2, 1);
    assertFalse(regular.isGameOver());
    assertEquals(23, regular.getScore());
    System.out.print("\n13: \n" + regular.getGameState());

    regular.move(4, 4, 4, 2);
    assertFalse(regular.isGameOver());
    assertEquals(22, regular.getScore());
    System.out.print("\n14: \n" + regular.getGameState());

    regular.move(2, 5, 4, 5);
    assertFalse(regular.isGameOver());
    assertEquals(21, regular.getScore());
    System.out.print("\n15: \n" + regular.getGameState());

    regular.move(6, 2, 6, 4);
    assertFalse(regular.isGameOver());
    assertEquals(20, regular.getScore());
    System.out.print("\n16: \n" + regular.getGameState());

    regular.move(4, 2, 6, 2);
    assertFalse(regular.isGameOver());
    assertEquals(19, regular.getScore());
    System.out.print("\n17: \n" + regular.getGameState());

    regular.move(5, 5, 3, 5);
    assertFalse(regular.isGameOver());
    assertEquals(18, regular.getScore());
    System.out.print("\n18: \n" + regular.getGameState());

    regular.move(1, 1, 3, 1);
    assertFalse(regular.isGameOver());
    assertEquals(17, regular.getScore());
    System.out.print("\n19: \n" + regular.getGameState());

    regular.move(3, 1, 3, 3);
    assertFalse(regular.isGameOver());
    assertEquals(16, regular.getScore());
    System.out.print("\n20: \n" + regular.getGameState());

    regular.move(0, 2, 2, 2);
    assertFalse(regular.isGameOver());
    assertEquals(15, regular.getScore());
    System.out.print("\n21: \n" + regular.getGameState());

    regular.move(0, 3, 2, 3);
    assertFalse(regular.isGameOver());
    assertEquals(14, regular.getScore());
    System.out.print("\n22: \n" + regular.getGameState());

    regular.move(2, 3, 4, 3);
    assertFalse(regular.isGameOver());
    assertEquals(13, regular.getScore());
    System.out.print("\n23: \n" + regular.getGameState());

    regular.move(1, 4, 3, 4);
    assertFalse(regular.isGameOver());
    assertEquals(12, regular.getScore());
    System.out.print("\n24: \n" + regular.getGameState());

    regular.move(3, 4, 3, 6);
    assertFalse(regular.isGameOver());
    assertEquals(11, regular.getScore());
    System.out.print("\n25: \n" + regular.getGameState());

    regular.move(2, 6, 4, 6);
    assertTrue(regular.isGameOver());
    assertEquals(10, regular.getScore());
    System.out.print("\n26: \n" + regular.getGameState());
  }
}
