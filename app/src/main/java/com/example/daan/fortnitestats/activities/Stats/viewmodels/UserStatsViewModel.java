package com.example.daan.fortnitestats.activities.Stats.viewmodels;

import android.arch.lifecycle.ViewModel;

import com.example.daan.fortnitestats.models.Stat;
import com.example.daan.fortnitestats.models.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class UserStatsViewModel extends ViewModel {

    private List<Stat> lifeTimeStats = new ArrayList<>();
    private User user;

    public void setLifetimeStats() {
        Map<String, String> map = user.getLifeTimeStats();

        for (Map.Entry<String, String> entry: map.entrySet()) {
            lifeTimeStats.add(new Stat(entry.getKey(), entry.getValue()));
        }
        Collections.sort(lifeTimeStats);
    }

    public String getUsername() {
        return this.user.getUsername();
    }

    public String getPlatform() {
        return this.user.getPlatformNameLong();
    }

    public String getAcountId() {
        return this.user.getAccountId();
    }

    public List<Stat> getLifetimeStats() {
        return this.lifeTimeStats;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
