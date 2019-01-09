package com.example.daan.fortnitestats.services.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.daan.fortnitestats.models.User;
import com.example.daan.fortnitestats.services.api.FortniteApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private FortniteApiService apiService;
    final MutableLiveData<User> user = new MutableLiveData<>();

    public UserRepository() {
        this.apiService = FortniteApiService.retrofit.create(FortniteApiService.class);
    }

    private static final class SingletonHelper {
        private static final UserRepository INSTANCE = new UserRepository();
    }

    public static UserRepository getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public MutableLiveData<User> fetchUser(String platform, String username) {

        apiService.getUser(platform, username)
                .enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    user.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                user.setValue(null);
            }
        });
        return this.user;
    }
}
