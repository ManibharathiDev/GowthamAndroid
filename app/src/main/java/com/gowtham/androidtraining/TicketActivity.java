package com.gowtham.androidtraining;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TicketActivity extends AppCompatActivity {

    Button btnSuccess;
    private Movies movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ticket);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            movies = intent.getParcelableExtra("movies",Movies.class);
        }

        TextView movieName = findViewById(R.id.tvTitle);
        movieName.setText(movies.getTitle());
        TextView movieDescription = findViewById(R.id.tvDescription);
        movieDescription.setText(movies.getDescription());
        TextView movieJourner = findViewById(R.id.tvMovieJourner);
        movieJourner.setText(movies.getJourner());



        /*String title = intent.getStringExtra("title");
        TextView movieName = findViewById(R.id.tvTitle);
        movieName.setText(title);

        btnSuccess = findViewById(R.id.btnSuccess);
        btnSuccess.setOnClickListener(view -> {
            Intent intents = getIntent();
            intents.putExtra("result","success");
            setResult(RESULT_OK,intents);
            finish();
        });*/

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Intent intents = getIntent();
//        intents.putExtra("result","success");
//        setResult(RESULT_OK,intents);
    }
}