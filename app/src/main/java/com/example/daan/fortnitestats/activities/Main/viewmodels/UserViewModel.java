package com.example.daan.fortnitestats.activities.Main.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.daan.fortnitestats.models.User;
import com.example.daan.fortnitestats.services.api.FortniteApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {

    private FortniteApiService apiService;
    private MutableLiveData<User> user = new MutableLiveData<>();

    public UserViewModel() {
        this.apiService = FortniteApiService.retrofit.create(FortniteApiService.class);
    }

    public void fetchUser(String platform, String username) {

        apiService.getUser(platform, username).enqueue(new Callback<User>() {
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
    }

    public MutableLiveData<User> getUser() {
        return this.user;
    }
}
