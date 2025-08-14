package view;

public class TimedUI implements GameUI {
    private final ClassicUI classicUI;

    public TimedUI() {
        this.classicUI = new ClassicUI();
    }

    @Override
    public String getGameMode() {
        return classicUI.getGameMode();
    }

    @Override
    public void displayInstructions() {
        System.out.println(AsciiArt.GAME_LOGO_2);
        System.out.println("Welcome to Mastermind!");
        System.out.println("******************************TIMED MODE******************************");
        System.out.println("A secret code has been locked away by the computer.");
        System.out.println("Your mission: break the code and save the world!");
        System.out.println("A number from 0-9 has been chosen based on your level.");
        System.out.println("You have 10 guesses to crack it.");
        System.out.println("But beware! In TIMED MODE, the clock is ticking....");
        System.out.println("You only have 30 seconds to guess before we all go KABOOM!");
        System.out.println("Good luck, agent. The world is counting on you!\n");
    }

    @Override
    public void showDebugCode(String[] secretCode) {
        classicUI.showDebugCode(secretCode);
    }

    @Override
    public void showMessage(String message) {
        classicUI.showMessage(message);
    }

    @Override
    public void showAttemptsRemaining(int lives) {
        classicUI.showAttemptsRemaining(lives);
    }

    @Override
    public void showGuessFeedback(int correctNumber, int correctLocation) {
        classicUI.showGuessFeedback(correctNumber, correctLocation);
    }

    @Override
    public String getDifficultyLevel() {
        return classicUI.getDifficultyLevel();
    }

    @Override
    public String[] getUserGuess(int codeLength) {
        return classicUI.getUserGuess(codeLength);
    }

    @Override
    public boolean askForPlayAgain() {
        return classicUI.askForPlayAgain();
    }

    @Override
    public void showGameOver(String gameResult, String answer) {
        if (gameResult.equals("LOSS TIME")) {
            System.out.println(AsciiArt.TIME_UP_LOGO);
            System.out.println("YOU RAN OUT OF TIME!!!!!!!!!!");
            System.out.println("Sorry!! You lose!!!!");
            System.out.println("The answer was " + answer + ".");
        } else {
            classicUI.showGameOver(gameResult, answer);
        }
    }
}


