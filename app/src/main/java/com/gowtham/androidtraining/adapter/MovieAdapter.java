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
import com.gowtham.androidtraining.models.Movies;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movies>
{

    public MovieAdapter(@NonNull Context context,  @NonNull ArrayList<Movies> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = initView(convertView,parent,position);
        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = initView(convertView,parent,position);
        return convertView;
    }

    private View initView(View convertView,ViewGroup parent,int position){
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_movies, parent, false);
        }

        TextView tvTitle = convertView.findViewById(R.id.tvTitle);
        TextView tvDescription = convertView.findViewById(R.id.tvDescription);

        Movies movies = getItem(position);
        if(movies != null) {
            tvTitle.setText(movies.getTitle());
            tvDescription.setText(movies.getDescription());
        }

        return convertView;
    }
}
