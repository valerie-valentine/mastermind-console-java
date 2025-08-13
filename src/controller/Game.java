package controller;

import model.Board;
import model.CodeMaker;
import model.DifficultyLevel;
import model.Guess;
import view.View;


public class Game {
    private View view;
    private Board board;

    public Game () {
        this.view = new View();
    }

    public void startGame() {
        this.view.displayInstructions();
        String levelInput = view.getDifficultyLevel();
        int codeLength = DifficultyLevel.valueOf(levelInput).getCodeLength();
        String[] secretCode = CodeMaker.generateRandomCode(codeLength);
        this.view.showDebugCode(secretCode);

        if (secretCode != null) {
            this.board = new Board(secretCode);
            playGame(codeLength);
        } else {
            view.showMessage("Oops! We couldn’t generate the secret code. Please try again.");
        }
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
            this.board.submitUserGuess(userGuess);
        }

        checkIfGameOver();
        restartGame();
    }

    public void checkIfGameOver() {
        boolean gameStatus = this.board.getGameStatus().equals("Won");
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
