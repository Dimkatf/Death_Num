package com.example.deathnum;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.deathnum.database.DatabaseConstants;
import com.example.deathnum.database.StatsDatabaseManager;

public class StatistikActivity extends AppCompatActivity {
    StatsDatabaseManager dbManager;
    TextView statsOnePlCountGames;
    TextView statsLastScores;
    Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.statistik_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.statistic), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        exitBtn = findViewById(R.id.exitStats);
        exitBtn.setOnClickListener(v -> finish());

        dbManager = new StatsDatabaseManager(this);
        dbManager.open();

        statsOnePlCountGames = findViewById(R.id.statsOnePlayerCountGames);
        statsLastScores = findViewById(R.id.LastResstats);

        updateUI();
    }

    private void updateUI() {
        //exitBtn.setText(App.getLanguage().equals("en") ? "Exit" : "Выход");
        displayStatistics();
        displayScores();
    }

    private void displayStatistics() {
        StringBuilder stats = new StringBuilder();

        int onePlayer = dbManager.getModeCount(DatabaseConstants.MODE_ONE_PLAYER);
        int twoPlayers = dbManager.getModeCount(DatabaseConstants.MODE_TWO_PLAYERS);
        int superGame = dbManager.getModeCount(DatabaseConstants.MODE_SUPER_GAME);
        int fiftyFifty = dbManager.getModeCount(DatabaseConstants.MODE_FIFTY_FIFTY);

        if (App.getLanguage().equals("en")) {
            stats.append("One Player: ").append(onePlayer).append("\n");
            stats.append("Two Players: ").append(twoPlayers).append("\n");
            stats.append("Super Game: ").append(superGame).append("\n");
            stats.append("Fifty-Fifty: ").append(fiftyFifty).append("\n");
        } else {
            stats.append("Один игрок: ").append(onePlayer).append("\n");
            stats.append("Два игрока: ").append(twoPlayers).append("\n");
            stats.append("Суперигра: ").append(superGame).append("\n");
            stats.append("50 на 50: ").append(fiftyFifty).append("\n");
        }

        statsOnePlCountGames.setText(stats.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.close();
    }

    private void displayScores() {
        StringBuilder scores = new StringBuilder();

        int lastOnePlayer = dbManager.getLastScore(DatabaseConstants.MODE_ONE_PLAYER);
        int bestOnePlayer = dbManager.getBestScore(DatabaseConstants.MODE_ONE_PLAYER);

        int lastSuperGame = dbManager.getLastScore(DatabaseConstants.MODE_SUPER_GAME);
        int bestSuperGame = dbManager.getBestScore(DatabaseConstants.MODE_SUPER_GAME);

        int lastFiftyFifty = dbManager.getLastScore(DatabaseConstants.MODE_FIFTY_FIFTY);
        int bestFiftyFifty = dbManager.getBestScore(DatabaseConstants.MODE_FIFTY_FIFTY);

        if (App.getLanguage().equals("en")) {
            scores.append("One Player:\n");
            scores.append("  Last: ").append(lastOnePlayer).append("\n");
            scores.append("  Best: ").append(bestOnePlayer).append("\n\n");

            scores.append("Super Game:\n");
            scores.append("  Last: ").append(lastSuperGame).append("\n");
            scores.append("  Best: ").append(bestSuperGame).append("\n\n");

            scores.append("Fifty-Fifty:\n");
            scores.append("  Last: ").append(lastFiftyFifty).append("\n");
            scores.append("  Best: ").append(bestFiftyFifty).append("\n");
        } else {
            scores.append("Один игрок:\n");
            scores.append("  Последний: ").append(lastOnePlayer).append("\n");
            scores.append("  Лучший: ").append(bestOnePlayer).append("\n\n");

            scores.append("Суперигра:\n");
            scores.append("  Последний: ").append(lastSuperGame).append("\n");
            scores.append("  Лучший: ").append(bestSuperGame).append("\n\n");

            scores.append("50 на 50:\n");
            scores.append("  Последний: ").append(lastFiftyFifty).append("\n");
            scores.append("  Лучший: ").append(bestFiftyFifty).append("\n");
        }

        statsLastScores.setText(scores.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }
}

