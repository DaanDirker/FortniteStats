package com.example.daan.fortnitestats;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface FortniteApiService {
    String BASE_URL =  "https://api.fortnitetracker.com/v1/";
    String apiToken = "4b04a1d4-0288-4968-89cd-1796ba5fc5c2";

    Gson gson = new GsonBuilder()
            .registerTypeAdapter(User.class, new UserDeserializer())
            .create();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();


    @Headers("TRN-Api-Key:" + apiToken)
    @GET("profile/{platform}/{username}")
    Call<User> getUser(
            @Path("platform") String platform,
            @Path("username") String username
    );
}
