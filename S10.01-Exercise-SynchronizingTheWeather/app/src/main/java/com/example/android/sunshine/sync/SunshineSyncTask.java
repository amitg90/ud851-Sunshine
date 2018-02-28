package com.example.android.sunshine.sync;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import java.net.URL;

//  TODO (1) Create a class called SunshineSyncTask
//  TODO (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
//      TODO (3) Within syncWeather, fetch new weather data
//      TODO (4) If we have valid results, delete the old data and insert the new
public class SunshineSyncTask {
    synchronized public static void syncWeather(Context context) {
        try {
            URL weatherRequestUrl = NetworkUtils.getUrl(context);

            Log.e("!!!AMIT", "Getting weather data");

            String jsonResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);

            Log.e("!!!AMIT", "Got weather data");

            ContentValues[] value = OpenWeatherJsonUtils.getWeatherContentValuesFromJson(context, jsonResponse);

            if (value != null && value.length != 0) {
                ContentResolver resolver = context.getContentResolver();

                resolver.delete(WeatherContract.WeatherEntry.CONTENT_URI, null, null);

                resolver.bulkInsert(WeatherContract.WeatherEntry.CONTENT_URI, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}