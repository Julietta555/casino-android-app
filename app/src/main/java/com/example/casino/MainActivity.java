package com.example.casino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button settings = findViewById(R.id.settings);

        View.OnClickListener oclsettings = view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        };

        settings.setOnClickListener(oclsettings);


        Button game = findViewById(R.id.game);

        View.OnClickListener oclgame = view -> {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        };

        game.setOnClickListener(oclgame);
    }
}