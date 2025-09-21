package com.example.deathnum.help_classes;

public class Time {
    public void time(Long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
