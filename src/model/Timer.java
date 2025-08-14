package model;

public class Timer implements Runnable {
    private int minutes;

    public Timer(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public void run() {
        int seconds = minutes * 60;

        while (seconds > 0) {
            int displayMinutes = seconds / 60;
            int displaySeconds = seconds % 60;
            System.out.printf("\rTime left: %02d:%02d", displayMinutes, displaySeconds);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }

            seconds--;
        }

        System.out.println();
        System.out.println("Time's up!");
    }
}
