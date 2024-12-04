package com.gowtham.androidtraining;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.gowtham.androidtraining.adapter.MovieListAdapter;
import com.gowtham.androidtraining.listeners.ClickListers;
import com.gowtham.androidtraining.models.Movies;

import java.util.ArrayList;

public class RecylerViewActivity extends AppCompatActivity implements ClickListers {

    ArrayList<Movies> moviesArrayList;
    RecyclerView rvMovies;
    MovieListAdapter movieListAdapter;

    private TextView etTitle;
    private TextView etDescription;

    private Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment);
        setUI();
        init();
        setAdapter();
        setListeners();
    }

    private void setAdapter()
    {
        movieListAdapter = new MovieListAdapter(this,moviesArrayList,this);
        rvMovies.setAdapter(movieListAdapter);
    }

    private void setListeners()
    {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValid = true;
                if(etTitle.getText().toString().isEmpty())
                {
                    etTitle.setError("Please Enter Title");
                    isValid = false;
                }
                if(etDescription.getText().toString().isEmpty())
                {
                    etDescription.setError("Please Enter Description");
                    isValid = false;
                }

                if(!isValid) {
                    Toast.makeText(getApplicationContext(),"Invalid Data",Toast.LENGTH_SHORT).show();
                }
                else{
                    Movies movies = new Movies();
                    movies.setTitle(etTitle.getText().toString());
                    movies.setDescription(etDescription.getText().toString());
                    moviesArrayList.add(0,movies);
                    movieListAdapter.notifyItemInserted(0);
                    rvMovies.scrollToPosition(0);
                    etTitle.setText("");
                    etDescription.setText("");

                    //movieListAdapter.notifyDataSetChanged();
                    //moviesArrayList.add(movies);
                    //movieListAdapter.notifyDataSetChanged();

                }
            }
        });
    }

    private void setUI(){
        rvMovies = findViewById(R.id.rvMovies);
        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.etDescription);

        btnSubmit = findViewById(R.id.btnAdd);
    }

    private void init(){
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
    }

    @Override
    public void onRecyclerViewClick(int position) {
        Movies movies = moviesArrayList.get(position);
        Toast.makeText(getApplicationContext(),"You have selected "+movies.getTitle(),Toast.LENGTH_SHORT).show();
    }
}
