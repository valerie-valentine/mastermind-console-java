package model;

public interface Board {
    boolean hasGuessBeenPlayed(Guess guess);
    void evaluateUserGuess(Guess guess);
    void submitUserGuess(Guess guess);
    int getAttempts();
    String getAnswer();
    String getGameStatus();
    String getBackgroundSoundFile();
}