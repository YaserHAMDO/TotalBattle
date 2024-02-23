package com.example.totalbattle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClickListener{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);



        List<Model> items = new ArrayList<>();

        items.add(new Model(R.drawable.citadel_10, 10, "Citadel 10", 4));
        items.add(new Model(R.drawable.citadel_15, 15, "Citadel 15", 1));


        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(new Adapter(this, items, this));


    }

    @Override
    public void onItemClick(int index) {

    }
}