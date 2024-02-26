package com.example.totalbattle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClickListener{

    private RecyclerView recyclerView;
    private PreferenceManager preferenceManager;

    private TextView sumTextView;

    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        sumTextView = findViewById(R.id.sum);

        preferenceManager = new PreferenceManager(getApplicationContext());

        total = preferenceManager.getInt(Constants.KEY_SUM);

        sumTextView.setText(total + "");

        List<Model> items = new ArrayList<>();

        items.add(new Model(
                R.drawable.citadel_10,
                Constants.KEY_CITADEL_10_POINT,
                Constants.KEY_CITADEL_10_NAME,
                preferenceManager.getInt(Constants.KEY_CITADEL_10),
                Constants.KEY_CITADEL_10));

        items.add(new Model(
                R.drawable.citadel_15,
                Constants.KEY_CITADEL_15_POINT,
                Constants.KEY_CITADEL_15_NAME,
                preferenceManager.getInt(Constants.KEY_CITADEL_15),
                Constants.KEY_CITADEL_15));

        items.add(new Model(
                R.drawable.citadel_10,
                Constants.KEY_CITADEL_20_POINT,
                Constants.KEY_CITADEL_20_NAME,
                preferenceManager.getInt(Constants.KEY_CITADEL_20),
                Constants.KEY_CITADEL_20));

        items.add(new Model(
                R.drawable.citadel_15,
                Constants.KEY_COMMON_CRYPT_5_POINT,
                Constants.KEY_COMMON_CRYPT_5_NAME,
                preferenceManager.getInt(Constants.KEY_COMMON_CRYPT_5),
                Constants.KEY_COMMON_CRYPT_5));


        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setAdapter(new Adapter(this, items, this));


    }

    @Override
    public void onItemClick(String key, int sum, int point) {

        preferenceManager.putInt(key, preferenceManager.getInt(key) + sum);

        total = preferenceManager.getInt(Constants.KEY_SUM) + point;

        preferenceManager.putInt(Constants.KEY_SUM, total);
        sumTextView.setText(total + "");
    }
}