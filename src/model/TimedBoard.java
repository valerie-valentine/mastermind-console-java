package model;


public class TimedBoard implements Board {
    private final ClassicBoard classicBoard;
    private final Timer timer;
    private String gameStatus = "In Progress";

    public TimedBoard(String[] answer, Timer timer) {
        this.classicBoard = new ClassicBoard(answer);
        this.timer = timer;
    }

    @Override
    public boolean hasGuessBeenPlayed(Guess newGuess) {
        return classicBoard.hasGuessBeenPlayed(newGuess);
    }

    @Override
    public void evaluateUserGuess(Guess guess) {
        classicBoard.evaluateUserGuess(guess);
    }

    @Override
    public void submitUserGuess(Guess guess) {
        classicBoard.submitUserGuess(guess);

        if (timer.getIsTimeUp()) {
            gameStatus = "LOSS TIME";
        } else {
            gameStatus = classicBoard.getGameStatus();
        }
    }

    @Override
    public int getAttempts() {
        return classicBoard.getAttempts();
    }

    @Override
    public String getAnswer() {
        return classicBoard.getAnswer();
    }

    @Override
    public String getGameStatus() {
        return gameStatus;
    }

    public Timer getTimer() {
        return timer;
    }

    public void startTimer() {
        new Thread(timer).start();
    }

    @Override
    public String getBackgroundSoundFile() {
        return "src/resources/timed.wav";
    }

}
