package cs5004.marblesolitaire.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cs5004.marblesolitaire.model.hw09.EuropeanSolitaireModelImpl;
import cs5004.marblesolitaire.model.hw09.TriangleSolitaireModelImpl;

/**
 * Main class Marble Solitaire where user can pass in arguments and create a board game to play.
 */
public final class MarbleSolitaire {
  /**
   * Main class Marble Solitaire, takes in a string of arguments and parse it accordingly to get the
   * appropriate board game and length.
   *
   * @param args string of argument where users pass in.
   */
  public static void main(String[] args) {
    List<String> commandList = new ArrayList<>();

    for (String each : args) {
      commandList.add(each);
    }

    Iterator<String> arguments = commandList.iterator();

    if (commandList.size() == 1) {
      if (args[0].equals("english")) {
        MarbleSolitaireModelImpl english = new MarbleSolitaireModelImpl();
        System.out.print(english.getGameState());
      } else if (args[0].equals("triangular")) {
        TriangleSolitaireModelImpl triangle = new TriangleSolitaireModelImpl();
        System.out.print(triangle.getGameState());
      } else if (args[0].equals("european")) {
        EuropeanSolitaireModelImpl european = new EuropeanSolitaireModelImpl();
        System.out.print(european.getGameState());
      }
    } else {
      if (args[1].equals("-size")) {
        if (args[0].equals("english")) {
          int armThickness = Integer.parseInt(args[2]);
          MarbleSolitaireModelImpl english = new MarbleSolitaireModelImpl(armThickness);
          System.out.print(english.getGameState());
        } else if (args[0].equals("triangular")) {
          int armThickness = Integer.parseInt(args[2]);
          TriangleSolitaireModelImpl triangle = new TriangleSolitaireModelImpl(armThickness);
          System.out.print(triangle.getGameState());
        } else if (args[0].equals("european")) {
          int armThickness = Integer.parseInt(args[2]);
          EuropeanSolitaireModelImpl european = new EuropeanSolitaireModelImpl(armThickness);
          System.out.print(european.getGameState());
        }
      } else if (args[1].equals("-hole")) {
        if (args[0].equals("english")) {
          int sRow = Integer.parseInt(args[2]);
          int sCol = Integer.parseInt(args[3]);
          EuropeanSolitaireModelImpl english = new EuropeanSolitaireModelImpl(sRow, sCol);
          System.out.print(english.getGameState());
        } else if (args[0].equals("triangular")) {
          int sRow = Integer.parseInt(args[2]);
          int sCol = Integer.parseInt(args[3]);
          TriangleSolitaireModelImpl triangle = new TriangleSolitaireModelImpl(sRow, sCol);
          System.out.print(triangle.getGameState());
        } else if (args[0].equals("european")) {
          int sRow = Integer.parseInt(args[2]);
          int sCol = Integer.parseInt(args[3]);
          EuropeanSolitaireModelImpl european = new EuropeanSolitaireModelImpl(sRow, sCol);
          System.out.print(european.getGameState());
        }
      }

    }
  }
}
