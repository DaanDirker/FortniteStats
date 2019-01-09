package com.example.daan.fortnitestats.activities.Main.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daan.fortnitestats.R;
import com.example.daan.fortnitestats.models.FavouriteUser;
import com.example.daan.fortnitestats.models.RecyclerViewClickListener;

import java.util.ArrayList;
import java.util.List;

public class FavouriteUserAdapter extends RecyclerView.Adapter<FavouriteUserAdapter.FavouriteUserPlaceholder> {

    private List<FavouriteUser> favouriteUsers = new ArrayList<>();
    private RecyclerViewClickListener mListener;

    public FavouriteUserAdapter(RecyclerViewClickListener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public FavouriteUserPlaceholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_item,
                parent, false);
        return new FavouriteUserPlaceholder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteUserPlaceholder holder, int position) {
        FavouriteUser currentFavouriteUser = favouriteUsers.get(position);
        holder.usernameTitle.setText(currentFavouriteUser.getUsername());
        holder.platformTitle.setText(currentFavouriteUser.getPlatform());
    }

    public void setFavouriteUsers(List<FavouriteUser> favouriteUsers) {
        this.favouriteUsers = favouriteUsers;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return favouriteUsers.size();
    }

    class FavouriteUserPlaceholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView platformTitle;
        private TextView usernameTitle;
        private RecyclerViewClickListener mListener;

        public FavouriteUserPlaceholder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            platformTitle = itemView.findViewById(R.id.statKeyText);
            usernameTitle = itemView.findViewById(R.id.favouriteUsernameText);
            mListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(itemView, getAdapterPosition());
        }
    }
}
