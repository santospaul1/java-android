// MainActivity.java
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);

        // Add a TextWatcher to monitor text changes in the EditText
        editTextInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This method is called before the text is changed (optional)
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // This method is called when the text is being changed
                // You can perform actions based on the text changes here
                String userInput = s.toString();
                // For example, display the user input in a TextView
                TextView textViewOutput = findViewById(R.id.textViewOutput);
                textViewOutput.setText(userInput);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This method is called after the text has been changed (optional)
            }
        });
    }
}
