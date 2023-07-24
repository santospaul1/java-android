import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private StringBuilder number1 = new StringBuilder();
    private StringBuilder number2 = new StringBuilder();
    private char operator = ' ';

    private TextView textViewNumber1;
    private TextView textViewOperator;
    private TextView textViewNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewNumber1 = findViewById(R.id.number1);
        textViewOperator = findViewById(R.id.operator);
        textViewNumber2 = findViewById(R.id.number2);
    }

    public void onRefreshButtonClick(View view) {
        number1.setLength(0);
        number2.setLength(0);
        operator = ' ';

        textViewNumber1.setText("");
        textViewNumber2.setText("");
        textViewOperator.setText("");
    }

    public void onButtonClick(View view) {
        String buttonText = ((TextView) view).getText().toString();
        char firstChar = buttonText.charAt(0);

        if (Character.isDigit(firstChar) || buttonText.equals(".")) {
            if (operator == ' ') {
                number1.append(buttonText);
                textViewNumber1.setText(number1.toString());
            } else {
                number2.append(buttonText);
                textViewNumber2.setText(number2.toString());
            }
        } else if (buttonText.equals("=")) {
            performOperation();
        } else {
            operator = firstChar;
            textViewOperator.setText(Character.toString(operator));
        }
    }

    private void performOperation() {
        if (operator != ' ' && number1.length() > 0 && number2.length() > 0) {
            double num1 = Double.parseDouble(number1.toString());
            double num2 = Double.parseDouble(number2.toString());
            double result = 0.0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textViewNumber1.setText("Error");
                        textViewNumber2.setText("");
                        textViewOperator.setText("");
                        number1.setLength(0);
                        number2.setLength(0);
                        operator = ' ';
                        return;
                    }
                    break;
            }

            textViewNumber1.setText(String.valueOf(result));
            textViewNumber2.setText("");
            textViewOperator.setText("");
            number1.setLength(0);
            number2.setLength(0);
            operator = ' ';
        }
    }
}
