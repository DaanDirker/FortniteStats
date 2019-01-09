package com.example.daan.fortnitestats.services.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.daan.fortnitestats.models.FavouriteUser;
import com.example.daan.fortnitestats.models.User;
import com.example.daan.fortnitestats.services.room.dao.FavouriteUserDao;

@Database(entities = {FavouriteUser.class}, version = 1)
public abstract class StatsDatabase extends RoomDatabase {

    private static StatsDatabase instance;

    public abstract FavouriteUserDao favouriteUserDao();

    public static synchronized StatsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    StatsDatabase.class, "stats_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
