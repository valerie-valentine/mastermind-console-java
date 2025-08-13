package model;

public class Timer {

    public static void clock (int minutes) throws InterruptedException {
        int seconds = minutes * 60;

        while (seconds > 0) {
            Thread.sleep(1000);
            seconds--;
            System.out.println(seconds);
            }

            System.out.println("Time's up!");
        }
    }
