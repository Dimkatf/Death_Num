package com.example.deathnum;

import androidx.appcompat.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.Random;

public class TwoPlayer2Activity extends AppCompatActivity {
    private int death_num2;
    Random random = new Random();
    public static int countTwo2;
    private TextView deathNumTextTwo2;
    private TextView countTextviewTwo2;
    private ArrayList<Integer> numsTwoPl2 = new ArrayList<>();
    Time time = new Time();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.twoplayer2activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.two2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        deathNumTextTwo2 = findViewById(R.id.deathNumTextTwoPlayers2);
        countTextviewTwo2 = findViewById(R.id.countTwo2);

        countTwo2 = 0;
        countTextviewTwo2.setText(getString(R.string.PointsTwoPl2)+ countTwo2);
        showNumberInputDialog();
        Button exit = findViewById(R.id.exitTwoPl2);
        exit.setOnClickListener(v -> finish());

        numsTwoPl2.add(1); numsTwoPl2.add(2); numsTwoPl2.add(3);
        numsTwoPl2.add(4);numsTwoPl2.add(5);numsTwoPl2.add(6);
        numsTwoPl2.add(7);numsTwoPl2.add(8);numsTwoPl2.add(9);
        numsTwoPl2.add(10);numsTwoPl2.add(11);numsTwoPl2.add(12);

        int randIndex1 = random.nextInt(numsTwoPl2.size());
        int num1 = numsTwoPl2.get(randIndex1);
        numsTwoPl2.remove(randIndex1);

        int randIndex2 = random.nextInt(numsTwoPl2.size());
        int num2 = numsTwoPl2.get(randIndex2);
        numsTwoPl2.remove(randIndex2);

        int randIndex3 = random.nextInt(numsTwoPl2.size());
        int num3 = numsTwoPl2.get(randIndex3);
        numsTwoPl2.remove(randIndex3);

        int randIndex4 = random.nextInt(numsTwoPl2.size());
        int num4 = numsTwoPl2.get(randIndex4);
        numsTwoPl2.remove(randIndex4);

        int randIndex5 = random.nextInt(numsTwoPl2.size());
        int num5 = numsTwoPl2.get(randIndex5);
        numsTwoPl2.remove(randIndex5);

        int randIndex6 = random.nextInt(numsTwoPl2.size());
        int num6 = numsTwoPl2.get(randIndex6);
        numsTwoPl2.remove(randIndex6);

        int randIndex7 = random.nextInt(numsTwoPl2.size());
        int num7 = numsTwoPl2.get(randIndex7);
        numsTwoPl2.remove(randIndex7);

        int randIndex8 = random.nextInt(numsTwoPl2.size());
        int num8 = numsTwoPl2.get(randIndex8);
        numsTwoPl2.remove(randIndex8);

        int randIndex9 = random.nextInt(numsTwoPl2.size());
        int num9 = numsTwoPl2.get(randIndex9);
        numsTwoPl2.remove(randIndex9);

        int randIndex10 = random.nextInt(numsTwoPl2.size());
        int num10 = numsTwoPl2.get(randIndex10);
        numsTwoPl2.remove(randIndex10);

        int randIndex11 = random.nextInt(numsTwoPl2.size());
        int num11 = numsTwoPl2.get(randIndex11);
        numsTwoPl2.remove(randIndex11);

        int randIndex12 = random.nextInt(numsTwoPl2.size());
        int num12 = numsTwoPl2.get(randIndex12);
        numsTwoPl2.remove(randIndex12);


        /*deathNumText = findViewById(R.id.deathNumText);
        deathNumText.setText("Смертельное число: " + deathNum);

        countTextview = findViewById(R.id.countOne);
        countTextview.setText("Количество баллов: " + count);*/


        Button card1 = findViewById(R.id.card1Two2);
        Button card2 = findViewById(R.id.card2Two2);
        Button card3 = findViewById(R.id.card3Two2);
        Button card4 = findViewById(R.id.card4Two2);
        Button card5 = findViewById(R.id.card5Two2);
        Button card6 = findViewById(R.id.card6Two2);
        Button card7 = findViewById(R.id.card7Two2);
        Button card8 = findViewById(R.id.card8Two2);
        Button card9 = findViewById(R.id.card9Two2);
        Button card10 = findViewById(R.id.card10Two2);
        Button card11 = findViewById(R.id.card11Two2);
        Button card12 = findViewById(R.id.card12Two2);


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
        final EditText input = new EditText(this);
        input.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Загадайте число от 1 до 12:");
        builder.setView(input);

        builder.setPositiveButton("Загадал", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String inputText = input.getText().toString();
                if (!inputText.isEmpty()) {
                    try {
                        death_num2 = Integer.parseInt(inputText);
                        if (death_num2 >= 1 && death_num2 <= 12) {
                            deathNumTextTwo2.setText(getString(R.string.deathnumTwopl2) + " " + death_num2);
                        } else {
                            Toast.makeText(TwoPlayer2Activity.this,
                                    "Число должно быть от 1 до 12!", Toast.LENGTH_SHORT).show();
                            showNumberInputDialog();
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(TwoPlayer2Activity.this,
                                "Введите корректное число!", Toast.LENGTH_SHORT).show();
                        showNumberInputDialog();
                    }
                } else {
                    Toast.makeText(TwoPlayer2Activity.this,
                            "Введите число!", Toast.LENGTH_SHORT).show();
                    showNumberInputDialog();
                }
            }
        });

        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
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
            if (num == death_num2) {
                countTwo2 = 13;
                countTextviewTwo2.setText(getString(R.string.PointsTwoPl2)+ countTwo2);
                loseScreen();
            } else {
                countTwo2 -= 1;
                countTextviewTwo2.setText(getString(R.string.PointsTwoPl2)+ countTwo2);
                loseScreen();
            }
            onDissmiss.run();
        });

        btnNo.setOnClickListener(v -> {
            dialog.dismiss();
            time.time(2000l);
            if (num != death_num2) {
                countTwo2 += 1;
                countTextviewTwo2.setText(getString(R.string.PointsTwoPl2)+ countTwo2);
            } else loseScreen();
            onDissmiss.run();
        });

        if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();
    }

    private void loseScreen(){
        Intent intent = new Intent(this, GameOverTwoPlayers.class);
        startActivity(intent);
    }
}
