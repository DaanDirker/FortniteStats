package com.example.daan.fortnitestats.activities.Stats.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.daan.fortnitestats.activities.Main.fragments.FavouritesFragment;
import com.example.daan.fortnitestats.activities.Main.fragments.SearchFragment;
import com.example.daan.fortnitestats.activities.Stats.fragments.LifetimeFragment;
import com.example.daan.fortnitestats.activities.Stats.fragments.MatchesFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment;

        switch (position) {
            case 0:
                fragment = new LifetimeFragment();
                break;
            case 1:
                fragment = new FavouritesFragment();
                break;
            default:
                fragment = new FavouritesFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}
