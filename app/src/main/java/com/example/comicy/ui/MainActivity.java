package com.example.comicy.ui;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.comicy.R;

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
