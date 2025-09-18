package com.example.deathnum;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.deathnum.database.DatabaseConstants;
import com.example.deathnum.database.StatsDatabaseManager;

import java.util.ArrayList;
import java.util.Random;

public class TwoPlayerActivity extends AppCompatActivity {
    StatsDatabaseManager dbManager;
    private int death_num1;
    Random random = new Random();
    public static int countTwo1;
    private TextView deathNumTextTwo1;
    private TextView countTextviewTwo1;
    private ArrayList<Integer> numsTwoPl1 = new ArrayList<>();
    Time time = new Time();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.twoplayers_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.two), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbManager = new StatsDatabaseManager(this);
        dbManager.open();
        dbManager.incrementModeCount(DatabaseConstants.MODE_TWO_PLAYERS);

        deathNumTextTwo1 = findViewById(R.id.deathNumTextTwoPlayers1);
        countTextviewTwo1 = findViewById(R.id.countTwo1);

        countTwo1 = 0;
        countTextviewTwo1.setText(getString(R.string.deathnum) + " " + countTwo1);
        showNumberInputDialog();
        Button exit = findViewById(R.id.exitTwoPl1);
        exit.setOnClickListener(v -> finish());

        numsTwoPl1.add(1); numsTwoPl1.add(2); numsTwoPl1.add(3);
        numsTwoPl1.add(4);numsTwoPl1.add(5);numsTwoPl1.add(6);
        numsTwoPl1.add(7);numsTwoPl1.add(8);numsTwoPl1.add(9);
        numsTwoPl1.add(10);numsTwoPl1.add(11);numsTwoPl1.add(12);

        int randIndex1 = random.nextInt(numsTwoPl1.size());
        int num1 = numsTwoPl1.get(randIndex1);
        numsTwoPl1.remove(randIndex1);

        int randIndex2 = random.nextInt(numsTwoPl1.size());
        int num2 = numsTwoPl1.get(randIndex2);
        numsTwoPl1.remove(randIndex2);

        int randIndex3 = random.nextInt(numsTwoPl1.size());
        int num3 = numsTwoPl1.get(randIndex3);
        numsTwoPl1.remove(randIndex3);

        int randIndex4 = random.nextInt(numsTwoPl1.size());
        int num4 = numsTwoPl1.get(randIndex4);
        numsTwoPl1.remove(randIndex4);

        int randIndex5 = random.nextInt(numsTwoPl1.size());
        int num5 = numsTwoPl1.get(randIndex5);
        numsTwoPl1.remove(randIndex5);

        int randIndex6 = random.nextInt(numsTwoPl1.size());
        int num6 = numsTwoPl1.get(randIndex6);
        numsTwoPl1.remove(randIndex6);

        int randIndex7 = random.nextInt(numsTwoPl1.size());
        int num7 = numsTwoPl1.get(randIndex7);
        numsTwoPl1.remove(randIndex7);

        int randIndex8 = random.nextInt(numsTwoPl1.size());
        int num8 = numsTwoPl1.get(randIndex8);
        numsTwoPl1.remove(randIndex8);

        int randIndex9 = random.nextInt(numsTwoPl1.size());
        int num9 = numsTwoPl1.get(randIndex9);
        numsTwoPl1.remove(randIndex9);

        int randIndex10 = random.nextInt(numsTwoPl1.size());
        int num10 = numsTwoPl1.get(randIndex10);
        numsTwoPl1.remove(randIndex10);

        int randIndex11 = random.nextInt(numsTwoPl1.size());
        int num11 = numsTwoPl1.get(randIndex11);
        numsTwoPl1.remove(randIndex11);

        int randIndex12 = random.nextInt(numsTwoPl1.size());
        int num12 = numsTwoPl1.get(randIndex12);
        numsTwoPl1.remove(randIndex12);



        Button card1 = findViewById(R.id.card1Two1);
        Button card2 = findViewById(R.id.card2Two1);
        Button card3 = findViewById(R.id.card3Two1);
        Button card4 = findViewById(R.id.card4Two1);
        Button card5 = findViewById(R.id.card5Two1);
        Button card6 = findViewById(R.id.card6Two1);
        Button card7 = findViewById(R.id.card7Two1);
        Button card8 = findViewById(R.id.card8Two1);
        Button card9 = findViewById(R.id.card9Two1);
        Button card10 = findViewById(R.id.card10Two1);
        Button card11 = findViewById(R.id.card11Two1);
        Button card12 = findViewById(R.id.card12Two1);


        card1.setOnClickListener(v -> {
            card1.setEnabled(false);
            choice(num1, () ->{
                card1.setText(String.valueOf(num1));
                card1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            });
        });
        card2.setOnClickListener(v -> {
            card2.setEnabled(false);
            choice(num2, () ->{
                card2.setText(String.valueOf(num2));
                card2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            });
        });
        card3.setOnClickListener(v -> {
            card3.setEnabled(false);
            choice(num3, () ->{
                card3.setText(String.valueOf(num3));
                card3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            });
        });
        card4.setOnClickListener(v -> {
            card4.setEnabled(false);
            choice(num4, () ->{
                card4.setText(String.valueOf(num4));
                card4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            });
        });
        card5.setOnClickListener(v -> {
            card5.setEnabled(false);
            choice(num5, () ->{
                card5.setText(String.valueOf(num5));
                card5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            });
        });
        card6.setOnClickListener(v -> {
            card6.setEnabled(false);
            choice(num6, () ->{
                card6.setText(String.valueOf(num6));
                card6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            });
        });
        card7.setOnClickListener(v -> {
            card7.setEnabled(false);
            choice(num7, () ->{
                card7.setText(String.valueOf(num7));
                card7.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            });
        });
        card8.setOnClickListener(v -> {
            card8.setEnabled(false);
            choice(num8, () ->{
                card8.setText(String.valueOf(num8));
                card8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            });
        });
        card9.setOnClickListener(v -> {
            card9.setEnabled(false);
            choice(num9, () ->{
                card9.setText(String.valueOf(num9));
                card9.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            });
        });
        card10.setOnClickListener(v -> {
            card10.setEnabled(false);
            choice(num10, () ->{
                card10.setText(String.valueOf(num10));
                card10.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            });
        });
        card11.setOnClickListener(v -> {
            card11.setEnabled(false);
            choice(num11, () -> {
                card11.setText(String.valueOf(num11));
                card11.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            });
        });
        card12.setOnClickListener(v -> {
            card12.setEnabled(false);
            choice(num12, () -> {
                card12.setText(String.valueOf(num12));
                card12.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            });
        });
    }

    private void showNumberInputDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.alerttwoplayers, null);
        builder.setView(dialogView);

        EditText input = dialogView.findViewById(R.id.editNums);
        Button ok = dialogView.findViewById(R.id.btn_ok);

        builder.setCancelable(false);

        AlertDialog dialog = builder.create();

        ok.setOnClickListener(v -> {
            String inputText = input.getText().toString();
            if (!inputText.isEmpty()) {
                try {
                    death_num1 = Integer.parseInt(inputText);
                    if (death_num1 >= 1 && death_num1 <= 12) {
                        deathNumTextTwo1.setText(getString(R.string.deathnum) + " " + death_num1);
                        dialog.dismiss();
                    } else {
                        Toast.makeText(TwoPlayerActivity.this,
                                "Число должно быть от 1 до 12!", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(TwoPlayerActivity.this,
                            "Введите корректное число!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(TwoPlayerActivity.this,
                        "Введите число!", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.show();
    }
    public void choice(int num, Runnable onDissmiss) {

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);

        View dialogView = getLayoutInflater().inflate(R.layout.alertdialog, null);
        builder.setView(dialogView);

        androidx.appcompat.app.AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        Button btnYes = dialogView.findViewById(R.id.btn_yes);
        Button btnNo = dialogView.findViewById(R.id.btn_no);

        btnYes.setOnClickListener(v -> {
            dialog.dismiss();
           time.time(2000l);
            if (num == death_num1) {
                countTwo1 = 13;
                countTextviewTwo1.setText(getString(R.string.Points)+ countTwo1);
                loseScreen();
            } else {
                countTwo1 -= 1;
                countTextviewTwo1.setText(getString(R.string.Points)+ countTwo1);
                loseScreen();
            }
            onDissmiss.run();
        });

        btnNo.setOnClickListener(v -> {
            dialog.dismiss();
            time.time(2000l);
            if (num != death_num1) {
                countTwo1 += 1;
                countTextviewTwo1.setText(getString(R.string.Points)+ countTwo1);
            } else loseScreen();
            onDissmiss.run();
        });

        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
    }

    private void loseScreen(){
        Intent intent = new Intent(this, TwoPlayer2Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        dbManager.close();
    }

}