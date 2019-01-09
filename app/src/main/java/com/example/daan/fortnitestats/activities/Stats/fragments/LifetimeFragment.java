package com.example.daan.fortnitestats.activities.Stats.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daan.fortnitestats.R;
import com.example.daan.fortnitestats.activities.Main.viewmodels.FavouriteUserViewModel;
import com.example.daan.fortnitestats.activities.Stats.adapters.LifetimeStatsAdapter;
import com.example.daan.fortnitestats.activities.Stats.viewmodels.UserStatsViewModel;
import com.example.daan.fortnitestats.models.FavouriteUser;
import com.example.daan.fortnitestats.models.Stat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LifetimeFragment extends Fragment {

    private UserStatsViewModel mUserStatsViewmodel;
    private FavouriteUserViewModel mFavouriteUserViewModel;
    LifetimeStatsAdapter mAdapter;
    private List<Stat> lifeTimeStats = new ArrayList<>();
    private boolean isFavorite;

    public static LifetimeFragment newInstance() {
        LifetimeFragment fragment = new LifetimeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserStatsViewmodel = ViewModelProviders.of(getActivity()).get(UserStatsViewModel.class);
        mFavouriteUserViewModel = ViewModelProviders.of(this).get(FavouriteUserViewModel.class);
        mUserStatsViewmodel.setLifetimeStats();
        this.lifeTimeStats = mUserStatsViewmodel.getLifetimeStats();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lifetime, container, false);

        TextView usernameTitle = rootView.findViewById(R.id.usernameTitle);
        usernameTitle.setText(mUserStatsViewmodel.getUsername());

        final ImageView favoriteIcon = rootView.findViewById(R.id.favouriteImage);

        //Fill favourite icon when user is already favorite
        mFavouriteUserViewModel.search(mUserStatsViewmodel.getAcountId()).observe(this,
                new Observer<FavouriteUser>() {
            @Override
            public void onChanged(@Nullable final FavouriteUser favouriteUser) {
                if (favouriteUser != null) {
                    isFavorite = true;
                    favoriteIcon.setImageDrawable(getResources()
                            .getDrawable(R.drawable.ic_favorite_white_34dp));
                } else {
                    isFavorite = false;
                }
            }
        });

        favoriteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountId = mUserStatsViewmodel.getAcountId();
                String username = mUserStatsViewmodel.getUsername();
                String platform = mUserStatsViewmodel.getPlatform();

                //Add favorite in room & drawable
                if (isFavorite) {
                    mFavouriteUserViewModel.delete(new FavouriteUser(accountId, username, platform));
                    favoriteIcon.setImageDrawable(getResources().
                            getDrawable(R.drawable.ic_favorite_border_white_34dp));
                } else {
                    mFavouriteUserViewModel.insert(new FavouriteUser(accountId, username, platform));
                }
            }
        });

        RecyclerView mRecyclerView = rootView.findViewById(R.id.lifeTimeRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        mAdapter = new LifetimeStatsAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setStats(lifeTimeStats);

        return rootView;
    }
}
