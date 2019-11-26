package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button matruebutton, mafalsebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matruebutton = findViewById(R.id.true_button);
        mafalsebutton = findViewById(R.id.false_button);

        matruebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "True Pressed", Toast.LENGTH_SHORT ).show();
            }
        });

        mafalsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "False Pressed", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
