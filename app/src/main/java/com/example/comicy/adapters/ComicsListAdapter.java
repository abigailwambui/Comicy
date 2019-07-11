package com.example.comicy.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comicy.R;
import com.example.comicy.models.Comicy;

import java.util.ArrayList;

import butterknife.BindView;

public class ComicsListAdapter extends RecyclerView.Adapter<ComicsListAdapter.ComicsViewHolder>{
    public ArrayList<Comicy> mComics = new ArrayList<>();
    private Context mContext;

    public ComicsListAdapter(Context context, ArrayList<Comicy> mComics) {
        mContext = context;
        this.mComics = mComics;
    }

    @Override
    public ComicsListAdapter.ComicsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_list_item, parent, false);
        ComicsViewHolder viewHolder = new ComicsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ComicsListAdapter.ComicsViewHolder holder, int position) {
        holder.bindComic(mComics.get(position));
    }

    @Override
    public int getItemCount() {
        return mComics.size();
    }


    public class ComicsViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.artImageView)
        ImageView mArtImageView;
        @BindView(R.id.artDescriptionTextView)
        TextView mDescriptionTextView;
        @BindView(R.id.titleTextView) TextView mTitleTextView;
        @BindView(R.id.cultureTextView) TextView mCultureTextView;


    }
