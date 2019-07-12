package com.example.comicy.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.comicy.Constants;
import com.example.comicy.R;
import com.example.comicy.adapters.FirebaseComicViewHolder;
import com.example.comicy.models.Comicy;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedComicsListActivity extends AppCompatActivity {
    private DatabaseReference mComicsReference;
    private FirebaseRecyclerAdapter<Comicy, FirebaseComicViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_list);
        ButterKnife.bind(this);
        mComicsReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_COMICS);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Comicy> options =
                new FirebaseRecyclerOptions.Builder<Comicy>()
                        .setQuery(mComicsReference, Comicy.class)
                        .build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Comicy, FirebaseComicViewHolder>(options) {


            @Override
            protected void onBindViewHolder(@NonNull FirebaseComicViewHolder firebaseComicViewHolder, int position, @NonNull Comicy comicy) {
                firebaseComicViewHolder.bindComicy(comicy);
            }

            @NonNull
            @Override
            public FirebaseComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_list_item, parent, false);
                return new FirebaseComicViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
}
