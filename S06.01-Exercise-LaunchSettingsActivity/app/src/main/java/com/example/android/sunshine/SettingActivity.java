package com.example.android.sunshine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class SettingActivity extends AppCompatActivity {
    String weatherData = null;
    Intent intentThatStartedThisActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
                weatherData = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
                Log.e("READING", weatherData);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();

            /*
            if (intentThatStartedThisActivity != null) {
                Log.e("AMIT!!!!", "Pushing Data to activity");
                //SharedPreferences sharedPref = getSharedPreferences("myPrefs", Context.
                        MODE_PRIVATE);
                //SharedPreferences.Editor editor = sharedPref.edit();
                //editor.putString(Intent.EXTRA_TEXT, weatherData);
                //editor.commit();
            }
            */
        }
        return super.onOptionsItemSelected(item);
    }
}
