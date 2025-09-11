package com.example.deathnum;

import android.app.Application;

public class App extends Application {
    private int Globalcount = 0;

    public int getGlobalcount() {
        return Globalcount;
    }

    public void setGlobalcount(int globalcount) {
        Globalcount = globalcount;
    }
    public void startNewGame() {
        this.Globalcount = 0;
    }
}
