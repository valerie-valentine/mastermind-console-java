package view;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class TimedUI implements GameUI{
    private final Scanner scanner = new Scanner(System.in);

    public String getGameMode() {
        while (true) {
            System.out.print("Please choose a game mode: CLASSIC, TIMED: ");
            String userInput = scanner.nextLine().toUpperCase();


            if (userInput.equals("CLASSIC")) {
                return "CLASSIC";
            } else if (userInput.equals("TIMED")) {
                return "TIMED";
            } else {
                System.out.println("Invalid input. Please enter a valid choice: (CLASSIC), (TIMED)\n");
            }
        }
    }

    public void displayInstructions() {
        System.out.println(AsciiArt.GAME_LOGO);
        System.out.println("Welcome to Mastermind!");
        System.out.println("Play against the computer and break the code to win.");
        System.out.println("A random number from the digits 0-9 will be generated based on your chosen level.");
        System.out.println("You will have 10 attempts to guess the number.");
        System.out.println("Hints will be provided to help you along the way.");
        System.out.println("Good luck!\n");
    }

    public void showDebugCode(String[] secretCode) {
        if (secretCode != null) {
            System.out.println("Debugging String: " + String.join("", secretCode));
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showAttemptsRemaining(int lives) {
        System.out.println("You have " + lives + " lives remaining.\n");

    }

    public void showGuessFeedback(int correctNumber, int correctLocation){
        if (correctNumber == 0 && correctLocation == 0) {
            System.out.println("All incorrect.\n");
        } else {
            System.out.println(correctNumber + " correct number " + correctLocation + " correct location\n");
        }
    }

    public String getDifficultyLevel() {
        while (true) {
            System.out.print("Please choose a difficulty level: easy: (4 digits), medium: (6 digits), hard: (8 digits). ");
            String userInput = scanner.nextLine().toLowerCase();


            if (userInput.equals("easy")) {
                return "EASY";
            } else if (userInput.equals("medium")) {
                return "MEDIUM";
            } else if (userInput.equals("hard")) {
                return "HARD";
            } else {
                System.out.println("Invalid input. Please enter a valid choice: easy, medium, hard.\n");
            }
        }
    }

    public String[] getUserGuess(int codeLength){
        while (true) {
            System.out.print("Please enter a Guess: ");
            String userInput = scanner.nextLine();

            if (userInput.length() != codeLength) {
                System.out.println("Please enter a " + codeLength + " digit number.\n");
            } else if (!userInput.matches("\\d+")) {
                System.out.println("Please enter a valid number.\n");
            } else {
                return userInput.split("");
            }
        }
    }

    public boolean askForPlayAgain() {
        while (true) {
            System.out.print("Would you like to play again?: (yes/no). ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("yes")) {
                return true;
            } else if (userInput.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter a valid choice: yes or no.\n");
            }

        }
    }

    public void showGameOver(String gameResult, String answer){
        if (gameResult.equals("WIN")) {
            System.out.println(AsciiArt.WIN_LOGO);
            System.out.println("Congrats! You won :)." );
            System.out.println("The answer was " + answer + ".");
        } else if (gameResult.equals("LOSS TIME")) {
            System.out.println(AsciiArt.LOST_LOGO);
            System.out.println("RAN OUT TIME!!!!!!!!!!");
            System.out.println("Sorry!! You lose!!!!");
            System.out.println("The answer was " + answer + ".");
        } else {
            System.out.println(AsciiArt.LOST_LOGO);
            System.out.println("Sorry! You lost :<.");
            System.out.println("The answer was " + answer + ".");
        }
    }
}
