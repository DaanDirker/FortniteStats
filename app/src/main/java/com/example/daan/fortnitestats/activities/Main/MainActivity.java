package com.example.daan.fortnitestats.activities.Main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.daan.fortnitestats.activities.Main.fragments.FavouritesFragment;
import com.example.daan.fortnitestats.activities.Main.fragments.SearchFragment;
import com.example.daan.fortnitestats.activities.Main.viewmodels.UserViewModel;
import com.example.daan.fortnitestats.R;
import com.example.daan.fortnitestats.activities.Stats.StatsActivity;
import com.example.daan.fortnitestats.models.User;
import com.example.daan.fortnitestats.services.repositories.FavouriteUserRepository;

public class MainActivity extends AppCompatActivity {

    public static final String USER_KEY = "com.example.daan.fortnitestats.activities.Main.MainActivity.User";

    private UserViewModel mUserViewModel;
    private FloatingActionButton mFabButton;
    private boolean favouritesSelected = false;

    private Fragment searchFragment;
    private Fragment favouritesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init
        mFabButton = findViewById(R.id.fabFavouriteButton);
        searchFragment = new SearchFragment();
        favouritesFragment = new FavouritesFragment();

        // Add both fragments and hide favourites fragment
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainSearchHolder, searchFragment);
        fragmentTransaction.add(R.id.mainFavouritesHolder, favouritesFragment);
        fragmentTransaction.hide(favouritesFragment);
        fragmentTransaction.commit();

        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        mUserViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    Intent intent = new Intent(MainActivity.this, StatsActivity.class);
                    intent.putExtra(USER_KEY, user);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                //Switch between fragments with hide,show
                if (!favouritesSelected) {
                    setFavouritesSelected(true);
                    transaction.hide(searchFragment);
                    transaction.show(favouritesFragment);
                    mFabButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_search_white_24dp));
                } else {
                    setFavouritesSelected(false);
                    transaction.hide(favouritesFragment);
                    transaction.show(searchFragment);
                    mFabButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorite_white_24dp));
                }

                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        mFabButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //Testing
                FavouriteUserRepository repository = new FavouriteUserRepository(getApplication());
                repository.deleteAllUsers();
                return true;
            }
        });
    }

    public void setFavouritesSelected (boolean value) {
        this.favouritesSelected = value;
    }
}
