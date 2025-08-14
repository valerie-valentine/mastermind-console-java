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
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted!");
            }

            this.time--;
        }
        isTimeUp = true;
    }

    public String getTimeLeft() {
        int minutes = this.time / 60;
        int seconds = this.time % 60;
        return String.format("TIME LEFT: %02d:%02d", minutes, seconds);
    }


    public boolean getIsTimeUp(){
        return this.isTimeUp;
    }
}
