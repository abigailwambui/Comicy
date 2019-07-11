package com.example.comicy.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comicy.R;
import com.example.comicy.models.Comicy;
import com.example.comicy.ui.ComicsDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicsListAdapter extends RecyclerView.Adapter<ComicsListAdapter.ComicsViewHolder> {
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
        holder.bindComicy(mComics.get(position));
    }

    @Override
    public int getItemCount() {
        return mComics.size();
    }


    public class ComicsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.comicImageView)
        ImageView mThumbnailImageView;
        @BindView(R.id.comicModifiedTextView)
        TextView mModifiedTextView;
        @BindView(R.id.titleTextView)
        TextView mTitleTextView;
        @BindView(R.id.formatTextView)
        TextView mFormatTextView;

        private Context mContext;

        public ComicsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);



        }
        @Override
        public void onClick (View view){
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, ComicsDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("restaurants", Parcels.wrap(mComics));
            mContext.startActivity(intent);
        }


        public void bindComicy(Comicy comic) {
            Picasso.get().load(comic.getThumbnail()).into(mThumbnailImageView);
            mModifiedTextView.setText(comic.getModified());
            mTitleTextView.setText(comic.getTitle());
            mFormatTextView.setText(comic.getFormat());
        }
    }
}