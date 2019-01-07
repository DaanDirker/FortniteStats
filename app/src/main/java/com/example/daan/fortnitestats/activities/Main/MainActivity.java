package com.example.daan.fortnitestats.activities.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.daan.fortnitestats.services.api.FortniteApiService;
import com.example.daan.fortnitestats.R;
import com.example.daan.fortnitestats.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mUsernameEdit;
    private Button mRetrieveButton;

    private FortniteApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init
        mUsernameEdit = findViewById(R.id.usernameEdit);
        mRetrieveButton = findViewById(R.id.retrieveButton);
        apiService = FortniteApiService.retrofit.create(FortniteApiService.class);

        //For testing purposes
        fetchUser("pc", "Rgamer1");

        mRetrieveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = mUsernameEdit.getText().toString();

                if (enteredUsername != null) {
                    fetchUser("pc", enteredUsername);
                }
            }
        });
    }

    private void fetchUser(String platform, String username) {
        Call<User> call = apiService.getUser(platform, username);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                Log.i("toString", user.toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Response failed", t.toString());
            }
        });
    }
}
