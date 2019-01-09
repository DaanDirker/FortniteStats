package com.example.daan.fortnitestats.activities.Main.fragments;

import android.app.Application;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.daan.fortnitestats.R;
import com.example.daan.fortnitestats.activities.Main.viewmodels.UserViewModel;
import com.example.daan.fortnitestats.activities.Stats.StatsActivity;
import com.example.daan.fortnitestats.models.User;

public class SearchFragment extends Fragment {

    private UserViewModel mViewModel;

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(UserViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        final Spinner spinnerPlatform = rootView.findViewById(R.id.spinnerPlatform);
        final EditText editUsername = rootView.findViewById(R.id.editUsername);
        Button searchButton = rootView.findViewById(R.id.searchButton);
        setupSpinnerAdapter(spinnerPlatform);

        //Demo purposes
        editUsername.setText("Leaping Fox");

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String platform = spinnerPlatform.getSelectedItem().toString();

                if (username != null) {
                    mViewModel.fetchUser(platform, username);
                }
            }
        });

        return rootView;
    }

    /**
     * Setup spinner adapter with string-array resource
     * @param spinner
     */
    private void setupSpinnerAdapter(Spinner spinner) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
