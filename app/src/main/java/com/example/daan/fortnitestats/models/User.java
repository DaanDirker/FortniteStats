package com.example.daan.fortnitestats.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Parcelable {

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
    private transient Map<String, String> lifeTimeStats;

    //For passing with intent
    private transient String jsonLifeTimeStats;

    protected User(Parcel in) {
        accountId = in.readString();
        username = in.readString();
        platformNameLong = in.readString();
        jsonLifeTimeStats = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(accountId);
        dest.writeString(username);
        dest.writeString(platformNameLong);

        Gson gson = new Gson();
        this.jsonLifeTimeStats = gson.toJson(lifeTimeStats);
        dest.writeString(jsonLifeTimeStats);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public Map<String, String> getLifeTimeStats() {
        return lifeTimeStats;
    }

    public void setLifeTimeStats(Map<String, String> lifeTimeStats) {
        this.lifeTimeStats = lifeTimeStats;
    }

    public String getJsonLifeTimeStats() {
        return jsonLifeTimeStats;
    }

    public void setJsonLifeTimeStats(String jsonLifeTimeStats) {
        this.jsonLifeTimeStats = jsonLifeTimeStats;
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
