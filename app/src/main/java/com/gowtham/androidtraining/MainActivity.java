package com.gowtham.androidtraining;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btnMovieClick(View view) {
//        Toast.makeText(this, "Movie Clicked", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, TicketActivity.class);
        intent.putExtra("title", "Batman");
        intent.putExtra("desc", "Action Thriller Movie");
        startActivity(intent);

    }
}