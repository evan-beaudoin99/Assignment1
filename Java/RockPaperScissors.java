/*
* This program is rock paper scissors
*
* @author  Evan Beaudoin
* @version 1.0
* @since   2024-03-04
*/

import java.util.Scanner;

/**
* This is the rock, paper, scissors program.
*/
final class RockPaperScissors {
    /**
    * Constants.
    */
    public static final String ROCK = "ROCK";

    /**
    * Constants.
    */
    public static final String PAPER = "PAPER";

    /**
    * Constants.
    */
    public static final String SCISSORS = "SCISSORS";

    /**
    * Constants.
    */
    private static final String EXIT = "EXIT";

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this is ever called
    *
    * @throws IllegalStateException if this is ever called
    *
    */
    private RockPaperScissors() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Gets a random choice of rock, paper or scissors.
    *
    * @param rock string
    * @param paper string
    * @param scissors string
    * @return random: rock, paper or scissors
    */

    public static String getComputerChoice(String ROCK,
          String PAPER, String SCISSORS) {
        final int min = 0;
        final int max = 2;
        final int randomNumber = (int) (Math.random() * (max - min + 1) + min);
        final String[] rockPaperScissorsArray = {ROCK, PAPER, SCISSORS};
        return rockPaperScissorsArray[randomNumber];
    }
    /**
    * Gets a random choice of rock, paper or scissors.
    *
    * @param scanner object
    * @return players input
    */

    public static String getPlayerChoice(Scanner scanner) {
        System.out.print("Choose: Rock, Paper or Scissors -->: ");
        final String playerChoice = scanner.next().toUpperCase();
        return playerChoice;
    }

    /**
    * Logic behind the game on who wins.
    * Compares the players choice and the computers choice.
    *
    * @param playerChoice is the players choice
    * @param computerChoice is the computer's choice
    * @return playerWon a boolean of wheter the player won or not
    */

    public static boolean getResult(String playerChoice,
          String computerChoice) {
        boolean playerWon = false;

        if (playerChoice.equals(ROCK) && computerChoice.equals(SCISSORS)) {
            playerWon = true;
        } else if (playerChoice.equals(PAPER) && computerChoice.equals(ROCK)) {
            playerWon = true;
        } else if (playerChoice.equals(SCISSORS)
              && computerChoice.equals(PAPER)) {
            playerWon = true;
        }

        return playerWon;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(String[] args) {

         System.out.println("Type 'exit' to quit the loop\n");

        int score = 0;

        while (true) {
            final String playerChoice = getPlayerChoice(scanner);
            final String computerChoice = getComputerChoice(ROCK,
                PAPER, SCISSORS);

            System.out.println(getPlayerChoice(scanner));


            if (playerChoice.equals(EXIT)) {
                break;
            }

            if (playerChoice != ROCK) {
                System.out.println("\nPlease choose Rock, Paper, or Scissors!");
                continue;
            }

            final boolean playerWon = getResult(playerChoice, computerChoice);

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
    
}
