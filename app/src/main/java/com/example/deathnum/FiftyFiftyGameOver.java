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

public class FiftyFiftyGameOver extends AppCompatActivity {
    Button exit;
    TextView countText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fiftyfiftygameover);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fiftyfiftygameovid), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        exit = findViewById(R.id.exitFiftyfiftygameover);
        exit.setOnClickListener(v ->
        {
            finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        countText = findViewById(R.id.countFiftyFiftyGameOver);
        countText.setText(String.valueOf(FiftyFiftyGame.countFifty));
    }
}
