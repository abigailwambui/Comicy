package com.example.comicy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mFindComicsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFindComicsButton = (Button) findViewById(R.id.findComicsButton);
        mFindComicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Comics!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ComicsListActivity.class);
                startActivity(intent);
            }
        });
    }

    }

