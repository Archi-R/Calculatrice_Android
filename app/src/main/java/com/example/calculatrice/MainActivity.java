package com.example.calculatrice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private CalculatorLogic calculatorLogic;
    private TextView outputTextView;
    private TextView premierChiffreTextView;
    private double currentNumber =0;
    private double muldiv = 0;
    private char pastOperator ;
    private StringBuilder temp = new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorLogic = new CalculatorLogic();
        outputTextView = findViewById(R.id.Output);
        premierChiffreTextView = findViewById(R.id.PremierChiffre);
    }

    public void Send0(View view) {
        calculatorLogic.appendNumber("0");
        updatePremierChiffreTextView();
    }

    public void Send1(View view) {
        calculatorLogic.appendNumber("1");
        updatePremierChiffreTextView();
    }

    public void Send2(View view) {
        calculatorLogic.appendNumber("2");
        updatePremierChiffreTextView();
    }

    public void Send3(View view) {
        calculatorLogic.appendNumber("3");
        updatePremierChiffreTextView();
    }

    public void Send4(View view) {
        calculatorLogic.appendNumber("4");
        updatePremierChiffreTextView();
    }

    public void Send5(View view) {
        calculatorLogic.appendNumber("5");
        updatePremierChiffreTextView();
    }

    public void Send6(View view) {
        calculatorLogic.appendNumber("6");
        updatePremierChiffreTextView();
    }

    public void Send7(View view) {
        calculatorLogic.appendNumber("7");
        updatePremierChiffreTextView();
    }

    public void Send8(View view) {
        calculatorLogic.appendNumber("8");
        updatePremierChiffreTextView();
    }

    public void Send9(View view) {
        calculatorLogic.appendNumber("9");
        updatePremierChiffreTextView();
    }

    public void SendPoint(View view) {
        calculatorLogic.appendNumber(".");
        updatePremierChiffreTextView();
    }

    public void AddSubstract(View view) {
        if (temp.length() > 0) {
            muldiv = currentNumber;
            currentNumber = calculatorLogic.calculate(outputTextView, 0);
            calculatorLogic.premierChiffreBuilder.replace(0, calculatorLogic.premierChiffreBuilder.length(), temp.toString());
            calculatorLogic.deuxiemeChiffreBuilder.setLength(0);
            calculatorLogic.deuxiemeChiffreBuilder.replace(0, calculatorLogic.deuxiemeChiffreBuilder.length(), "");
            temp.setLength(0);
            temp.replace(0, temp.length(), "");
            if (muldiv!=0){
                currentNumber = currentNumber + muldiv;
                muldiv = 0;
            }
            calculatorLogic.operator = pastOperator;
            currentNumber = calculatorLogic.calculate(outputTextView, currentNumber);
            calculatorLogic.operator = '+';
            updatePremierChiffreTextView();
        }
        if (calculatorLogic.deuxiemeChiffreBuilder.length() > 0) {
            currentNumber = calculatorLogic.calculate(outputTextView, currentNumber);
            calculatorLogic.operator = '+';
            updatePremierChiffreTextView();
            return;
        }
        if (calculatorLogic.operator == '+') {
            calculatorLogic.setOperator('-');
        } else {
        calculatorLogic.setOperator('+');
        }
        updatePremierChiffreTextView();

    }

    public void Divide(View view) {
        if (calculatorLogic.deuxiemeChiffreBuilder.length() > 0) {
            pastOperator = calculatorLogic.operator;
            calculatorLogic.setOperator('/');
            temp.replace(0, temp.length(), calculatorLogic.premierChiffreBuilder.toString());
            calculatorLogic.premierChiffreBuilder.replace(0, calculatorLogic.premierChiffreBuilder.length(), calculatorLogic.deuxiemeChiffreBuilder.toString());
            calculatorLogic.deuxiemeChiffreBuilder.setLength(0);
            calculatorLogic.deuxiemeChiffreBuilder.replace(0, calculatorLogic.deuxiemeChiffreBuilder.length(), "");
            updatePremierChiffreTextView();
            return;
        } else if (temp.length()>0) {
            if (currentNumber !=0){
                muldiv = currentNumber;
            }
            currentNumber = calculatorLogic.calculate(outputTextView, 0);
            calculatorLogic.deuxiemeChiffreBuilder.setLength(0);
            calculatorLogic.deuxiemeChiffreBuilder.replace(0, calculatorLogic.deuxiemeChiffreBuilder.length(), "");
            calculatorLogic.setOperator('/');
            updatePremierChiffreTextView();
            return;
        }
        calculatorLogic.setOperator('/');
        updatePremierChiffreTextView();

    }

    public void Multiply(View view) {
        if (calculatorLogic.deuxiemeChiffreBuilder.length() > 0) {
            pastOperator = calculatorLogic.operator;
            calculatorLogic.setOperator('*');
            temp.replace(0, temp.length(), calculatorLogic.premierChiffreBuilder.toString());
            calculatorLogic.premierChiffreBuilder.replace(0, calculatorLogic.premierChiffreBuilder.length(), calculatorLogic.deuxiemeChiffreBuilder.toString());
            calculatorLogic.deuxiemeChiffreBuilder.setLength(0);
            calculatorLogic.deuxiemeChiffreBuilder.replace(0, calculatorLogic.deuxiemeChiffreBuilder.length(), "");
            updatePremierChiffreTextView();
            return;
        } else if (temp.length()>0) {
            if (currentNumber !=0){
                muldiv = currentNumber;
            }
            currentNumber = calculatorLogic.calculate(outputTextView, 0);
            calculatorLogic.deuxiemeChiffreBuilder.setLength(0);
            calculatorLogic.deuxiemeChiffreBuilder.replace(0, calculatorLogic.deuxiemeChiffreBuilder.length(), "");
            calculatorLogic.setOperator('*');
            updatePremierChiffreTextView();
            return;
        }
        calculatorLogic.setOperator('*');
        updatePremierChiffreTextView();

    }

    public void Clear(View view) {
        calculatorLogic.clear();
        updatePremierChiffreTextView();
        outputTextView.setText("");
        currentNumber = 0;
        pastOperator = ' ';
        temp.setLength(0);
        temp.replace(0, temp.length(), "");
        muldiv = 0;
        premierChiffreTextView.setText("");
    }

    public void Egal(View view) {
        if (temp.length()>0) {
            muldiv = currentNumber;
            currentNumber = calculatorLogic.calculate(outputTextView, 0);
            calculatorLogic.premierChiffreBuilder.replace(0, calculatorLogic.premierChiffreBuilder.length(), temp.toString());
            calculatorLogic.deuxiemeChiffreBuilder.setLength(0);
            calculatorLogic.deuxiemeChiffreBuilder.replace(0, calculatorLogic.deuxiemeChiffreBuilder.length(), "");
            temp.setLength(0);
            temp.replace(0, temp.length(), "");
            if (muldiv!=0){
                currentNumber = currentNumber + muldiv;
                muldiv = 0;
            }
            calculatorLogic.operator = pastOperator;
            currentNumber = calculatorLogic.calculate(outputTextView, currentNumber);
            calculatorLogic.operator = ' ';
            updatePremierChiffreTextView();
            return;
        }

        currentNumber = calculatorLogic.calculate(outputTextView, currentNumber);
        calculatorLogic.operator = ' ';
        updatePremierChiffreTextView();
    }

    private void updatePremierChiffreTextView() {
        String garbage;
        if (temp.length()>0){
            garbage = temp.toString();
        } else {
            garbage = "";
        }
        if (pastOperator != 0){
            garbage = garbage + pastOperator;
        }
        if (calculatorLogic.premierChiffreBuilder.length() != 0) {
            garbage = garbage + calculatorLogic.premierChiffreBuilder.toString() + calculatorLogic.operator + calculatorLogic.deuxiemeChiffreBuilder.toString() ;
        } else {
            garbage = garbage + Double.toString(currentNumber) + calculatorLogic.operator + calculatorLogic.deuxiemeChiffreBuilder.toString();
        }
        premierChiffreTextView.setText(garbage);

    }
}
