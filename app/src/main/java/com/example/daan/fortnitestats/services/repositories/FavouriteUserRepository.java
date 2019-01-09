package com.example.daan.fortnitestats.services.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.daan.fortnitestats.models.FavouriteUser;
import com.example.daan.fortnitestats.models.User;
import com.example.daan.fortnitestats.services.room.StatsDatabase;
import com.example.daan.fortnitestats.services.room.dao.FavouriteUserDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class FavouriteUserRepository {
    private FavouriteUserDao favouriteUserDao;
    private LiveData<List<FavouriteUser>> allFavouriteUsers;
    private Executor mExecutor = Executors.newSingleThreadExecutor();

    public FavouriteUserRepository(Application application) {
        StatsDatabase database = StatsDatabase.getInstance(application);
        this.favouriteUserDao = database.favouriteUserDao();
        this.allFavouriteUsers = favouriteUserDao.getAllFavouriteUsers();
    }

    public void insert(final FavouriteUser favouriteUser) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                favouriteUserDao.insert(favouriteUser);
            }
        });
    }

    public void update(final FavouriteUser favouriteUser) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                favouriteUserDao.update(favouriteUser);
            }
        });
    }

    public void delete(final FavouriteUser favouriteUser) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                favouriteUserDao.delete(favouriteUser);
            }
        });
    }

    public void deleteAllUsers() {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                favouriteUserDao.deleteAllFavouriteUsers();
            }
        });
    }

    public LiveData<FavouriteUser> search(final String accountId) {
        return favouriteUserDao.findFavouriteUser(accountId);
    }

    public LiveData<List<FavouriteUser>> getAllFavouriteUsers() {
        return favouriteUserDao.getAllFavouriteUsers();
    }
}
