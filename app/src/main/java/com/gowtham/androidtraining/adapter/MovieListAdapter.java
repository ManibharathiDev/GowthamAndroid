package com.gowtham.androidtraining.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gowtham.androidtraining.R;
import com.gowtham.androidtraining.listeners.ClickListers;
import com.gowtham.androidtraining.models.Movies;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MoviewViewHolder>
{
    private Context context;
    private ArrayList<Movies> moviesArrayList;
    private ClickListers clickListers;
    public MovieListAdapter(Context context, ArrayList<Movies> arrayList, ClickListers clickListers)
    {
        this.context = context;
        this.moviesArrayList = arrayList;
        this.clickListers = clickListers;
    }

    @NonNull
    @Override
    public MoviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movies,parent,false);
        return new MoviewViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviewViewHolder holder, int position) {
        Movies movies = moviesArrayList.get(position);
        holder.tvTitle.setText(movies.getTitle());
        holder.tvDescription.setText(movies.getDescription());
        holder.parentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListers.onRecyclerViewClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesArrayList.size();
    }

    public class MoviewViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView tvTitle;
        private final TextView tvDescription;
        private final LinearLayout parentView;
        public MoviewViewHolder(@NonNull View itemView) {
            super(itemView);
            parentView = itemView.findViewById(R.id.parentView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }

}
