package com.example.android.sunshine.sync;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

// TODO (5) Create a new class called SunshineSyncIntentService that extends IntentService
//  TODO (6) Create a constructor that calls super and passes the name of this class
//  TODO (7) Override onHandleIntent, and within it, call SunshineSyncTask.syncWeather
public class SunshineSyncIntentService extends IntentService {

    public SunshineSyncIntentService() {
        super("SunshineSyncIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("!!!AMIT", "onHandleIntent called");

        SunshineSyncTask.syncWeather(this);
    }
}
