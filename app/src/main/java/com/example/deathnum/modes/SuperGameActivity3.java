package com.example.deathnum.modes;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.deathnum.help_classes.App;
import com.example.deathnum.sreens_lose.GameOverSuperGame;
import com.example.deathnum.R;
import com.example.deathnum.help_classes.Time;

import java.util.ArrayList;
import java.util.Random;

public class SuperGameActivity3 extends AppCompatActivity {
    private int deathNumSuper3;
    private Random random = new Random();
    private TextView deathNumText3;
    private Button nextRound3;
    private TextView countTextSuper3;
    private static final int COUNT_CARDS = 6;
    private static final int POINTS = 3;
    private Button gameOver3Btn;
    private ArrayList<Integer> numsSuper3 = new ArrayList<>();

    private RelativeLayout roundOverlay;
    private TextView roundNumberText;
    private Animation slideUpAnimation, slideDownAnimation, pulseAnimation;
    Time time = new Time();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.supergame3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.supergame_3), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.text_pulse);

        roundOverlay = findViewById(R.id.roundforsuper);
        roundNumberText = findViewById(R.id.roundText);

        App app = (App) getApplication();

        gameOver3Btn = findViewById(R.id.gameOverSuper3);
        gameOver3Btn.setOnClickListener(v -> {
            Intent intent = new Intent(SuperGameActivity3.this, GameOverSuperGame.class);
            startActivity(intent);
            finish();
        });

        deathNumSuper3 = random.nextInt(COUNT_CARDS)+1;

        nextRound3 = findViewById(R.id.nextRound3);
        nextRound3.setEnabled(false);
        nextRound3.setOnClickListener(v -> {
            Intent intent = new Intent(SuperGameActivity3.this, SuperGameActivity4.class);
            startActivity(intent);
            finish();
        });

        deathNumText3 = findViewById(R.id.deathNumTextforSuper3);
        deathNumText3.setText(getString(R.string.deathnum) + " " + app.getGlobalcount());


        countTextSuper3 = findViewById(R.id.countSuper3);
        countTextSuper3.setText(getString(R.string.Points) + " " + app.getGlobalcount());

        Button card1Super3 = findViewById(R.id.card1Super3);
        Button card2Super3 = findViewById(R.id.card2Super3);
        Button card3Super3 = findViewById(R.id.card3Super3);
        Button card4Super3 = findViewById(R.id.card4Super3);
        Button card5Super3 = findViewById(R.id.card5Super3);
        Button card6Super3 = findViewById(R.id.card6Super3);


        numsSuper3.add(1); numsSuper3.add(2); numsSuper3.add(3);
        numsSuper3.add(4);numsSuper3.add(5);numsSuper3.add(6);


        int randIndex1Super3 = random.nextInt(numsSuper3.size());
        int num1Super3 = numsSuper3.get(randIndex1Super3);
        numsSuper3.remove(randIndex1Super3);

        int randIndex2Super3 = random.nextInt(numsSuper3.size());
        int num2Super3 = numsSuper3.get(randIndex2Super3);
        numsSuper3.remove(randIndex2Super3);

        int randIndex3Super3 = random.nextInt(numsSuper3.size());
        int num3Super3 = numsSuper3.get(randIndex3Super3);
        numsSuper3.remove(randIndex3Super3);

        int randIndex4Super3 = random.nextInt(numsSuper3.size());
        int num4Super3 = numsSuper3.get(randIndex4Super3);
        numsSuper3.remove(randIndex4Super3);

        int randIndex5Super3 = random.nextInt(numsSuper3.size());
        int num5Super3 = numsSuper3.get(randIndex5Super3);
        numsSuper3.remove(randIndex5Super3);

        int randIndex6Super3 = random.nextInt(numsSuper3.size());
        int num6Super3 = numsSuper3.get(randIndex6Super3);
        numsSuper3.remove(randIndex6Super3);



        card1Super3.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num1Super3);
            score(num1Super3);
            card1Super3.setEnabled(false);
            card1Super3.setText(String.valueOf(num1Super3));
            card1Super3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card2Super3.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num2Super3);
            score(num2Super3);
            card2Super3.setEnabled(false);
            card2Super3.setText(String.valueOf(num2Super3));
            card2Super3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card3Super3.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num3Super3);
            score(num3Super3);
            card3Super3.setEnabled(false);
            card3Super3.setText(String.valueOf(num3Super3));
            card3Super3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card4Super3.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num4Super3);
            score(num4Super3);
            card4Super3.setEnabled(false);
            card4Super3.setText(String.valueOf(num4Super3));
            card4Super3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card5Super3.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num5Super3);
            score(num5Super3);
            card5Super3.setEnabled(false);
            card5Super3.setText(String.valueOf(num5Super3));
            card5Super3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card6Super3.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num6Super3);
            score(num6Super3);
            card6Super3.setEnabled(false);
            card6Super3.setText(String.valueOf(num6Super3));
            card6Super3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });

        showRound();


    }
    private void score(int numSuper3){
        App app = (App) getApplication();
        if(numSuper3 != deathNumSuper3) {
            app.setGlobalcount(app.getGlobalcount() + POINTS);
            countTextSuper3.setText(getString(R.string.Points) + " " + app.getGlobalcount());
        }
        else {
            app.setGlobalcount(0);
            countTextSuper3.setText(getString(R.string.Points) + " " + app.getGlobalcount());
            Intent intent = new Intent(SuperGameActivity3.this, GameOverSuperGame.class);
            startActivity(intent);
        }
    }
    private void activateNextRound(int num){
        if(num != deathNumSuper3){
            nextRound3.setEnabled(true);
            nextRound3.setBackgroundColor(Color.GREEN);
        }
    }
    private void showRound() {
        // Блокируем взаимодействие во время анимации
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        );

        roundNumberText.setText("РАУНД 3");

        roundOverlay.setVisibility(View.VISIBLE);
        roundNumberText.setVisibility(View.VISIBLE);

        roundOverlay.startAnimation(slideUpAnimation);
        roundNumberText.startAnimation(pulseAnimation);

        new Handler().postDelayed(() -> {
            roundOverlay.startAnimation(slideDownAnimation);
            roundOverlay.postDelayed(() -> {
                roundOverlay.setVisibility(View.GONE);
                roundNumberText.clearAnimation();

                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }, 800);
        }, 3000);
    }
}
