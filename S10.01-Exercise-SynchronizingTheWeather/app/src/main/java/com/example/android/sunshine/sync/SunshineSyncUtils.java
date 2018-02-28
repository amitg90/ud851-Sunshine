package com.example.android.sunshine.sync;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.android.sunshine.sync.SunshineSyncIntentService;

// TODO (9) Create a class called SunshineSyncUtils
    //  TODO (10) Create a public static void method called startImmediateSync
    //  TODO (11) Within that method, start the SunshineSyncIntentService
public class SunshineSyncUtils {
    public static void startImmediateSync(Context context) {
        Log.e("!!!AMIT", "Creating new service");
        Intent intent = new Intent(context, SunshineSyncIntentService.class);
        context.startService(intent);
        Log.e("!!!AMIT", "Started new service");
    }
}