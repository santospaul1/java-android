package com.example.calculator;

        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.InputType;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText firstNumberEditText, secondNumberEditText, operatorEditText, AnswerEditText;
    Button one, two, three, four, five, six, seven, eight, nine, zero;
    Button add, sub, mult, div, refresh, equals;


    private String selectedOperator = ""; // To store the selected operator
    private boolean enteringSecondNumber = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberEditText = findViewById(R.id.First);
        secondNumberEditText = findViewById(R.id.Second);
        operatorEditText = findViewById(R.id.Opp);
        AnswerEditText = findViewById(R.id.Ans);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.sero);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mult = findViewById(R.id.mult);
        div = findViewById(R.id.div);
        refresh = findViewById(R.id.refresh);
        equals = findViewById(R.id.equals);

        firstNumberEditText.setInputType(InputType.TYPE_NULL);
        secondNumberEditText.setInputType(InputType.TYPE_NULL);
        operatorEditText.setInputType(InputType.TYPE_NULL);
        AnswerEditText.setInputType(InputType.TYPE_NULL);

        // Set click listeners for number buttons
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClicked("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClicked("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClicked("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClicked("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClicked("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClicked("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClicked("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClicked("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClicked("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNumberClicked("0");
            }
        });


        // Set click listeners for operator buttons
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("-");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("/");
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOperatorButtonClicked("*");
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstNumberEditText.setText("");
                secondNumberEditText.setText("");
                operatorEditText.setText("");
                AnswerEditText.setText("");
                selectedOperator = "";
            }
        });
        equals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                onEqualsButtonClicked();
            }
        });
    }

    private void onNumberClicked(String number) {
        if (!enteringSecondNumber) {
            String currentText = firstNumberEditText.getText().toString();
            firstNumberEditText.setText(currentText + number);
        } else {
            String currentText = secondNumberEditText.getText().toString();
            secondNumberEditText.setText(currentText + number);
        }
    }

    private void onOperatorButtonClicked(String operator) {
        // If the operator is not selected yet, set the selectedOperator
        // and update the operatorEditText to show the selected operator
        if (!enteringSecondNumber) {
            selectedOperator = operator;
            operatorEditText.setText(selectedOperator);
            enteringSecondNumber = true;
        }
    }

    private void onEqualsButtonClicked() {
        if (!firstNumberEditText.getText().toString().isEmpty() &&
                !secondNumberEditText.getText().toString().isEmpty() &&
                !selectedOperator.isEmpty()) {
            double first = Double.parseDouble(firstNumberEditText.getText().toString());
            double second = Double.parseDouble(secondNumberEditText.getText().toString());
            double result = 0;

            switch (selectedOperator) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "*":
                    result = first * second;
                    break;
                case "/":
                    if (second != 0) {
                        result = first / second;
                    } else {
                        AnswerEditText.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            AnswerEditText.setText(String.valueOf(result));
            enteringSecondNumber = false;
        }
    }
}
