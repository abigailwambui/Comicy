package com.example.comicy.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.comicy.Constants;
import com.example.comicy.R;
import com.example.comicy.models.Comicy;
import com.example.comicy.ui.ComicsDetailActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

public class FirebaseComicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseComicViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindComicy(Comicy comicy) {
        ImageView mThumbnailImageView = (ImageView) mView.findViewById(R.id.comicImageView);
        TextView descriptionTextView = (TextView) mView.findViewById(R.id.formatTextView);
        TextView titleTextView = (TextView) mView.findViewById(R.id.titleTextView);
        TextView cultureTextView = (TextView) mView.findViewById(R.id.comicModifiedTextView);


        Picasso.get().load(comicy.getThumbnail()).into(mThumbnailImageView);

        descriptionTextView.setText(comicy.getFormat());
        titleTextView.setText(comicy.getTitle());
        cultureTextView.setText(comicy.getModified());
    }

    @Override
    public void onClick(View view) {
        final ArrayList<Comicy> mComics = new ArrayList<>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_COMICS).child(uid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    mComics.add(snapshot.getValue(Comicy.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, ComicsDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("restaurants", Parcels.wrap(mComics));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}


