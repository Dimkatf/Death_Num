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
import android.widget.FrameLayout;
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
import com.example.deathnum.database.StatsDatabaseManager;

import java.util.ArrayList;
import java.util.Random;

public class SuperGameActivity4 extends AppCompatActivity {
    private int deathNumSuper4;
    StatsDatabaseManager dbManager;
    private Random random = new Random();
    private TextView deathNumText4;
    private Button nextRound4;
    private static final int COUNT_CARDS = 4;
    private static final int POINTS = 4;
    private TextView countTextSuper4;
    private Button gameOver4Btn;
    private ArrayList<Integer> numsSuper4 = new ArrayList<>();
    Time time = new Time();

    private RelativeLayout roundOverlay;
    private TextView roundNumberText;
    private Animation slideUpAnimation, slideDownAnimation, pulseAnimation;

    private FrameLayout centerPlusOneContainer;
    private TextView centerPlusOneText;
    private Animation rotateInAnimation, fadeOutAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.supergame4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.supergame_4), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.text_pulse);

        roundOverlay = findViewById(R.id.roundforsuper);
        roundNumberText = findViewById(R.id.roundText);

        centerPlusOneContainer = findViewById(R.id.centerPlusOneContainer);
        centerPlusOneText = findViewById(R.id.centerPlusOneText);

        rotateInAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_in);
        fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        deathNumSuper4 = random.nextInt(COUNT_CARDS)+1;

        App app = (App) getApplication();

        gameOver4Btn = findViewById(R.id.gameOverSuper4);
        gameOver4Btn.setOnClickListener(v -> {
            Intent intent = new Intent(SuperGameActivity4.this, GameOverSuperGame.class);
            startActivity(intent);
            finish();
        });

        nextRound4 = findViewById(R.id.nextRound4);
        nextRound4.setEnabled(false);
        nextRound4.setOnClickListener(v -> {
            Intent intent = new Intent(SuperGameActivity4.this, SuperGameActivity5.class);
            startActivity(intent);
            finish();
        });

        deathNumText4 = findViewById(R.id.deathNumTextforSuper4);
        deathNumText4.setText(getString(R.string.deathnum) + " " + deathNumSuper4);

        countTextSuper4 = findViewById(R.id.countSuper4);
        countTextSuper4.setText(getString(R.string.Points) + " " + app.getGlobalcount());

        Button card1Super4 = findViewById(R.id.card1Super4);
        Button card2Super4 = findViewById(R.id.card2Super4);
        Button card3Super4 = findViewById(R.id.card3Super4);
        Button card4Super4 = findViewById(R.id.card4Super4);


        numsSuper4.add(1); numsSuper4.add(2);
        numsSuper4.add(3);numsSuper4.add(4);

        int randIndex1Super4 = random.nextInt(numsSuper4.size());
        int num1Super4 = numsSuper4.get(randIndex1Super4);
        numsSuper4.remove(randIndex1Super4);

        int randIndex2Super4 = random.nextInt(numsSuper4.size());
        int num2Super4 = numsSuper4.get(randIndex2Super4);
        numsSuper4.remove(randIndex2Super4);

        int randIndex3Super4 = random.nextInt(numsSuper4.size());
        int num3Super4 = numsSuper4.get(randIndex3Super4);
        numsSuper4.remove(randIndex3Super4);

        int randIndex4Super4 = random.nextInt(numsSuper4.size());
        int num4Super4 = numsSuper4.get(randIndex4Super4);
        numsSuper4.remove(randIndex4Super4);



        card1Super4.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num1Super4);
            score(num1Super4);
            card1Super4.setEnabled(false);
            card1Super4.setText(String.valueOf(num1Super4));
            card1Super4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card2Super4.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num2Super4);
            score(num2Super4);
            card2Super4.setEnabled(false);
            card2Super4.setText(String.valueOf(num2Super4));
            card2Super4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card3Super4.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num3Super4);
            score(num3Super4);
            card3Super4.setEnabled(false);
            card3Super4.setText(String.valueOf(num3Super4));
            card3Super4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card4Super4.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num4Super4);
            score(num4Super4);
            card4Super4.setEnabled(false);
            card4Super4.setText(String.valueOf(num4Super4));
            card4Super4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });

        showRound();

    }
    private void score(int numSuper4){
        App app = (App) getApplication();
        if(numSuper4 != deathNumSuper4) {
            app.setGlobalcount(app.getGlobalcount()+ POINTS);
            countTextSuper4.setText(getString(R.string.Points) + " " + app.getGlobalcount());
            showCenterPlusOneAnimation();
        }
        else {
            app.setGlobalcount(0);
            countTextSuper4.setText(getString(R.string.Points) + " " + app.getGlobalcount());
            Intent intent = new Intent(SuperGameActivity4.this, GameOverSuperGame.class);
            startActivity(intent);
            finish();
        }
    }
    private void activateNextRound(int num){
        if(num != deathNumSuper4){
            nextRound4.setEnabled(true);
            nextRound4.setBackgroundColor(Color.GREEN);
        }
    }
    private void showRound() {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        );

        roundNumberText.setText("РАУНД 4");

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

    private void showCenterPlusOneAnimation() {
        //setAllCardsEnabled(false);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        );
        centerPlusOneContainer.setVisibility(View.VISIBLE);
        centerPlusOneText.setText("+4");
        centerPlusOneText.setAlpha(1.0f);
        centerPlusOneText.setVisibility(View.VISIBLE);
        centerPlusOneText.clearAnimation();
        centerPlusOneText.startAnimation(rotateInAnimation);

        new Handler().postDelayed(() -> {
            new Handler().postDelayed(() -> {
                centerPlusOneText.startAnimation(fadeOutAnimation);

                new Handler().postDelayed(() -> {
                    centerPlusOneContainer.setVisibility(View.INVISIBLE);
                    centerPlusOneText.clearAnimation();
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                    //setAllCardsEnabled(true);
                }, 500);
            }, 2000);
        }, 900);
    }
}
