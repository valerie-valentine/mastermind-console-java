package model;

public class Timer {

    public static void clock (int minutes) throws InterruptedException {
        int seconds = minutes * 60;

        while (seconds > 0) {
            int displayMinutes = seconds / 60;
            int displaySeconds = seconds % 60;
            System.out.printf("\rTime left: %02d:%02d", displayMinutes, displaySeconds);
            Thread.sleep(1000);
            seconds--;
            }
            System.out.println();
            System.out.println("Time's up!");
        }
    }
