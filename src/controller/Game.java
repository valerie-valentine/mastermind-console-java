package controller;

import model.Board;
import model.CodeMaker;
import model.DifficultyLevel;
import view.View;

import java.util.Arrays;

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

        System.out.println(Arrays.toString(secretCode));

        if (secretCode != null) {
            this.board = new Board(secretCode);
        } else {
            view.showMessage("Oops! We couldn’t generate the secret code. Please try again.");
            return;
        }




    }



}
