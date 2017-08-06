package com.example.satyakresna.sunshineiak.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.satyakresna.sunshineiak.R;
import com.example.satyakresna.sunshineiak.model.DummyForecast;

import java.util.List;

/**
 * Created by satyakresna on 06-Aug-17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = ForecastAdapter.class.getSimpleName();
    private List<DummyForecast> dummyForecastList;

    public ForecastAdapter(List<DummyForecast> dummyForecastList) {
        this.dummyForecastList = dummyForecastList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutFromListItem = R.layout.row_forecast_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutFromListItem, parent, shouldAttachToParentImmediately);
        ForecastViewHolder viewHolder = new ForecastViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ForecastViewHolder) holder).bind(dummyForecastList.get(position));
    }

    @Override
    public int getItemCount() {
        return dummyForecastList.size();
    }

    private class ForecastViewHolder extends RecyclerView.ViewHolder {
        ImageView weatherIcon;
        TextView day;
        TextView weather;
        TextView minTemp;
        TextView maxTemp;

        public ForecastViewHolder(View itemView) {
            super(itemView);
            weatherIcon = (ImageView) itemView.findViewById(R.id.iv_weather_icon);
            day = (TextView) itemView.findViewById(R.id.tv_day);
            weather = (TextView) itemView.findViewById(R.id.tv_weather);
            minTemp = (TextView) itemView.findViewById(R.id.tv_min_temp);
            maxTemp = (TextView) itemView.findViewById(R.id.tv_max_temp);
        }

        public void bind(DummyForecast dummyForecast) {
            weatherIcon.setImageResource(dummyForecast.getWeatherID());
            day.setText(dummyForecast.getDay());
            weather.setText(dummyForecast.getWeather());
            minTemp.setText(dummyForecast.getMinTemp()+"\u00b0");
            maxTemp.setText(dummyForecast.getMaxTemp()+"\u00b0");
        }
    }
}
