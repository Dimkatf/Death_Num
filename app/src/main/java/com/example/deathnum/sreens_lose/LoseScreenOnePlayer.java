package com.example.deathnum.sreens_lose;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.deathnum.help_classes.BaseActivity;
import com.example.deathnum.MainActivity;
import com.example.deathnum.R;
import com.example.deathnum.modes.OnePlayerActivity;

public class LoseScreenOnePlayer extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.losescreenoneplayer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.loseone), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button seeRes = findViewById(R.id.seeResult);
        seeRes.setOnClickListener(v -> finish());

        Button exit = findViewById(R.id.exitBtnOnePlayer);
        exit.setOnClickListener(v -> {
            Intent intent = new Intent(LoseScreenOnePlayer.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        int count = OnePlayerActivity.count;
        TextView countText = findViewById(R.id.countForGameOver);
        String counts = String.valueOf(count);
        countText.setText(counts);

    }
}
