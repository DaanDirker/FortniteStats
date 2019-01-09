package com.example.daan.fortnitestats.services.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.daan.fortnitestats.models.FavouriteUser;
import com.example.daan.fortnitestats.models.User;

import java.util.List;

@Dao
public interface FavouriteUserDao {

    @Insert
    void insert(FavouriteUser favouriteUser);

    @Update
    void update(FavouriteUser favouriteUser);

    @Delete
    void delete(FavouriteUser favouriteUser);

    @Query("DELETE FROM favourite_users")
    void deleteAllFavouriteUsers();

    @Query("SELECT * FROM favourite_users ORDER BY username DESC")
    LiveData<List<FavouriteUser>> getAllFavouriteUsers();

    @Query("SELECT * FROM favourite_users WHERE accountId LIKE :query")
    LiveData<FavouriteUser> findFavouriteUser(String query);
}
