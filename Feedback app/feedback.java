package com.example.messagelauncher;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etEmail;
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        tvStatus = findViewById(R.id.tv_status);
    }

    public void onSubmit(View view) {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        tvStatus.setText("Thank you for your feedback, " + name + " (" + email + ")");
    }
}
