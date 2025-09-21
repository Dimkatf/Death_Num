package com.example.deathnum.modes;

import android.content.Intent;
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
import com.example.deathnum.database.DatabaseConstants;
import com.example.deathnum.database.StatsDatabaseManager;

import java.util.ArrayList;
import java.util.Random;

public class SuperGameActivity5 extends AppCompatActivity {
    StatsDatabaseManager dbManager;
    private int deathNumSuper5;
    private Random random = new Random();
    private TextView deathNumText5;
    private Button gameOver5;
    private static final int COUNT_CARDS = 2;
    private static final int POINTS = 5;
    private TextView countTextSuper5;
    Time time = new Time();
    private ArrayList<Integer> numsSuper5 = new ArrayList<>();
    private RelativeLayout roundOverlay;
    private TextView roundNumberText;
    private Animation slideUpAnimation, slideDownAnimation, pulseAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.supergame5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.supergame_5), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.text_pulse);

        roundOverlay = findViewById(R.id.roundforsuper);
        roundNumberText = findViewById(R.id.roundText);

        dbManager = new StatsDatabaseManager(this);
        dbManager.open();

        dbManager.incrementModeCount(DatabaseConstants.MODE_SUPER_GAME);
        deathNumSuper5 = random.nextInt(COUNT_CARDS)+1;

        gameOver5 = findViewById(R.id.gameOver5);
        gameOver5.setOnClickListener(v -> {
            Intent intent = new Intent(SuperGameActivity5.this, GameOverSuperGame.class);
            startActivity(intent);
            finish();
        });

        App app = (App) getApplication();

        deathNumText5 = findViewById(R.id.deathNumTextforSuper5);
        deathNumText5.setText(getString(R.string.deathnum) + " " + app.getGlobalcount());


        countTextSuper5 = findViewById(R.id.countSuper5);
        countTextSuper5.setText(getString(R.string.Points) + " " + app.getGlobalcount());

        Button card1Super5 = findViewById(R.id.card1Super5);
        Button card2Super5 = findViewById(R.id.card2Super5);

        numsSuper5.add(1); numsSuper5.add(2);


        int randIndex1Super5 = random.nextInt(numsSuper5.size());
        int num1Super5 = numsSuper5.get(randIndex1Super5);
        numsSuper5.remove(randIndex1Super5);

        int randIndex2Super5 = random.nextInt(numsSuper5.size());
        int num2Super5 = numsSuper5.get(randIndex2Super5);
        numsSuper5.remove(randIndex2Super5);

        card1Super5.setOnClickListener(v -> {
            time.time(800l);
            score(num1Super5);
            card1Super5.setEnabled(false);
            card1Super5.setText(String.valueOf(num1Super5));
            card1Super5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card2Super5.setOnClickListener(v -> {
            time.time(800l);
            score(num2Super5);
            card2Super5.setEnabled(false);
            card2Super5.setText(String.valueOf(num2Super5));
            card2Super5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });

        showRound();

    }
    private void score(int numSuper5){
        App app = (App) getApplication();
        if(numSuper5 != deathNumSuper5) {
            app.setGlobalcount(app.getGlobalcount() + POINTS);
            countTextSuper5.setText(getString(R.string.Points) + " " + app.getGlobalcount());
        }
        else {
            app.setGlobalcount(0);
            countTextSuper5.setText(getString(R.string.Points) + " " + app.getGlobalcount());
            Intent intent = new Intent(SuperGameActivity5.this, GameOverSuperGame.class);
            startActivity(intent);
        }
    }
    private void showRound() {
        // Блокируем взаимодействие во время анимации
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        );

        roundNumberText.setText("РАУНД 5. Последний!");

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
