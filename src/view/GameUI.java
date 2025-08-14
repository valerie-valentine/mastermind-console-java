package view;

public interface GameUI {
    public String getGameMode();
    public void displayInstructions();
    public void showDebugCode(String[] secretCode);
    public void showMessage(String message);
    public void showAttemptsRemaining(int lives);
    public void showGuessFeedback(int correctNumber, int correctLocation);
    public String getDifficultyLevel();
    public String[] getUserGuess(int codeLength);
    public boolean askForPlayAgain();
    public void showGameOver(String gameResult, String answer);
}
