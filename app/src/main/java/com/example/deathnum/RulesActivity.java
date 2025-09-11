package com.example.deathnum;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.io.InputStream;

public class RulesActivity extends AppCompatActivity {
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_activity);

        TextView textView = findViewById(R.id.textView);
        textView.setText(loadTextFromFile());
        exit = findViewById(R.id.exitRules);
        exit.setOnClickListener(v -> finish());
    }

    private String loadTextFromFile() {
        try {
            InputStream is = getAssets().open("rules.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return new String(buffer);
        } catch (IOException e) {
            return "Не удалось загрузить текст";
        }
    }
}