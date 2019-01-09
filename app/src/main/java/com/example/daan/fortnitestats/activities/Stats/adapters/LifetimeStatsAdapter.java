package com.example.daan.fortnitestats.activities.Stats.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daan.fortnitestats.R;
import com.example.daan.fortnitestats.models.Stat;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class LifetimeStatsAdapter extends RecyclerView.Adapter<LifetimeStatsAdapter.LifeTimestatsHolder> {

    private List<Stat> stats = new ArrayList<>();

    @NonNull
    @Override
    public LifeTimestatsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lifetime_stats_item,
                parent, false);
        return new LifeTimestatsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LifeTimestatsHolder holder, int position) {
        Stat currentStat = stats.get(position);
        holder.mStatTitle.setText(currentStat.getTitle());
        holder.mStatValue.setText(currentStat.getValue());
    }

    public void setStats(List<Stat> newStats) {
        this.stats = newStats;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return stats.size();
    }

    public class LifeTimestatsHolder extends RecyclerView.ViewHolder {
        private TextView mStatTitle;
        private TextView mStatValue;

        public LifeTimestatsHolder(@NonNull View itemView) {
            super(itemView);
            mStatTitle = itemView.findViewById(R.id.statKeyText);
            mStatValue = itemView.findViewById(R.id.statValueText);
        }
    }
}
