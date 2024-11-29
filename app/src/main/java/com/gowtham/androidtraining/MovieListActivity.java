package com.gowtham.androidtraining;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.gowtham.androidtraining.adapter.MovieAdapter;
import com.gowtham.androidtraining.models.Movies;

import java.util.ArrayList;

public class MovieListActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Movies> moviesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_movie_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.lvMovieList);
        moviesArrayList = new ArrayList<>();

        Movies movies = new Movies();
        movies.setTitle("Batman");
        movies.setDescription("Adventure Action Movie");
        moviesArrayList.add(movies);

        movies = new Movies();
        movies.setTitle("Spiderman");
        movies.setDescription("Adventure Fun Packed Action Movie");
        moviesArrayList.add(movies);

        movies = new Movies();
        movies.setTitle("Avengers");
        movies.setDescription("Kids Adventure Action Movie");
        moviesArrayList.add(movies);

        movies = new Movies();
        movies.setTitle("IronMan");
        movies.setDescription("Adventure Action Movie");
        moviesArrayList.add(movies);

        movies = new Movies();
        movies.setTitle("Thor");
        movies.setDescription("Adventure Action Movie");
        moviesArrayList.add(movies);

        movies = new Movies();
        movies.setTitle("Hulk");
        movies.setDescription("Adventure Action Movie");
        moviesArrayList.add(movies);

        movies = new Movies();
        movies.setTitle("Captain America");
        movies.setDescription("Adventure Action Movie");
        moviesArrayList.add(movies);

        movies = new Movies();
        movies.setTitle("Batman");
        movies.setDescription("Adventure Action Movie");
        moviesArrayList.add(movies);

        movies = new Movies();
        movies.setTitle("Spiderman");
        movies.setDescription("Adventure Fun Packed Action Movie");
        moviesArrayList.add(movies);

        MovieAdapter movieAdapter = new MovieAdapter(this, moviesArrayList);
        listView.setAdapter(movieAdapter);

        listView.setVisibility(View.GONE);

        listView.setOnItemClickListener((adapterView, view, index, l) -> {
            Movies movies1 = moviesArrayList.get(index);
            Toast.makeText(getApplicationContext(), "You have selected " + movies1.getTitle(), Toast.LENGTH_SHORT).show();
        });

        Spinner pSpinner = findViewById(R.id.spMovies);
        pSpinner.setAdapter(movieAdapter);

        pSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Movies movies1 = moviesArrayList.get(i);
                Toast.makeText(getApplicationContext(), "You have selected " + movies1.getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button getItemBtn = findViewById(R.id.getItem);
        getItemBtn.setOnClickListener(view -> {
            int position = pSpinner.getSelectedItemPosition();
            Toast.makeText(getApplicationContext(), "You have selected " + moviesArrayList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        });



    }
}