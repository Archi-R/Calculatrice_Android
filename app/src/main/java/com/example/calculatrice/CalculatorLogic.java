package com.example.calculatrice;


import android.widget.TextView;

public class CalculatorLogic {
    public StringBuilder premierChiffreBuilder;
    public StringBuilder deuxiemeChiffreBuilder;
    public char operator;

    public CalculatorLogic() {
        premierChiffreBuilder = new StringBuilder();
        deuxiemeChiffreBuilder = new StringBuilder();
        operator = ' ';
    }

    public void appendNumber(String number) {
        if (operator == ' ') {
            premierChiffreBuilder.append(number);
        } else {
            deuxiemeChiffreBuilder.append(number);
        }
    }

    public void setOperator(char op) {
        operator = op;
    }

    public double calculate(TextView outputTextView, double chiffre) {
        try {
            double premierChiffre = 0;
            double deuxiemeChiffre = 0;
            if (chiffre == 0 || deuxiemeChiffreBuilder.length()== 0){
                premierChiffre = Double.parseDouble(premierChiffreBuilder.toString());
            } else {
                premierChiffre = chiffre;
            }
            if (deuxiemeChiffreBuilder.length() == 0){
                deuxiemeChiffre = chiffre;
            } else { deuxiemeChiffre = Double.parseDouble(deuxiemeChiffreBuilder.toString());}
            double result;

            switch (operator) {
                case '+':
                    result = premierChiffre + deuxiemeChiffre;
                    break;
                case '-':
                    result = premierChiffre - deuxiemeChiffre;
                    break;
                case '*':
                    result = premierChiffre * deuxiemeChiffre;
                    break;
                case '/':
                    if (deuxiemeChiffre != 0) {
                        result = premierChiffre / deuxiemeChiffre;
                    } else {
                        outputTextView.setText("Error: Division by zero");
                        return 0;
                    }
                    break;
                default:
                    outputTextView.setText("Error: Invalid operator");
                    return 0;
            }

            outputTextView.setText(String.valueOf(result));
            premierChiffreBuilder.setLength(0);
            deuxiemeChiffreBuilder.setLength(0);
            premierChiffreBuilder.replace(0, premierChiffreBuilder.length(), "");
            deuxiemeChiffreBuilder.replace(0, deuxiemeChiffreBuilder.length(), "");
            operator = ' ';
            return result;

        } catch (NumberFormatException e) {
            outputTextView.setText("Error: Invalid input");
        }
        return 0;
    }

    public void clear() {
        premierChiffreBuilder.setLength(0);
        deuxiemeChiffreBuilder.setLength(0);
        premierChiffreBuilder.replace(0, premierChiffreBuilder.length(), "");
        deuxiemeChiffreBuilder.replace(0, deuxiemeChiffreBuilder.length(), "");
        operator = ' ';
    }
}
