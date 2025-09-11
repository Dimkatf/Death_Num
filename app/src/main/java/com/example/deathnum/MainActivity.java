package com.example.deathnum;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner languageSpinner;
    App app = (App) getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        languageSpinner = findViewById(R.id.languageSpinner);
        languageSpinner.setSelection(0);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1)
                    setLocale("en");
                else setLocale("ru");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        setupButtons();
    }

    private void setupButtons() {
        Button exitGame = findViewById(R.id.exit);
        exitGame.setOnClickListener(v -> {
            finishAffinity();
            System.exit(0);
        });

        Button onePlayer = findViewById(R.id.onePlayerBtn);
        onePlayer.setOnClickListener(v -> {
            Intent intent = new Intent(this, OnePlayerActivity.class);
            startActivity(intent);
        });

        Button twoPlayer = findViewById(R.id.twoPlayerBtn);
        twoPlayer.setOnClickListener(v -> {
            Intent intent = new Intent(this, TwoPlayerActivity.class);
            startActivity(intent);
        });

        Button superGame = findViewById(R.id.superGameBtn);
        superGame.setOnClickListener(v -> {
            ((App)getApplication()).startNewGame();
            startActivity(new Intent(this, SuperGameActivity.class));
        });

        Button fiftyfifty = findViewById(R.id.fiftyfiftyGameBtn);
        fiftyfifty.setOnClickListener(v -> {
            Intent intent = new Intent(this, FiftyFiftyGame.class);
            startActivity(intent);
        });

        Button rules = findViewById(R.id.rulesBtn);
        rules.setOnClickListener(v -> {
            Intent intent = new Intent(this, RulesActivity.class);
            startActivity(intent);
        });

        Button statistic = findViewById(R.id.statisticsBtn);
        statistic.setOnClickListener(v -> {
            Intent intent = new Intent(this, StatistikActivity.class);
            startActivity(intent);
        });
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Resources res = getResources();
        Configuration config = res.getConfiguration();
        config.setLocale(locale);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLayoutDirection(locale);
            createConfigurationContext(config);
        }

        res.updateConfiguration(config, res.getDisplayMetrics());
        updateUI();
    }

    private void updateUI() {
        ((Button)findViewById(R.id.onePlayerBtn)).setText(R.string.single_player);
        ((Button)findViewById(R.id.twoPlayerBtn)).setText(R.string.two_players);
        ((Button)findViewById(R.id.superGameBtn)).setText(R.string.super_game);
        ((Button)findViewById(R.id.exit)).setText(R.string.exit);
        ((Button)findViewById(R.id.rulesBtn)).setText(R.string.rules);
        ((Button)findViewById(R.id.statisticsBtn)).setText(R.string.statistics);
        ((Button)findViewById(R.id.fiftyfiftyGameBtn)).setText(R.string.fiftyfifty);

        //((Button)findViewById(R.id.deathNumText)).setText(R.string.death_numone);

        // Обновляем другие текстовые элементы, если они есть
        //((TextView)findViewById(R.id.textView)).setText(R.string.some_text);
    }
}