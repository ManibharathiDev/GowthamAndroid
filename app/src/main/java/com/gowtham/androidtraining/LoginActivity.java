package com.gowtham.androidtraining;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    EditText userName;
    EditText password;
    Button login;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        sharedPreferences = getApplicationContext().getSharedPreferences("LOGIN_PREF", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        String username = sharedPreferences.getString("username","");
        Log.e(TAG, "username: "+username);

        if(!sharedPreferences.getString("username","").isEmpty())
        {
            startActivity(new Intent(LoginActivity.this,MovieListActivity.class));
            finish();
        }

        login.setOnClickListener(view -> {
            editor.putString("username",userName.getText().toString());
            editor.putString("password",password.getText().toString());
            editor.commit();
            startActivity(new Intent(LoginActivity.this, MovieActivity.class));
            finish();
        });

    }
}
