package com.example.comicy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import okhttp3.Callback;

public class ComicsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_list);
    }

    private void getComics() {
        final ComicyService comicyService = new ComicyService();
        comicyService.findComics(new Callback() {
        });
    }
}
