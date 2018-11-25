package com.example.daan.fortnitestats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class User {

    @SerializedName("epicUserHandle")
    @Expose
    private String username;

    @SerializedName("lifeTimeStats")
    @Expose
    private LifeTimeStats lifeTimeStats;

    public String getUsername() {
        return username;
    }

    public LifeTimeStats getLifeTimeStats() {
        return lifeTimeStats;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", lifeTimeStats=" + lifeTimeStats +
                '}';
    }
}
