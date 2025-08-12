package view;

import org.w3c.dom.ls.LSOutput;

import java.util.Locale;
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
    }

    public void showGuessFeedback(int correct_number, int correct_location){

    }

    public String getDifficultyLevel() {
        System.out.println("Please choose a difficulty level: easy: (4 digits), medium: (6 digits), hard: (8 digits)");

        while(true){
            String input = scanner.nextLine();

            if (input.equals("easy")) {
                return "easy";
            } else if (input.equals("medium")) {
                return "medium";
            } else if (input.equals("hard")) {
                return "hard";
            } else {
                System.out.println("Invalid input. Please enter a valid choice: easy, medium, hard.");
            }
    }

    public void getUserGuess(){
    }

    public void askForPlayAgain() {

    }


    public void showGameOver(boolean won){
    }
}
