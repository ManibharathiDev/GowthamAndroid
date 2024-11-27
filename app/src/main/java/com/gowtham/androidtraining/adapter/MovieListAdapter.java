package com.gowtham.androidtraining.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.gowtham.androidtraining.R;
import com.gowtham.androidtraining.model.Movies;

import java.util.ArrayList;

public class MovieListAdapter extends ArrayAdapter<Movies> {



    public MovieListAdapter(@NonNull Context context, ArrayList<Movies> movies)  {
        super(context,0, movies);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_movie_list,parent,false);
        }
        Movies movies = getItem(position);
        if(movies != null)
        {
            TextView ivTitle = convertView.findViewById(R.id.tvTitle);
            TextView ivDescription = convertView.findViewById(R.id.tvDescription);
            TextView ivDuration = convertView.findViewById(R.id.tvDuration);
            TextView ivRatings = convertView.findViewById(R.id.tvRatings);

            ivTitle.setText(movies.getName());
            ivDescription.setText(movies.getDescription());
            ivDuration.setText(movies.getDuration());
            ivRatings.setText(movies.getRating());
        }
        return convertView;
    }
}
