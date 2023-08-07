package com.example.distributedsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private EditText etRequest;
    private Button btnSend;
    private TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRequest = findViewById(R.id.etRequest);
        btnSend = findViewById(R.id.btnSend);
        tvResponse = findViewById(R.id.tvResponse);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String request = etRequest.getText().toString();

                try {
                    Socket socket = new Socket("localhost", 8080);
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();

                    // Send the request to the server
                    outputStream.write(request.getBytes());

                    // Receive the response from the server
                    byte[] responseBytes = new byte[1024];
                    int bytesRead = inputStream.read(responseBytes);
                    String response = new String(responseBytes, 0, bytesRead);

                    // Display the response
                    tvResponse.setText(response);

                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
