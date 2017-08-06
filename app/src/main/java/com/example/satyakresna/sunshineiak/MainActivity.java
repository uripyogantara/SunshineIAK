package com.example.satyakresna.sunshineiak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.satyakresna.sunshineiak.adapter.ForecastAdapter;
import com.example.satyakresna.sunshineiak.model.DummyForecast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private List<DummyForecast> dummyForecastList = new ArrayList<>();
    @BindView(R.id.rv_forecast) RecyclerView mRecyclerView;
    private ForecastAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mAdapter = new ForecastAdapter(dummyForecastList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(mAdapter);

        populateData();
    }

    private void populateData() {
        for (int i = 0; i <= 10; i++) {
            DummyForecast dummyForecast = new DummyForecast("Sunday", "Sunny", 23, 18, R.drawable.art_clear);
            dummyForecastList.add(dummyForecast);
        }
        mAdapter.notifyDataSetChanged();
    }
}
