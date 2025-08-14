package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClassicBoard implements Board {
    private int attempts = 10;
    private final String[] answer;
    private final ArrayList<Guess> guessHistory = new ArrayList<>();
    private String gameStatus = "In Progress";

    public ClassicBoard(String[] answer) {
        this.answer = answer;
    }

    @Override
    public boolean hasGuessBeenPlayed (Guess newGuess) {
        for (Guess previousGuess: guessHistory ) {
            if (Arrays.equals(previousGuess.getGuess(), newGuess.getGuess())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void evaluateUserGuess(Guess guess) {
        int correctNumber = 0;
        int correctLocation = 0;
        Map<String, Integer> answerCount = new HashMap<>();
        String[] guessArray = guess.getGuess();

        for (String num: this.answer) {
            answerCount.put(num, answerCount.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < guessArray.length; i++){
            if (guessArray[i].equals(this.answer[i])){
                correctLocation++;
            }
            if (answerCount.containsKey(guessArray[i]) && answerCount.get(guessArray[i]) > 0){
                correctNumber++;
                answerCount.put(guessArray[i], answerCount.get(guessArray[i]) - 1);
            }
        }

        guess.setCorrectNumber(correctNumber);
        guess.setCorrectLocation(correctLocation);
    }

    @Override
    public void submitUserGuess (Guess guess) {
        this.guessHistory.add(guess);

        if (Arrays.equals(guess.getGuess(), answer)) {
            this.gameStatus = "WIN";
        }else {
            this.attempts--;
            if (this.attempts == 0) {
                this.gameStatus = "LOSS";
            }
        }
    }

    @Override
    public int getAttempts(){
        return this.attempts;
    }
    @Override
    public String getAnswer() {
        return String.join("", this.answer);
    }
    @Override
    public String getGameStatus() {
        return this.gameStatus;
    }
    @Override
    public String getBackgroundSoundFile() {
        return "src/resources/classic.wav";
    }
}
