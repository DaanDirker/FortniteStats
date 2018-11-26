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
}
