package com.example.deathnum.modes;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

import com.example.deathnum.sreens_lose.LoseScreenOnePlayer;
import com.example.deathnum.R;
import com.example.deathnum.help_classes.Time;
import com.example.deathnum.database.DatabaseConstants;
import com.example.deathnum.database.StatsDatabaseManager;

public class OnePlayerActivity extends AppCompatActivity {

    StatsDatabaseManager dbManager;
    private Random random = new Random();
    private int deathNum;
    public static int count;
    private TextView deathNumText;
    private TextView countTextview;
    private static final int COUNT_CARDS = 12;
    private ArrayList<Integer> nums = new ArrayList<>();
    private int num1; private int num2;
    private int num3; private int num4;
    private int num5; private int num6; private int num7;
    private int num8; private int num9; private int num10;
    private int num11; private int num12;

    Time time = new Time();
    Button card1;Button card2;Button card3;
    Button card4;Button card5;Button card6;
    Button card7;Button card8;Button card9;
    Button card10;Button card11;Button card12;

    private RelativeLayout deathNumberOverlay;
    private TextView deathNumberText;
    private Animation slideUpAnimation, slideDownAnimation, pulseAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.oneplayer_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.one), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        pulseAnimation = AnimationUtils.loadAnimation(this, R.anim.text_pulse);


        deathNumberOverlay = findViewById(R.id.deathNumberOverlay);
        deathNumberText = findViewById(R.id.deathNumberText);

        dbManager = new StatsDatabaseManager(this);
        dbManager.open();

        dbManager.incrementModeCount(DatabaseConstants.MODE_ONE_PLAYER);

        Button exit = findViewById(R.id.exitOnePl);
        exit.setOnClickListener(v -> finish());

        nums.add(1); nums.add(2); nums.add(3);
        nums.add(4);nums.add(5);nums.add(6);
        nums.add(7);nums.add(8);nums.add(9);
        nums.add(10);nums.add(11);nums.add(12);

        int randIndex1 = random.nextInt(nums.size());
        num1 = nums.get(randIndex1);
        nums.remove(randIndex1);

        int randIndex2 = random.nextInt(nums.size());
        num2 = nums.get(randIndex2);
        nums.remove(randIndex2);

        int randIndex3 = random.nextInt(nums.size());
        num3 = nums.get(randIndex3);
        nums.remove(randIndex3);

        int randIndex4 = random.nextInt(nums.size());
        num4 = nums.get(randIndex4);
        nums.remove(randIndex4);

        int randIndex5 = random.nextInt(nums.size());
        num5 = nums.get(randIndex5);
        nums.remove(randIndex5);

        int randIndex6 = random.nextInt(nums.size());
        num6 = nums.get(randIndex6);
        nums.remove(randIndex6);

        int randIndex7 = random.nextInt(nums.size());
        num7 = nums.get(randIndex7);
        nums.remove(randIndex7);

        int randIndex8 = random.nextInt(nums.size());
        num8 = nums.get(randIndex8);
        nums.remove(randIndex8);

        int randIndex9 = random.nextInt(nums.size());
        num9 = nums.get(randIndex9);
        nums.remove(randIndex9);

        int randIndex10 = random.nextInt(nums.size());
        num10 = nums.get(randIndex10);
        nums.remove(randIndex10);

        int randIndex11 = random.nextInt(nums.size());
        num11 = nums.get(randIndex11);
        nums.remove(randIndex11);

        int randIndex12 = random.nextInt(nums.size());
        num12 = nums.get(randIndex12);
        nums.remove(randIndex12);

        count = 0;
        deathNum = random.nextInt(COUNT_CARDS) + 1;
        deathNumText = findViewById(R.id.deathNumText);
        deathNumText.setText(getString(R.string.deathnum) + " " + deathNum);

        countTextview = findViewById(R.id.countOne);
        countTextview.setText(getString(R.string.Points) + " " + count);

        card1 = findViewById(R.id.card1One);
        card2 = findViewById(R.id.card2One);
        card3 = findViewById(R.id.card3One);
        card4 = findViewById(R.id.card4One);
        card5 = findViewById(R.id.card5One);
        card6 = findViewById(R.id.card6One);
        card7 = findViewById(R.id.card7One);
        card8 = findViewById(R.id.card8One);
        card9 = findViewById(R.id.card9One);
        card10 = findViewById(R.id.card10One);
        card11 = findViewById(R.id.card11One);
        card12 = findViewById(R.id.card12One);

        showDeathNumberAnimation(deathNum);

        card1.setOnClickListener(v -> {
            card1.setEnabled(false);
            choice(num1, () -> {
                card1.setText(String.valueOf(num1));
                card1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            });
        });
        card2.setOnClickListener(v -> {
            card2.setEnabled(false);
            choice(num2, () -> {
                card2.setText(String.valueOf(num2));
                card2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            });
        });
        card3.setOnClickListener(v -> {
            card3.setEnabled(false);
            choice(num3, () -> {
                card3.setText(String.valueOf(num3));
                card3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            });
        });
        card4.setOnClickListener(v -> {
            card4.setEnabled(false);
            choice(num4, () -> {
                card4.setText(String.valueOf(num4));
                card4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            });
        });
        card5.setOnClickListener(v -> {
            card5.setEnabled(false);
            choice(num5, () -> {
                card5.setText(String.valueOf(num5));
                card5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            });
        });
        card6.setOnClickListener(v -> {
            card6.setEnabled(false);
            choice(num6, () -> {
                card6.setText(String.valueOf(num6));
                card6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            });
        });
        card7.setOnClickListener(v -> {
            card7.setEnabled(false);
            choice(num7, () -> {
                card7.setText(String.valueOf(num7));
                card7.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            });
        });
        card8.setOnClickListener(v -> {
            card8.setEnabled(false);
            choice(num8, () -> {
                card8.setText(String.valueOf(num8));
                card8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            });
        });
        card9.setOnClickListener(v -> {
            card9.setEnabled(false);
            choice(num9, () -> {
                card9.setText(String.valueOf(num9));
                card9.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            });
        });
        card10.setOnClickListener(v -> {
            card10.setEnabled(false);
            choice(num10, () -> {
                card10.setText(String.valueOf(num10));
                card10.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            });
        });
        card11.setOnClickListener(v -> {
            card11.setEnabled(false);
            choice(num11, () -> {
                card11.setText(String.valueOf(num11));
                card11.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            });
        });
        card12.setOnClickListener(v -> {
            card12.setEnabled(false);
            choice(num12, () -> {
                card12.setText(String.valueOf(num12));
                card12.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            });
        });
    }

    private void showDeathNumberAnimation(int deathNumber) {
        deathNumberText.setText("DEATH NUM: " + deathNumber);

        deathNumberOverlay.setVisibility(View.VISIBLE);
        deathNumberText.setVisibility(View.VISIBLE);

        deathNumberOverlay.startAnimation(slideUpAnimation);
        deathNumberText.startAnimation(pulseAnimation);

        new Handler().postDelayed(() -> {
            deathNumberOverlay.startAnimation(slideDownAnimation);
            deathNumberOverlay.postDelayed(() -> {
                deathNumberOverlay.setVisibility(View.GONE);
                deathNumberText.clearAnimation();
            }, 800);
        }, 5000);
    }

    public void choice(int num, Runnable onDismiss) {
        setAllCardsEnabled(false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.alertdialog, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = dialogView.findViewById(R.id.btn_yes);
        Button btnNo = dialogView.findViewById(R.id.btn_no);

        btnYes.setOnClickListener(v -> {
            dialog.dismiss();
            time.time(2000L);
            if (num == deathNum) {
                count = 13;
                countTextview.setText(getString(R.string.Points) + " " + count);
                loseScreen();
            } else {
                count -= 1;
                countTextview.setText(getString(R.string.Points) + " " + count);
                loseScreen();
            }
            onDismiss.run();
        });

        btnNo.setOnClickListener(v -> {
            dialog.dismiss();
            time.time(2000L);
            if (num != deathNum) {
                count += 1;
                countTextview.setText(getString(R.string.Points) + " " + count);
                setAllCardsEnabled(true);
            } else {
                loseScreen();
            }
            onDismiss.run();
        });

        dialog.setOnCancelListener(dialogInterface -> {
            setAllCardsEnabled(true);
        });

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        dialog.show();
    }

    private void setAllCardsEnabled(boolean enabled) {
        card1.setEnabled(enabled);
        card2.setEnabled(enabled);
        card3.setEnabled(enabled);
        card4.setEnabled(enabled);
        card5.setEnabled(enabled);
        card6.setEnabled(enabled);
        card7.setEnabled(enabled);
        card8.setEnabled(enabled);
        card9.setEnabled(enabled);
        card10.setEnabled(enabled);
        card11.setEnabled(enabled);
        card12.setEnabled(enabled);
    }

    private void loseScreen() {
        dbManager.saveGameScore(DatabaseConstants.MODE_ONE_PLAYER, count);
        Intent intent = new Intent(this, LoseScreenOnePlayer.class);
        startActivity(intent);

        setAllCardsEnabled(false);

        showCardWithColor(card1, num1);
        showCardWithColor(card2, num2);
        showCardWithColor(card3, num3);
        showCardWithColor(card4, num4);
        showCardWithColor(card5, num5);
        showCardWithColor(card6, num6);
        showCardWithColor(card7, num7);
        showCardWithColor(card8, num8);
        showCardWithColor(card9, num9);
        showCardWithColor(card10, num10);
        showCardWithColor(card11, num11);
        showCardWithColor(card12, num12);
    }

    private void showCardWithColor(Button card, int number) {
        card.setText(String.valueOf(number));
        card.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        if (number == deathNum) {
            card.setTextColor(Color.RED);
        } else {
            card.setTextColor(Color.BLACK);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.close();
    }
}