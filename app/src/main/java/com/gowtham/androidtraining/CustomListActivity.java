package com.gowtham.androidtraining;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.gowtham.androidtraining.adapter.MovieListAdapter;
import com.gowtham.androidtraining.model.Movies;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {

    ArrayList<com.gowtham.androidtraining.model.Movies> moviesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_list);

        ListView listView = findViewById(R.id.ivListData);
        moviesArrayList = new ArrayList<>();
        com.gowtham.androidtraining.model.Movies movies = new Movies();
        movies.setName("Batman");
        movies.setDescription("Batman Description");
        movies.setDuration("3");
        movies.setRating("5");
        moviesArrayList.add(movies);

        movies = new Movies();
        movies.setName("Batman");
        movies.setDescription("Batman Description");
        movies.setDuration("3");
        movies.setRating("5");
        moviesArrayList.add(movies);

        MovieListAdapter movieListAdapter = new MovieListAdapter(this,moviesArrayList);
        listView.setAdapter(movieListAdapter);



    }
}