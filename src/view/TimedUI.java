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
        classicUI.displayInstructions();
        System.out.println("***********You are playing in TIMED mode. You'll only have 15 seconds to guess the number!!! Watch the clock!***********\n");
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
            System.out.println(AsciiArt.LOST_LOGO);
            System.out.println("YOU RAN OUT OF TIME!!!!!!!!!!");
            System.out.println("Sorry!! You lose!!!!");
            System.out.println("The answer was " + answer + ".");
        } else {
            classicUI.showGameOver(gameResult, answer);
        }
    }
}


