package com.example.deathnum;

public class Time {
    public void time(Long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
