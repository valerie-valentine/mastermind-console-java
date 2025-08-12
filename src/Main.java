import model.Board;
import model.CodeMaker;
import model.DifficultyLevel;
import model.Guess;
import view.View;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Board board = new Board(new String[] {"1", "2", "3", "4"});
        board.evaluateUserGuess(new String[] {"1", "5", "3", "6"});



    }
}
