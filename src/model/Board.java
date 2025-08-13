package model;

public interface Board {
    boolean hasGuessBeenPlayed(Guess guess);
    void evaluateUserGuess(Guess guess);
    void submitUserGuess(Guess guess);
    int getAttempts();
    String getAnswer();
    String getGameStatus();
}

// might repurpose getAttempts to be the time left in time mode