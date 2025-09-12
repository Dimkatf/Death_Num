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

public class MainActivity extends BaseActivity {
    private Spinner languageSpinner;

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

        // Устанавливаем правильную позицию спиннера based on current language
        if (App.getLanguage().equals("en")) {
            languageSpinner.setSelection(1);
        } else {
            languageSpinner.setSelection(0);
        }

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLang = (position == 1) ? "en" : "ru";
                if (!selectedLang.equals(App.getLanguage())) {
                    setLocale(selectedLang);
                }
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
        App.setLanguage(lang);
        recreate(); // Перезагружаем активность для применения языка
    }

    private void updateUI() {
        Button onePlayer = findViewById(R.id.onePlayerBtn);
        Button twoPlayer = findViewById(R.id.twoPlayerBtn);
        Button superGame = findViewById(R.id.superGameBtn);
        Button exit = findViewById(R.id.exit);
        Button rules = findViewById(R.id.rulesBtn);
        Button statistics = findViewById(R.id.statisticsBtn);
        Button fiftyfifty = findViewById(R.id.fiftyfiftyGameBtn);

        onePlayer.setText(R.string.single_player);
        twoPlayer.setText(R.string.two_players);
        superGame.setText(R.string.super_game);
        exit.setText(R.string.exit);
        rules.setText(R.string.rules);
        statistics.setText(R.string.statistics);
        fiftyfifty.setText(R.string.fiftyfifty);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Обновляем UI при возвращении на активность
        updateUI();

        // Обновляем позицию спиннера на случай, если язык изменился в другой активности
        if (App.getLanguage().equals("en")) {
            languageSpinner.setSelection(1);
        } else {
            languageSpinner.setSelection(0);
        }
    }
}