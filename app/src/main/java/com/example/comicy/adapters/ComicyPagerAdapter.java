package com.example.comicy.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.comicy.models.Comicy;
import com.example.comicy.ui.ComicyDetailFragment;

import java.util.ArrayList;

public class ComicyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Comicy> mComics;

    public ComicyPagerAdapter(FragmentManager fm, ArrayList<Comicy> comics) {
        super(fm);
        mComics = comics;
    }

    @Override
    public Fragment getItem(int position) {
        return ComicyDetailFragment.newInstance(mComics.get(position));
    }

    @Override
    public int getCount() {
        return mComics.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mComics.get(position).getTitle();
    }
}

