package view;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    public void displayInstructions() {
        System.out.println("Welcome to Mastermind!");
        System.out.println("Play against the computer and break the code to win.");
        System.out.println("A random number from the digits 0-9 will be generated based on your chosen level.");
        System.out.println("You will have 10 attempts to guess the number.");
        System.out.println("Hints will be provided to help you along the way.");
        System.out.println("Good luck!");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showLivesRemaining(int lives) {
        System.out.println("You have " + lives + " lives remaining.");

    }

    public void showGuessFeedback(int correctNumber, int correctLocation){
        if (correctNumber == 0 && correctLocation == 0) {
            System.out.println("All incorrect.");
        } else {
            System.out.println(correctNumber + " correct number/s " + correctLocation + " correct location/s.");
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
//
//
    public void showGameOver(boolean won, String answer){
        if (won) {
            System.out.println("Congrats! You won :)." );
            System.out.println("The answer was " + answer + ".");
        } else {
            System.out.println("Sorry! You lost :<.");
            System.out.println("The answer was " + answer + ".");
        }
    }
}



 // modify showGuessFeedback to change to plural when int greater than one - check if num is 1 and then change (ternary operator?)
// think about how to handle spaces