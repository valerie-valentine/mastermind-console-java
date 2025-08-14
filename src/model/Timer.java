package model;

public class Timer implements Runnable {
    int minutes;
    private volatile boolean isTimeUp = false;
    private int time;

    public Timer (int seconds) {
        this.time = seconds;
    }

    @Override
    public void run() {
        while (this.time > 0) {
            int displayMinutes = time / 60;
            int displaySeconds = time % 60;
//            System.out.printf("\rTime left: %02d:%02d", displayMinutes, displaySeconds);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }

            this.time--;
        }

//        System.out.println();
//        System.out.println("Time's up!");
        isTimeUp = true;
    }

    public boolean getIsTimeUp(){
        return this.isTimeUp;
    }
}
