package com.example.daan.fortnitestats.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

@Entity(tableName = "favourite_user")
public class User {

    @PrimaryKey
    @SerializedName("accountId")
    @Expose
    private String accountId;

    @SerializedName("epicUserHandle")
    @Expose
    private String username;

    @SerializedName("platformNameLong")
    @Expose
    private String platformNameLong;

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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlatformNameLong() {
        return platformNameLong;
    }

    public void setPlatformNameLong(String platformNameLong) {
        this.platformNameLong = platformNameLong;
    }

    @Override
    public String toString() {
        return username + " stats {\n" +
                "Username = " + getUsername() + "\n" +
                "Platform = " + getPlatformNameLong() + "\n" +
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
                "acountId = " + getAccountId() +
                '}';
    }
}
