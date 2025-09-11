package com.example.deathnum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameOverTwoPlayers extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.gameovertwoplayers);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loseTwoPlayers), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button exit = findViewById(R.id.exitBtnTwoPlayer);
        exit.setOnClickListener(v ->{
            Intent intent = new Intent(GameOverTwoPlayers.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
        TextView result = findViewById(R.id.resultsTwoPlayers);
        int res1 = TwoPlayerActivity.countTwo1;
        int res2 = TwoPlayer2Activity.countTwo2;
        result.setText("Игрок 1 " + res1 + " : " + res2 + " Игрок 2");
        TextView wins = findViewById(R.id.winsTextview);
        if (res1 > res2)
          wins.setText("Игрок 1 выиграл!");
        else if(res1 == res2)
            wins.setText("Ничья!");
        else wins.setText("Игрок 2 выиграл!");
    }
}
