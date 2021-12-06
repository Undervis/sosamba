package com.example.sosamba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<Film> filmList;

    public FilmAdapter(Context context, List<Film> list){
        this.filmList = list;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Film film = filmList.get(position);
        holder.tvText.setText(film.getFilmName());
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tvItem);
        }
    }
}
