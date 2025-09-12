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

import com.example.deathnum.database.DatabaseConstants;
import com.example.deathnum.database.StatsDatabaseManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FiftyFiftyGame extends BaseActivity {
    StatsDatabaseManager dbManager;
    public static int countFifty;
    public Button card1Fifty;
    public Button card2Fifty;
    private ArrayList<String> cards = new ArrayList<>();
    Time time = new Time();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.fiftyfiftygame);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fiftyfifty), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button exit = findViewById(R.id.exitFiftyfifty);
        exit.setOnClickListener(v -> finish());
        countFifty = 0;
        TextView countfiftyTextView = findViewById(R.id.countFiftyFifty);
        countfiftyTextView.setText(getString(R.string.pointsFiftyFifty) + " " +countFifty);

        dbManager = new StatsDatabaseManager(this);
        dbManager.open();

        dbManager.incrementModeCount(DatabaseConstants.MODE_FIFTY_FIFTY);

        card1Fifty = findViewById(R.id.card1FiftyFifty);
        card2Fifty = findViewById(R.id.card2FiftyFifty);

        setupNewRound();
        card1Fifty.setOnClickListener(v -> {
            time.time(500l);
            try {
                checkCard(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        card2Fifty.setOnClickListener(v -> {
            time.time(500l);
            try {
                checkCard(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void setupNewRound() {
        cards.clear();
        cards.add("✅");
        cards.add("❌");

        Collections.shuffle(cards);

        card1Fifty.setText("Death Num");
        card2Fifty.setText("Death Num");
    }

    private void checkCard(int cardIndex) throws InterruptedException {
        if (card1Fifty.getText().toString().equals("Death Num") &&
                card2Fifty.getText().toString().equals("Death Num")) {

            if (cardIndex == 0) {
                card1Fifty.setText(String.valueOf(cards.get(0)));
            } else {
                card2Fifty.setText(String.valueOf(cards.get(1)));
            }

            if (cards.get(cardIndex) == "✅") {
                countFifty++;
                TextView countfiftyTextView = findViewById(R.id.countFiftyFifty);
                countfiftyTextView.setText(getString(R.string.pointsFiftyFifty) + " " +countFifty);
                card1Fifty.postDelayed(this::setupNewRound, 2000);
            }
            else {
                dbManager.saveGameScore(DatabaseConstants.MODE_FIFTY_FIFTY, countFifty);
                Intent intent = new Intent(this, FiftyFiftyGameOver.class);
                startActivity(intent);
            }
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        dbManager.close();
    }

}
