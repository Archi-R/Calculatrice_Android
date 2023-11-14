package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView premierChiffreTextView;
    private TextView deuxiemeChiffreTextView;
    private TextView outputTextView;
    private StringBuilder premierChiffreBuilder;
    private StringBuilder deuxiemeChiffreBuilder;
    private boolean isFirstField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        premierChiffreTextView = findViewById(R.id.PremierChiffre);
        deuxiemeChiffreTextView = findViewById(R.id.DeuxiemeChiffre);
        outputTextView = findViewById(R.id.Output);

        premierChiffreBuilder = new StringBuilder();
        deuxiemeChiffreBuilder = new StringBuilder();
        isFirstField = true;
    }

    public void Send0(View view) {
        appendNumber("0");
    }

    public void Send1(View view) {
        appendNumber("1");
    }

    public void Send2(View view) {
        appendNumber("2");
    }

    public void Send3(View view) {
        appendNumber("3");
    }

    public void Send4(View view) {
        appendNumber("4");
    }

    public void Send5(View view) {
        appendNumber("5");
    }

    public void Send6(View view) {
        appendNumber("6");
    }

    public void Send7(View view) {
        appendNumber("7");
    }

    public void Send8(View view) {
        appendNumber("8");
    }

    public void Send9(View view) {
        appendNumber("9");
    }

    public void SendPoint(View view) {
        appendNumber(".");
    }

    public void SendVirgule(View view) {
        appendNumber(",");
    }

    public void Next(View view) {
        isFirstField = false;
    }

    public void Clear(View view) {
        premierChiffreBuilder.delete(0,premierChiffreBuilder.length());
        deuxiemeChiffreBuilder.delete(0,deuxiemeChiffreBuilder.length());
        premierChiffreTextView.setText("");
        deuxiemeChiffreTextView.setText("");
        outputTextView.setText("");
        isFirstField = true;
    }

    public void Calculer(View view) {
        try {
            double premierChiffre = Double.parseDouble(premierChiffreBuilder.toString());
            double deuxiemeChiffre = Double.parseDouble(deuxiemeChiffreBuilder.toString());
            double result = premierChiffre + deuxiemeChiffre;
            outputTextView.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            outputTextView.setText("Invalid input");
        }
    }

    private void appendNumber(String number) {
        if (isFirstField) {
            premierChiffreBuilder.append(number);
            premierChiffreTextView.setText(premierChiffreBuilder.toString());
        } else {
            deuxiemeChiffreBuilder.append(number);
            deuxiemeChiffreTextView.setText(deuxiemeChiffreBuilder.toString());
        }
    }


}