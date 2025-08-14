package controller;

import model.*;
import view.ClassicUI;
import view.GameUI;
import view.TimedUI;


public class Game {
    private GameUI view;
    private Board board;
//    private SoundPlayer soundPlayer;

    public Game () {
        this.view = new ClassicUI();
//        this.soundPlayer = new SoundPlayer();
    }

    public void startGame() {
        this.view.displayInstructions();
        String mode = view.getGameMode();   // CLASSIC, TIMED, EMOJI
        String levelInput = view.getDifficultyLevel();
        int codeLength = DifficultyLevel.valueOf(levelInput).getCodeLength();
        String[] secretCode = CodeMaker.generateRandomCode(codeLength);


        if (secretCode == null) {
            view.showMessage("Oops! Couldn’t generate the secret code. Please try again.");
            return;
        }

        if (mode.equals("CLASSIC")) {
            board = new ClassicBoard(secretCode);
            view = new ClassicUI();
        } else if (mode.equals("TIMED")) {
            Timer timer = new Timer(30);
            board = new TimedBoard(secretCode, timer);
            view = new TimedUI();
            ((TimedBoard) board).startTimer();
        }

//        String soundFile = board.getBackgroundSoundFile();
//        if (soundFile != null) {
//            soundPlayer.playSound(soundFile);
//        }
        view.showDebugCode(secretCode);
//        playGame(codeLength);
    }

    public void playGame(int codeLength) {
        while (this.board.getGameStatus().equals("In Progress")) {
            this.view.showAttemptsRemaining(this.board.getAttempts());
            String[] userInput = this.view.getUserGuess(codeLength);
            Guess userGuess = new Guess(userInput);

            if (this.board.hasGuessBeenPlayed(userGuess)){
                view.showMessage("Guess: " + String.join("", userGuess.getGuess()) + " has been played before!\n" );
                continue;
            }

            this.board.evaluateUserGuess(userGuess);
            this.view.showGuessFeedback(userGuess.getCorrectNumber(), userGuess.getCorrectLocation());

            if (board instanceof TimedBoard timedBoard) {
                view.showMessage(timedBoard.getTimer().getTimeLeft());
            }
            this.board.submitUserGuess(userGuess);
        }

        checkIfGameOver();
//        soundPlayer.stopSound();
        restartGame();
    }

    public void checkIfGameOver() {
        String gameStatus = this.board.getGameStatus();
        this.view.showGameOver(gameStatus, this.board.getAnswer());
    }

    public void restartGame() {
        boolean playAgain = this.view.askForPlayAgain();

        if (playAgain) {
            startGame();
        } else {
            this.view.showMessage("Thanks for playing :3");
        }

    }
}
