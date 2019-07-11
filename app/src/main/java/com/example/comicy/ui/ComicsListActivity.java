package com.example.comicy.ui;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.comicy.models.Comicy;
import com.example.comicy.services.ComicyService;
import com.example.comicy.R;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ComicsListActivity extends AppCompatActivity {

    public static final String TAG = ComicsListActivity.class.getSimpleName();
//    @BindView(R.id.listView)ListView mListView;

    public ArrayList<Comicy> mComics = new ArrayList<>();
    private ComicsListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_list);
        getComics();
    }

    private void getComics() {
        final ComicyService comicyService = new ComicyService();
        comicyService.findComics(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                        mComics = comicyService.processResults(response);
                        ComicsListActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mAdapter = new ComicsListAdapter(getApplicationContext(), mComics);
                                mRecyclerView.setAdapter(mAdapter);
                                RecyclerView.LayoutManager layoutManager =
                                        new LinearLayoutManager(ComicsListActivity.this);
                                mRecyclerView.setLayoutManager(layoutManager);
                                mRecyclerView.setHasFixedSize(true);
                            }
                        });
            }
        });
    }
}