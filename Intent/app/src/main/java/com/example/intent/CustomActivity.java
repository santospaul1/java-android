package com.example.intent;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class CustomActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view);
        TextView label = findViewById(R.id.show_data);
        Uri url = getIntent().getData();
        if (url != null) {
            label.setText(url.toString());
        }
    }
}
