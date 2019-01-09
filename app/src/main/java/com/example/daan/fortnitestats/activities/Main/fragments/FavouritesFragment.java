package com.example.daan.fortnitestats.activities.Main.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daan.fortnitestats.R;
import com.example.daan.fortnitestats.activities.Main.adapters.FavouriteUserAdapter;
import com.example.daan.fortnitestats.activities.Main.viewmodels.FavouriteUserViewModel;
import com.example.daan.fortnitestats.activities.Main.viewmodels.UserViewModel;
import com.example.daan.fortnitestats.models.FavouriteUser;
import com.example.daan.fortnitestats.models.RecyclerViewClickListener;
import com.example.daan.fortnitestats.models.User;

import java.util.List;

public class FavouritesFragment extends Fragment {

    private FavouriteUserViewModel mFavouritesViewModel;
    private UserViewModel mUserViewModel;
    private FavouriteUserAdapter mAdapter;

    private RecyclerView mRecyclerView;

    public static FavouritesFragment newInstance() {
        FavouritesFragment fragment = new FavouritesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserViewModel = ViewModelProviders.of(getActivity()).get(UserViewModel.class);
        mFavouritesViewModel = ViewModelProviders.of(this).get(FavouriteUserViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favourites, container, false);

        RecyclerView mRecyclerView = rootView.findViewById(R.id.favouritesRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                FavouriteUser favouriteUser = mFavouritesViewModel.getSingleUser(position);
                String platform = favouriteUser.getPlatform().toLowerCase();
                String username = favouriteUser.getUsername();

                mUserViewModel.fetchUser(platform, username);
            }
        };

        mAdapter = new FavouriteUserAdapter(listener);
        mRecyclerView.setAdapter(mAdapter);

        mFavouritesViewModel.getAllFavouriteUsers().observe(this, new Observer<List<FavouriteUser>>() {
            @Override
            public void onChanged(@Nullable List<FavouriteUser> favouriteUsers) {
                mAdapter.setFavouriteUsers(favouriteUsers);

            }
        });

        return rootView;
    }
}
