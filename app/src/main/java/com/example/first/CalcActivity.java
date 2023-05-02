package com.example.first;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalcActivity extends AppCompatActivity {
    private ImageButton backspace;
    boolean isOperatorPressed = false;
    boolean isEqualPressed = false;
    char op = ' ';
    private Button add, minus, div, multiply, equal;
    private TextView answer, phrase;
    private double num1 = 0;
    private double num2 = 0;
    private Button[] numbers = new Button[10];
    private int[] button_ids = {R.id.b_0, R.id.b_1, R.id.b_2,
            R.id.b_3,R.id.b_4,R.id.b_5,
            R.id.b_6,R.id.b_7,R.id.b_8,
            R.id.b_9};


    private boolean isInteger(double num) {
        return Math.ceil(num) == Math.floor(num);
    }

    private double calculate(double num1, double num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case 'x':
                return num1 * num2;
            case '÷':
                return num1 / num2;
            default:
                return 0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_main);
        answer = findViewById(R.id.answer);
        phrase = findViewById(R.id.phrase);
        backspace = findViewById(R.id.delete);
        div = findViewById(R.id.b_div);
        add = findViewById(R.id.b_add);
        minus = findViewById(R.id.b_subtract);
        multiply = findViewById(R.id.b_multiply);
        equal = findViewById(R.id.b_equals);

        for (int i = 0;i < button_ids.length;i++) {
            numbers[i] = findViewById(button_ids[i]);
            int finalI = i;
            numbers[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String changer = answer.getText().toString() +
                            finalI;
                    answer.setText(changer);
                }
            });

            numbers[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isOperatorPressed) {
                        answer.setText("");
                        isOperatorPressed = false;
                    }

                    if (isEqualPressed) {
                        phrase.setText("");
                        answer.setText("");
                        isEqualPressed = false;
                    }

                    String tvDisplayText = answer.getText().toString();
                    if (tvDisplayText.equals("0")) {
                        tvDisplayText = "";
                    }
                    tvDisplayText = tvDisplayText + finalI;
                    answer.setText(tvDisplayText);
                }
            });
        }






        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String current = answer.getText().toString();
                if (current.length() > 0) {
                    current = current.substring(0, current.length() - 1);
                    if (current.length() == 0) {
                        current = "0";
                    }
                    answer.setText(current);
                }
            }
        });


        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOperatorPressed = true;
                String tvDisplayText = answer.getText().toString();

                if (isEqualPressed) {
                    phrase.setText("");
                    isEqualPressed = false;
                }

                if (op != '÷') {
                    num1 = Double.parseDouble(tvDisplayText);
                    String temp = tvDisplayText + " ÷ ";
                    phrase.setText(temp);
                    op = '÷';
                } else {
                    num2 = Double.parseDouble(tvDisplayText);
                    if (num1 == 0 || num2 == 0)
                        return;
                    num1 = calculate(num1, num2, op);

                    String strNum1 = "";
                    if (isInteger(num1)) {
                        strNum1 = String.valueOf(num1).substring(0, String.valueOf(num1).indexOf("."));
                    } else {
                        strNum1 = String.valueOf(num1);
                    }

                    String temp = strNum1 + " ÷ ";
                    phrase.setText(temp);

                    answer.setText(strNum1);
                }

            }
        });


        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOperatorPressed = true;
                String tvDisplayText = answer.getText().toString();

                if (isEqualPressed) {
                    phrase.setText("");
                    isEqualPressed = false;
                }

                if (op != 'x') {
                    num1 = Double.parseDouble(tvDisplayText);
                    String temp = tvDisplayText + " x ";
                    phrase.setText(temp);
                    op = 'x';
                } else {
                    num2 = Double.parseDouble(tvDisplayText);
                    num1 = calculate(num1, num2, op);

                    String strNum1 = "";
                    if (isInteger(num1)) {
                        strNum1 = String.valueOf(num1).substring(0, String.valueOf(num1).indexOf("."));
                    } else {
                        strNum1 = String.valueOf(num1);
                    }

                    String temp = strNum1 + " x ";
                    phrase.setText(temp);

                    answer.setText(strNum1);
                }
            }
        });


        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOperatorPressed = true;
                String tvDisplayText = answer.getText().toString();

                if (isEqualPressed) {
                    phrase.setText("");
                    isEqualPressed = false;
                }


                if (op != '-') {
                    num1 = Double.parseDouble(tvDisplayText);
                    String temp = tvDisplayText + " - ";
                    phrase.setText(temp);
                    op = '-';
                } else {
                    num2 = Double.parseDouble(tvDisplayText);
                    num1 = calculate(num1, num2, op);

                    String strNum1 = "";
                    if (isInteger(num1)) {
                        strNum1 = String.valueOf(num1).substring(0, String.valueOf(num1).indexOf("."));
                    } else {
                        strNum1 = String.valueOf(num1);
                    }

                    String temp = strNum1 + " - ";
                    phrase.setText(temp);

                    answer.setText(strNum1);
                }
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOperatorPressed = true;
                String tvDisplayText = answer.getText().toString();

                if (isEqualPressed) {
                    phrase.setText("");
                    isEqualPressed = false;
                }


                if (op != '+') {
                    num1 = Double.parseDouble(tvDisplayText);
                    String temp = tvDisplayText + " + ";
                    phrase.setText(temp);
                    op = '+';
                } else {
                    num2 = Double.parseDouble(tvDisplayText);
                    num1 = calculate(num1, num2, op);

                    String strNum1 = "";
                    if (isInteger(num1)) {
                        strNum1 = String.valueOf(num1).substring(0, String.valueOf(num1).indexOf("."));
                    } else {
                        strNum1 = String.valueOf(num1);
                    }

                    String temp = strNum1 + " + ";
                    phrase.setText(temp);

                    answer.setText(strNum1);
                }

            }

        });


        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tvDisplayText = answer.getText().toString();
                if (op != ' ') {
                    isEqualPressed = true;
                    isOperatorPressed = false;
                    num2 = Double.parseDouble(tvDisplayText);
                    double res = calculate(num1, num2, op);

                    String strNum1 = "";
                    if (isInteger(num1)) {
                        strNum1 = String.valueOf(num1).substring(0, String.valueOf(num1).indexOf("."));
                    } else {
                        strNum1 = String.valueOf(num1);
                    }

                    String strNum2 = "";
                    if (isInteger(num2)) {
                        strNum2 = String.valueOf(num2).substring(0, String.valueOf(num2).indexOf("."));
                    } else {
                        strNum2 = String.valueOf(num2);
                    }

                    String strRes = "";
                    if (isInteger(res)) {
                        strRes = String.valueOf(res).substring(0, String.valueOf(res).indexOf("."));
                    } else {
                        strRes = String.valueOf(res);
                    }

                    answer.setText(strRes);
                    String temp = strNum1 + " " + op + " " + strNum2 + " = ";
                    phrase.setText(temp);
                    op = ' ';
                    num1 = 0;
                    num2 = 0;
                }

            }
        });


    }
}