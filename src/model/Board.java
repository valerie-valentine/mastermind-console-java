package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private int attempts = 10;
    private String[] answer;
    private ArrayList<Guess> guessHistory;
    private String gameStatus = "In Progress";

    public Board(String[] answer) {
        this.answer = answer;
    }

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








}
