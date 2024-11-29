package com.gowtham.androidtraining;

import android.content.SharedPreferences;
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

public class MovieActivity extends AppCompatActivity {

    //Declaration
    ListView listView;

    Spinner pSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_movie);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initialization
        listView = findViewById(R.id.lvMovies);

        //Array Creation
        String[] movieArray = {"Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America", "Ant Man", "Black Panther", "Black Widow",
                "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America", "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America"
                , "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America", "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America"
                , "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America",
                "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America", "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America"
                , "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America", "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America"
                , "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America", "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America",
                "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America",
                "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America", "Batman", "Spiderman", "Avengers", "IronMan", "Thor", "Hulk", "Captain America"};


        //Create an Adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, movieArray);

        //Set Adapter
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Toast.makeText(getApplicationContext(), "You have selected " + movieArray[index], Toast.LENGTH_SHORT).show();
            }
        });

        Spinner spinner = findViewById(R.id.spMovies);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,movieArray);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "You have selected " + movieArray[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button getItemBtn = findViewById(R.id.getItem);
        getItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), "You have selected " + item, Toast.LENGTH_SHORT).show();
            }
        });



    }
}