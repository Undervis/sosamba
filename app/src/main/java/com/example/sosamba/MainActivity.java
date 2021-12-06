package com.example.sosamba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Film> films = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int token = getIntent().getIntExtra("token", 0);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        FilmAdapter adapter = new FilmAdapter(MainActivity.this, films);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        films.add(new Film("Геи нигеры в космосе"));
        films.add(new Film("Геи нигеры в говне"));
        films.add(new Film("Геи нигеры ебутся в жопу 2"));
    }
}