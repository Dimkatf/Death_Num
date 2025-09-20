package com.example.deathnum;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

public class App extends Application {
    private int Globalcount = 0;
    private static String selectedLanguage = "ru"; //

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public int getGlobalcount() {
        return Globalcount;
    }

    public void setGlobalcount(int globalcount) {
        Globalcount = globalcount;
    }

    public void startNewGame() {
        this.Globalcount = 0;
    }


    public static void setLanguage(String lang) {
        selectedLanguage = lang;
    }

    public static String getLanguage() {
        return selectedLanguage;
    }

    public static Context updateLocale(Context context) {
        return updateLocale(context, selectedLanguage);
    }

    public static Context updateLocale(Context context, String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration config = res.getConfiguration();
        config.setLocale(locale);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLayoutDirection(locale);
            return context.createConfigurationContext(config);
        } else {
            res.updateConfiguration(config, res.getDisplayMetrics());
            return context;
        }
    }
}
