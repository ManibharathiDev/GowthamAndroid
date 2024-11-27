package com.gowtham.androidtraining.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gowtham.androidtraining.R;

public class AdapterActivity extends AppCompatActivity {


    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        String[] movies = {"Batman","SpiderMan","Avengers","IronMan","Thor"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,movies);
        listView = findViewById(R.id.ivListData);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            String movie = movies[i];
            Toast.makeText(this, movie, Toast.LENGTH_SHORT).show();
        });
    }
}
