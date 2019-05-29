package com.example.moviewatcher;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

   // Movies movie;
    private ArrayList<Movies> movies;
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<Movies> movies, Context mContext) {
        this.movies = movies;
        this.mContext = mContext;
    }

    public void removeMovie(Movies e) {
        movies.removeAll(movies);
        Log.d("debug", "addMovie: all removed");
    }

    public void addMovie(Movies e) {
        movies.add(e);
        Log.d("debug", "addMovie: added");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d("debug", "onBindViewHolder: called");
        Glide.with(mContext)
                .load(movies.get(position).getPoster())
                .into(holder.poster);
        holder.movie_title.setText(movies.get(position).getTitle());

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("debug", "onClick: clicked on: " + movies.get(position));

                Toast.makeText(mContext, movies.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout parent_layout;
        ImageView poster;
        TextView movie_title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent_layout = itemView.findViewById(R.id.parent_layout);
            poster = itemView.findViewById(R.id.poster);
            movie_title = itemView.findViewById(R.id.movie_title);
        }
    }
}
