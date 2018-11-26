package com.example.daan.fortnitestats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class User {

    @SerializedName("epicUserHandle")
    @Expose
    private String username;

    //Set transient identifier to not automatically Deserialize
    private transient Map<String, String> lifeTimeStats = null;

    public String getUsername() {
        return username;
    }

    public Map<String, String> getLifeTimeStats() {
        return lifeTimeStats;
    }

    public void setLifeTimeStats(Map<String, String> lifeTimeStats) {
        this.lifeTimeStats = lifeTimeStats;
    }

    @Override
    public String toString() {
        return username + " stats {\n" +
                "Top 3s = " + lifeTimeStats.get("Top 3s") + "\n" +
                "Top 5s = " + lifeTimeStats.get("Top 5s") + "\n" +
                "Top 6s = " + lifeTimeStats.get("Top 6s") + "\n" +
                "Top 10s = " + lifeTimeStats.get("Top 10") + "\n" +
                "Top 12s = " + lifeTimeStats.get("Top 12s") + "\n" +
                "Top 25s = " + lifeTimeStats.get("Top 25s") + "\n" +
                "Score = " + lifeTimeStats.get("Score") + "\n" +
                "Matches Played = " + lifeTimeStats.get("Matches Played") + "\n" +
                "Wins = " + lifeTimeStats.get("Wins") + "\n" +
                "Win% = " + lifeTimeStats.get("Win%") + "\n" +
                "Kills = " + lifeTimeStats.get("Kills") + "\n" +
                "K/d = " + lifeTimeStats.get("K/d") + "\n" +
                '}';
    }
}
