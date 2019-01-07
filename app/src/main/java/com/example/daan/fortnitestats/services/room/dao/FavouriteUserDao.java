package com.example.daan.fortnitestats.services.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.daan.fortnitestats.models.User;

import java.util.List;

@Dao
public interface FavouriteUserDao {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM favourite_user")
    void deleteAllFavouriteUsers();

    @Query("SELECT * FROM favourite_user order by username DESC")
    LiveData<List<User>> getAllFavouriteUsers();
}
