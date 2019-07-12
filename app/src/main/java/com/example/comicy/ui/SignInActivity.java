package com.example.comicy.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comicy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInActivity extends AppCompatActivity {
    @BindView(R.id.textViewMain)
    TextView mTextViewMain;
    @BindView(R.id.submitartsy)
    Button mSubmitArtsy;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);

        mTextViewMain = (TextView) findViewById(R.id.textViewMain);
        Typeface walkwayFont = Typeface.createFromAsset(getAssets(), "fonts/Walkway_Black.ttf");
        mTextViewMain.setTypeface(walkwayFont);
        mSubmitArtsy= (Button) findViewById(R.id.submitartsy);
        mSubmitArtsy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(SignInActivity.this, "Welcome", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SignInActivity.this, ComicsListActivity.class);
                startActivity(intent);
            }
        });
    }
}

