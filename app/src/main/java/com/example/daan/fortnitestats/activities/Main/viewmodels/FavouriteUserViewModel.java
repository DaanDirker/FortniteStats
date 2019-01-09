package com.example.daan.fortnitestats.activities.Main.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.daan.fortnitestats.models.FavouriteUser;
import com.example.daan.fortnitestats.services.repositories.FavouriteUserRepository;

import java.util.List;

public class FavouriteUserViewModel extends AndroidViewModel {

    private FavouriteUserRepository repository;
    private LiveData<List<FavouriteUser>> allFavouriteUsers;

    public FavouriteUserViewModel(Application application) {
        super(application);
        repository = new FavouriteUserRepository(application);
        allFavouriteUsers = repository.getAllFavouriteUsers();
    }

    public void insert(FavouriteUser favouriteUser) {
        repository.insert(favouriteUser);
    }

    public void update(FavouriteUser favouriteUser) {
        repository.update(favouriteUser);
    }

    public void delete(FavouriteUser favouriteUser) {
        repository.delete(favouriteUser);
    }

    public LiveData<FavouriteUser> search(String accountId) {
        return repository.search(accountId);
    }

    public void deleteAllUsers() {
        repository.deleteAllUsers();
    }

    public FavouriteUser getSingleUser(int position) {
        return allFavouriteUsers.getValue().get(position);
    }

    public LiveData<List<FavouriteUser>> getAllFavouriteUsers() {
        return allFavouriteUsers;
    }
}
