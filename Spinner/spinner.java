// MainActivity.java
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerOptions;
    private String[] options = {"Option 1", "Option 2", "Option 3", "Option 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerOptions = findViewById(R.id.spinnerOptions);

        // Create an ArrayAdapter to populate the Spinner with options
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter to the Spinner
        spinnerOptions.setAdapter(adapter);

        // Handle item selection using setOnItemSelectedListener
        spinnerOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = options[position];
                // Do something with the selected option
                // For example, display a toast message
                Toast.makeText(MainActivity.this, "Selected: " + selectedOption, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do something when nothing is selected (optional)
            }
        });
    }
}
