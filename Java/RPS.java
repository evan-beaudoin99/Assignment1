/**
 * This is the rock,
 * paper, scissors program.
 *
 * By:Evan Beaudoin
 * Version: 1.0
 * Since:   2024-03-06
 */

import java.util.Scanner;

public class RPS {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Type 'exit' to quit the loop\n");

    int score = 0;
    String rock = "ROCK";
    String paper = "PAPER";
    String scissors = "SCISSORS";

    while (true) {
      String playerChoice = getPlayerChoice(scanner);
      String computerChoice = getComputerChoice(rock, paper, scissors);

      if (playerChoice.equalsIgnoreCase("EXIT")) {
        break;
      }

      if (!playerChoice.equals(rock) && !playerChoice.equals(paper) && !playerChoice.equals(scissors)) {
        System.out.println("\nInvalid input. Please choose Rock, Paper, or Scissors!");
        continue;
      }

      boolean playerWon = getResult(playerChoice, computerChoice);

      System.out.println("Computer chose: " + computerChoice);

      if (playerWon) {
        System.out.println("\nYou won!");
        score += 1;
      } else if (playerChoice.equals(computerChoice)) {
        System.out.println("\nYou Tied!");
      } else {
        System.out.println("\nYou lost!");
      }

      System.out.println("\nScore: " + score);
    }
    System.out.println("\nDone.");
  }

  public static String getComputerChoice(String rock, String paper, String scissors) {
    int min = 0;
    int max = 2;
    int randomNumber = (int) (Math.random() * (max - min + 1) + min);
    String[] rockPaperScissorsArray = {rock, paper, scissors};
    return rockPaperScissorsArray[randomNumber];
  }

  public static String getPlayerChoice(Scanner scanner) {
    System.out.print("Choose: Rock, Paper or Scissors -->: ");
    String playerChoice = scanner.next().toUpperCase();
    return playerChoice;
  }

  public static boolean getResult(String playerChoice, String computerChoice) {
    boolean playerWon = false;

    if (playerChoice.equals("ROCK") && computerChoice.equals("SCISSORS")) {
      playerWon = true;
    } else if (playerChoice.equals("PAPER") && computerChoice.equals("ROCK")) {
      playerWon = true;
    } else if (playerChoice.equals("SCISSORS") && computerChoice.equals("PAPER")) {
      playerWon = true;
    }

    return playerWon;
  }
}
