package model;

public class Guess {
    private String[] guess;
    private int correctNumber;
    private int correctLocation;

    public Guess(String[] guess) {
        this.guess = guess;
    }

    public void setCorrectLocation(int correctLocation) {
        this.correctLocation = correctLocation;
    }

    public void setCorrectNumber(int correctNumber) {
        this.correctNumber = correctNumber;
    }

    public String[] getGuess() {
        return guess;
    }

    public int getCorrectLocation() {
        return correctLocation;
    }

    public int getCorrectNumber() {
        return correctNumber;
    }
}
