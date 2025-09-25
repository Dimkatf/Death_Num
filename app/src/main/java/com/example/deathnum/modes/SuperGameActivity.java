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
import com.example.deathnum.database.DatabaseConstants;
import com.example.deathnum.database.StatsDatabaseManager;

import java.util.ArrayList;
import java.util.Random;

public class SuperGameActivity extends AppCompatActivity {
    private int deathNumSuper1;
    StatsDatabaseManager dbManager;
    private Random random = new Random();
    private TextView deathNumText;
    private Button nextRound;
    private TextView countTextSuper1;
    private static final int COUNT_CARDS = 10;
    private static final int POINTS = 1;

    private ArrayList<Integer> numsSuper1 = new ArrayList<>();
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
        setContentView(R.layout.supergame_activity1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.supergame), (v, insets) -> {
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

        centerPlusOneContainer = findViewById(R.id.centerPlusOneContainer);
        centerPlusOneText = findViewById(R.id.centerPlusOneText);

        rotateInAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_in);
        fadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        App app = (App) getApplication();

        Button exit = findViewById(R.id.exitSuper);
        exit.setOnClickListener(v -> finish());
        deathNumSuper1 = random.nextInt(COUNT_CARDS)+1;

        nextRound = findViewById(R.id.nextRound1);
        nextRound.setEnabled(false);
        nextRound.setOnClickListener(v -> {
            Intent intent = new Intent(SuperGameActivity.this, SuperGameActivity2.class);
            startActivity(intent);
        });

        deathNumText = findViewById(R.id.deathNumTextforSuper);
        deathNumText.setText(getString(R.string.deathnum) + " " + deathNumSuper1);

        countTextSuper1 = findViewById(R.id.countSuper);
        countTextSuper1.setText(getString(R.string.Points) + " " + app.getGlobalcount());

        Button card1Super1 = findViewById(R.id.card1Super1);
        Button card2Super1 = findViewById(R.id.card2Super1);
        Button card3Super1 = findViewById(R.id.card3Super1);
        Button card4Super1 = findViewById(R.id.card4Super1);
        Button card5Super1 = findViewById(R.id.card5Super1);
        Button card6Super1 = findViewById(R.id.card6Super1);
        Button card7Super1 = findViewById(R.id.card7Super1);
        Button card8Super1 = findViewById(R.id.card8Super1);
        Button card9Super1 = findViewById(R.id.card9Super1);
        Button card10Super1 = findViewById(R.id.card10Super1);

        numsSuper1.add(1); numsSuper1.add(2); numsSuper1.add(3);
        numsSuper1.add(4);numsSuper1.add(5);numsSuper1.add(6);
        numsSuper1.add(7);numsSuper1.add(8);numsSuper1.add(9);
        numsSuper1.add(10);

        int randIndex1Super1 = random.nextInt(numsSuper1.size());
        int num1Super1 = numsSuper1.get(randIndex1Super1);
        numsSuper1.remove(randIndex1Super1);

        int randIndex2Super1 = random.nextInt(numsSuper1.size());
        int num2Super1 = numsSuper1.get(randIndex2Super1);
        numsSuper1.remove(randIndex2Super1);

        int randIndex3Super1 = random.nextInt(numsSuper1.size());
        int num3Super1 = numsSuper1.get(randIndex3Super1);
        numsSuper1.remove(randIndex3Super1);

        int randIndex4Super1 = random.nextInt(numsSuper1.size());
        int num4Super1 = numsSuper1.get(randIndex4Super1);
        numsSuper1.remove(randIndex4Super1);

        int randIndex5Super1 = random.nextInt(numsSuper1.size());
        int num5Super1 = numsSuper1.get(randIndex5Super1);
        numsSuper1.remove(randIndex5Super1);

        int randIndex6Super1 = random.nextInt(numsSuper1.size());
        int num6Super1 = numsSuper1.get(randIndex6Super1);
        numsSuper1.remove(randIndex6Super1);

        int randIndex7Super1 = random.nextInt(numsSuper1.size());
        int num7Super1 = numsSuper1.get(randIndex7Super1);
        numsSuper1.remove(randIndex7Super1);

        int randIndex8Super1 = random.nextInt(numsSuper1.size());
        int num8Super1 = numsSuper1.get(randIndex8Super1);
        numsSuper1.remove(randIndex8Super1);

        int randIndex9Super1 = random.nextInt(numsSuper1.size());
        int num9Super1 = numsSuper1.get(randIndex9Super1);
        numsSuper1.remove(randIndex9Super1);

        int randIndex10Super1 = random.nextInt(numsSuper1.size());
        int num10Super1 = numsSuper1.get(randIndex10Super1);
        numsSuper1.remove(randIndex10Super1);

        card1Super1.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num1Super1);
            score(num1Super1);
            card1Super1.setEnabled(false);
            card1Super1.setText(String.valueOf(num1Super1));
            card1Super1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card2Super1.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num2Super1);
            score(num2Super1);
            card2Super1.setEnabled(false);
            card2Super1.setText(String.valueOf(num2Super1));
            card2Super1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card3Super1.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num3Super1);
            score(num3Super1);
            card3Super1.setEnabled(false);
            card3Super1.setText(String.valueOf(num3Super1));
            card3Super1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card4Super1.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num4Super1);
            score(num4Super1);
            card4Super1.setEnabled(false);
            card4Super1.setText(String.valueOf(num4Super1));
            card4Super1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card5Super1.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num5Super1);
            score(num5Super1);
            card5Super1.setEnabled(false);
            card5Super1.setText(String.valueOf(num5Super1));
            card5Super1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card6Super1.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num6Super1);
            score(num6Super1);
            card6Super1.setEnabled(false);
            card6Super1.setText(String.valueOf(num6Super1));
            card6Super1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card7Super1.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num7Super1);
            score(num7Super1);
            card7Super1.setEnabled(false);
            card7Super1.setText(String.valueOf(num7Super1));
            card7Super1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card8Super1.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num8Super1);
            score(num8Super1);
            card8Super1.setEnabled(false);
            card8Super1.setText(String.valueOf(num8Super1));
            card8Super1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card9Super1.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num9Super1);
            score(num9Super1);
            card9Super1.setEnabled(false);
            card9Super1.setText(String.valueOf(num9Super1));
            card9Super1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        card10Super1.setOnClickListener(v -> {
            time.time(800l);
            activateNextRound(num10Super1);
            score(num10Super1);
            card10Super1.setEnabled(false);
            card10Super1.setText(String.valueOf(num10Super1));
            card10Super1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        });
        showRound();

    }
    private void score(int numSuper1){
        App app = (App) getApplication();
        if(numSuper1 != deathNumSuper1) {
            app.setGlobalcount(app.getGlobalcount() + POINTS);
            countTextSuper1.setText(getString(R.string.Points) + " " + app.getGlobalcount());
            showCenterPlusOneAnimation();
        }
        else {
            app.setGlobalcount(0);
            countTextSuper1.setText(getString(R.string.Points) + " " + app.getGlobalcount());
            Intent intent = new Intent(SuperGameActivity.this, GameOverSuperGame.class);
            startActivity(intent);
        }
    }
    private void activateNextRound(int num){
        if(num != deathNumSuper1){
        nextRound.setEnabled(true);
        nextRound.setBackgroundColor(Color.GREEN);
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        dbManager.close();
    }

    private void showRound() {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        );

        roundNumberText.setText("РАУНД 1");

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
