package me.a8kj.simpletimer.entity;

import lombok.Getter;

@Getter
public class Timer {

    private int minutes = 0;
    private int seconds = 0;

    public static Timer of(int minutes, int seconds) {
        if (minutes < 0 || seconds < 0 || (minutes == 0 && seconds == 0))
            throw new IllegalArgumentException("Hey! , You cannot input invalid variables here");
        return new Timer(minutes, seconds);
    }

    private Timer(int minutes, int seconds) {

        if (minutes >= 60) {
            this.minutes = minutes % 60;
        } else {
            this.minutes = minutes;
        }

        if (seconds >= 60) {
            this.minutes += seconds / 60;
            this.seconds = seconds % 60;
        } else {
            this.seconds = seconds;
        }

    }

    public void start() {
        if (this.minutes > 0) {
            if (this.seconds <= 1) {
                this.minutes--;
                this.seconds = 60;
                this.seconds--;
            } else if (this.seconds > 1) {
                this.seconds--;
            }
        }

        if (minutes == 0 && seconds > 0) {
            seconds--;
        }
    }

    public void print() {
        System.out.println(minutes + "m " + seconds + "s");
    }

    public void reset(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public boolean canEnd() {
        return seconds <= 0 && minutes <= 0;
    }

}