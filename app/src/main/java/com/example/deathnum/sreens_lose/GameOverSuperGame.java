package com.example.deathnum.sreens_lose;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.deathnum.help_classes.App;
import com.example.deathnum.MainActivity;
import com.example.deathnum.R;
import com.example.deathnum.database.DatabaseConstants;
import com.example.deathnum.database.StatsDatabaseManager;

public class GameOverSuperGame extends AppCompatActivity {

    StatsDatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.gameoversupergame);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.gosupergame), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbManager = new StatsDatabaseManager(this);
        dbManager.open();

        Button exit = findViewById(R.id.exitBtnOnePlayerSuper);
        exit.setOnClickListener(v -> {
            Intent intent = new Intent(GameOverSuperGame.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        App app = (App) getApplication();
        int finalScore = app.getGlobalcount();

        dbManager.saveGameScore(DatabaseConstants.MODE_SUPER_GAME, finalScore);

        TextView counts = findViewById(R.id.countForGameOverSuper);
        counts.setText(String.valueOf(finalScore));
        app.startNewGame();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbManager != null) {
            dbManager.close();
        }
    }
}
