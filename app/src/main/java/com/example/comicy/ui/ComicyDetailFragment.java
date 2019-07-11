package com.example.comicy.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comicy.R;
import com.example.comicy.models.Comicy;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ComicyDetailFragment extends Fragment {

    @BindView(R.id.comicImageView) ImageView mThumbnailImageView;
    @BindView(R.id.descriptionTextView) TextView mDescriptionLabel;
    @BindView(R.id.pagecountTextView)TextView mPagecountLabel;
    @BindView(R.id.issuenumberTextView) TextView mIssuenumberLabel;
    @BindView(R.id.comicTitleTextView) TextView mTitleLabel;
    @BindView(R.id.idTextView) TextView mIdLabel;
//    @BindView(R.id.saveComicButton) Button mSaveComicButton;

    private Comicy mComics;

    public static ComicyDetailFragment newInstance(Comicy mComics) {
        ComicyDetailFragment mComicsDetailFragment = new ComicyDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("comic", Parcels.wrap(mComics));
        mComicsDetailFragment.setArguments(args);
        return mComicsDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mComics = Parcels.unwrap(getArguments().getParcelable("comic"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comicy_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.get().load(mComics.getThumbnail()).into(mThumbnailImageView);

        mTitleLabel.setText(mComics.getTitle());
        mDescriptionLabel.setText(mComics.getDescription());
        mPagecountLabel.setText(mComics.getPagecount());
        mIssuenumberLabel.setText(mComics.getIssueNumber());
        mIdLabel.setText(mComics.getId());

//        mSaveComicButton.setOnClickListener(this);

        return view;
    }


//    @Override
//    public  void onClick (View view) {
//
//        if (view == mSaveComicButton) {
//            DatabaseReference artRef = FirebaseDatabase
//                    .getInstance();
////                    .getReference(Constants.FIREBASE_CHILD_ARTS);
//            artRef.push().setValue(mComics);
//            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
//        }
//    }

}
