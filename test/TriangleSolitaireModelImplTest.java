import org.junit.Test;

import cs5004.marblesolitaire.model.hw09.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test cases for triangle solitaire implementation.
 */
public class TriangleSolitaireModelImplTest {

  TriangleSolitaireModelImpl triangleModel = new TriangleSolitaireModelImpl();
  TriangleSolitaireModelImpl regular = new TriangleSolitaireModelImpl();
  TriangleSolitaireModelImpl triangleRowColumn = new TriangleSolitaireModelImpl(4, 0);
  TriangleSolitaireModelImpl triangleArm = new TriangleSolitaireModelImpl(3);
  TriangleSolitaireModelImpl triangleArmRowColumn = new TriangleSolitaireModelImpl(8, 4, 2);

  String testTriangle =
          "O\n"
                  + "O O\n"
                  + "O O O\n"
                  + "O O O O\n"
                  + "O O O O O";

  String testTriangleArm8 =
                    "O\n"
                  + "O O\n"
                  + "O O O\n"
                  + "O O O O\n"
                  + "O O O O O\n"
                  + "O O O O O O\n"
                  + "O O O O O O O\n"
                  + "O O O O O O O O";

  @Test
  public void createBoardTest() {
//    triangleModel.createBoard(5);
//    assertEquals(testTriangle, triangleModel.getGameState());
//    assertEquals(15, triangleModel.getScore());

    TriangleSolitaireModelImpl triangleModel2 = new TriangleSolitaireModelImpl();
    triangleModel2.createBoard(8);
    assertEquals(testTriangleArm8, triangleModel2.getGameState());
    assertEquals(35, triangleModel2.getScore());
  }

  @Test
  public void testBoardBeforepPlay() {

    String testRegularTriangle =
            "_\n"
                    + "O O\n"
                    + "O O O\n"
                    + "O O O O\n"
                    + "O O O O O";
   // assertEquals(testRegularTriangle, regular.getGameState());
  //  assertEquals(15, regular.getScore());


    String testTriangleRowColumn =
            "O\n"
                    + "O O\n"
                    + "O O O\n"
                    + "O O O O\n"
                    + "_ O O O O";
    assertEquals(testTriangleRowColumn, triangleRowColumn.getGameState());
    assertEquals(15, triangleRowColumn.getScore());


    String testTriangleArm =
            "_\n"
                    + "O O\n"
                    + "O O O";
    assertEquals(testTriangleArm, triangleArm.getGameState());
    assertEquals(5, triangleArm.getScore());


    String testTriangleArmRowColumn =
            "O\n"
                    + "O O\n"
                    + "O O O\n"
                    + "O O O O\n"
                    + "O O _ O O\n"
                    + "O O O O O O\n"
                    + "O O O O O O O\n"
                    + "O O O O O O O O";
    assertEquals(testTriangleArmRowColumn, triangleArmRowColumn.getGameState());
    assertEquals(35, triangleArmRowColumn.getScore());
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
  public void testMove() {
    regular.move(2, 0, 0, 0);
    String regularMove =
            "O\n"
                    + "_ O\n"
                    + "_ O O\n"
                    + "O O O O\n"
                    + "O O O O O";

    assertEquals(regularMove, regular.getGameState());

    regular.move(2, 2, 2, 0);
    String regularMove2 =
            "O\n"
                    + "_ O\n"
                    + "O _ _\n"
                    + "O O O O\n"
                    + "O O O O O";
    assertEquals(regularMove2, regular.getGameState());
    System.out.println(regular.getScore());
  }

  @Test
  public void testBiggerTriangleMove() {
    triangleArmRowColumn.move(6, 2, 4, 2);
    String testTriangleArmRowColumn =
            "O\n"
                    + "O O\n"
                    + "O O O\n"
                    + "O O O O\n"
                    + "O O O O O\n"
                    + "O O _ O O O\n"
                    + "O O _ O O O O\n"
                    + "O O O O O O O O";
    assertEquals(testTriangleArmRowColumn, triangleArmRowColumn.getGameState());

    triangleArmRowColumn.move(6, 4, 6, 2);
    String testTriangleArmRowColumn2 =
            "O\n"
                    + "O O\n"
                    + "O O O\n"
                    + "O O O O\n"
                    + "O O O O O\n"
                    + "O O _ O O O\n"
                    + "O O O _ _ O O\n"
                    + "O O O O O O O O";
    assertEquals(testTriangleArmRowColumn2, triangleArmRowColumn.getGameState());
    assertFalse(triangleArmRowColumn.isGameOver());

  }

  @Test
  public void testGameOver() {
    System.out.print("\n0 : \n" + regular.getGameState());
    //assertEquals(14, regular.getScore());

    regular.move(2, 0, 0, 0);
    assertFalse(regular.isGameOver());
    assertEquals(13, regular.getScore());
    System.out.print("\n1: \n" + regular.getGameState());

    regular.move(2, 2, 2, 0);
    assertFalse(regular.isGameOver());
    assertEquals(12, regular.getScore());
    System.out.print("\n2: \n" + regular.getGameState());

    regular.move(3, 0, 1, 0);
    assertFalse(regular.isGameOver());
    assertEquals(11, regular.getScore());
    System.out.print("\n3: \n" + regular.getGameState());

    regular.move(0, 0, 2, 0);
    assertFalse(regular.isGameOver());
    assertEquals(10, regular.getScore());
    System.out.print("\n4: \n" + regular.getGameState());

    regular.move(3, 2, 3, 0);
    assertFalse(regular.isGameOver());
    assertEquals(9, regular.getScore());
    System.out.print("\n4: \n" + regular.getGameState());

    regular.move(3, 0, 1, 0);
    assertTrue(regular.isGameOver());
    assertEquals(8, regular.getScore());
    System.out.print("\n5: \n" + regular.getGameState());
    System.out.print("\n" + regular.getScore());
  }
}
