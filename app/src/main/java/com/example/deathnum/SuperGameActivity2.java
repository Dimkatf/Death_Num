package com.example.deathnum;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
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
import java.util.Random;

public class SuperGameActivity2 extends AppCompatActivity {
    Time time = new Time();
    StatsDatabaseManager dbManager;
    private int deathNumSuper2;
    private Random random = new Random();
    private TextView deathNumText2;
    private Button nextRound2;
    private TextView countTextSuper2;
    private static final int COUNT_CARDS = 8;
    private static final int POINTS = 2;
    private ArrayList<Integer> numsSuper2 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.supergame2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.supergame_2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        dbManager = new StatsDatabaseManager(this);
        dbManager.open();
        deathNumSuper2 = random.nextInt(COUNT_CARDS)+1;

        nextRound2 = findViewById(R.id.nextRound2);
        nextRound2.setEnabled(false);
        nextRound2.setOnClickListener(v -> {
            Intent intent = new Intent(SuperGameActivity2.this, SuperGameActivity3.class);
            startActivity(intent);
            finish();
        });

        App app = (App) getApplication();

        deathNumText2 = findViewById(R.id.deathNumTextforSuper2);
        deathNumText2.setText("Смертельное число: " + deathNumSuper2);

        //countSuper2 = SuperGameActivity.countSuper;

        countTextSuper2 = findViewById(R.id.countSuper2);
        countTextSuper2.setText("Количество баллов: " + app.getGlobalcount());

        Button card1Super2 = findViewById(R.id.card1Super2);
        Button card2Super2 = findViewById(R.id.card2Super2);
        Button card3Super2 = findViewById(R.id.card3Super2);
        Button card4Super2 = findViewById(R.id.card4Super2);
        Button card5Super2 = findViewById(R.id.card5Super2);
        Button card6Super2 = findViewById(R.id.card6Super2);
        Button card7Super2 = findViewById(R.id.card7Super2);
        Button card8Super2 = findViewById(R.id.card8Super2);

        numsSuper2.add(1); numsSuper2.add(2); numsSuper2.add(3);
        numsSuper2.add(4);numsSuper2.add(5);numsSuper2.add(6);
        numsSuper2.add(7);numsSuper2.add(8);

        int randIndex1Super2 = random.nextInt(numsSuper2.size());
        int num1Super2 = numsSuper2.get(randIndex1Super2);
        numsSuper2.remove(randIndex1Super2);

        int randIndex2Super2 = random.nextInt(numsSuper2.size());
        int num2Super2 = numsSuper2.get(randIndex2Super2);
        numsSuper2.remove(randIndex2Super2);

        int randIndex3Super2 = random.nextInt(numsSuper2.size());
        int num3Super2 = numsSuper2.get(randIndex3Super2);
        numsSuper2.remove(randIndex3Super2);

        int randIndex4Super2 = random.nextInt(numsSuper2.size());
        int num4Super2 = numsSuper2.get(randIndex4Super2);
        numsSuper2.remove(randIndex4Super2);

        int randIndex5Super2 = random.nextInt(numsSuper2.size());
        int num5Super2 = numsSuper2.get(randIndex5Super2);
        numsSuper2.remove(randIndex5Super2);

        int randIndex6Super2 = random.nextInt(numsSuper2.size());
        int num6Super2 = numsSuper2.get(randIndex6Super2);
        numsSuper2.remove(randIndex6Super2);

        int randIndex7Super2 = random.nextInt(numsSuper2.size());
        int num7Super2 = numsSuper2.get(randIndex7Super2);
        numsSuper2.remove(randIndex7Super2);

        int randIndex8Super2 = random.nextInt(numsSuper2.size());
        int num8Super2 = numsSuper2.get(randIndex8Super2);
        numsSuper2.remove(randIndex8Super2);


        card1Super2.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num1Super2);
            score(num1Super2);
            card1Super2.setEnabled(false);
            card1Super2.setText(String.valueOf(num1Super2));
            card1Super2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card2Super2.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num2Super2);
            score(num2Super2);
            card2Super2.setEnabled(false);
            card2Super2.setText(String.valueOf(num2Super2));
            card2Super2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card3Super2.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num3Super2);
            score(num3Super2);
            card3Super2.setEnabled(false);
            card3Super2.setText(String.valueOf(num3Super2));
            card3Super2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card4Super2.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num4Super2);
            score(num4Super2);
            card4Super2.setEnabled(false);
            card4Super2.setText(String.valueOf(num4Super2));
            card4Super2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card5Super2.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num5Super2);
            score(num5Super2);
            card5Super2.setEnabled(false);
            card5Super2.setText(String.valueOf(num5Super2));
            card5Super2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card6Super2.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num6Super2);
            score(num6Super2);
            card6Super2.setEnabled(false);
            card6Super2.setText(String.valueOf(num6Super2));
            card6Super2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card7Super2.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num7Super2);
            score(num7Super2);
            card7Super2.setEnabled(false);
            card7Super2.setText(String.valueOf(num7Super2));
            card7Super2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card8Super2.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num8Super2);
            score(num8Super2);
            card8Super2.setEnabled(false);
            card8Super2.setText(String.valueOf(num8Super2));
            card8Super2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        });

    }
    private void score(int numSuper1){
        App app = (App) getApplication();
        if(numSuper1 != deathNumSuper2) {
            app.setGlobalcount(app.getGlobalcount() + POINTS);
            countTextSuper2.setText("Количество баллов: " + app.getGlobalcount());
        }
        else {
            app.setGlobalcount(0);
            countTextSuper2.setText("Количество баллов: " + app.getGlobalcount());
            Intent intent = new Intent(SuperGameActivity2.this, GameOverSuperGame.class);
            startActivity(intent);
        }
    }
    private void activateNextRound(int num){
        if(num != deathNumSuper2){
            nextRound2.setEnabled(true);
            nextRound2.setBackgroundColor(Color.GREEN);
        }
    }
}

