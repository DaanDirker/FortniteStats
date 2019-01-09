package com.example.daan.fortnitestats.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "favourite_users")
public class FavouriteUser {

    @NonNull
    @PrimaryKey
    private String accountId;

    private String username;
    private String platform;

    public FavouriteUser(String accountId, String username, String platform) {
        this.accountId = accountId;
        this.username = username;
        this.platform = platform;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
