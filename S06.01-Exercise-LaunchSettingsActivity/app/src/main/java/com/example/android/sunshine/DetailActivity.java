package com.example.android.sunshine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    private String mForecast;
    private TextView mWeatherDisplay;

    private Intent intentThatStartedThisActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Log.e("AMIT", "!!!DetailActivity onCreate Triggered");

        mWeatherDisplay = (TextView) findViewById(R.id.tv_display_weather);

        intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity != null) {
            Log.e("AMIT", "!!!DetailActivity activity found");

            if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
                Log.e("AMIT", "!!!DetailActivity activity found DATA!!");
                mForecast = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
                mWeatherDisplay.setText(mForecast);
            } else {
                SharedPreferences sharedPref = getSharedPreferences("myPrefs", Context.
                        MODE_PRIVATE);
                String theme=sharedPref.getString(Intent.EXTRA_TEXT,"");
                mWeatherDisplay.setText(theme);
            }
        }
    }

    /**
     * Uses the ShareCompat Intent builder to create our Forecast intent for sharing. We set the
     * type of content that we are sharing (just regular text), the text itself, and we return the
     * newly created Intent.
     *
     * @return The Intent to use to start our share.
     */
    private Intent createShareForecastIntent() {
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText(mForecast + FORECAST_SHARE_HASHTAG)
                .getIntent();
        return shareIntent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForecastIntent());
        return true;
    }

    // TODO (7) Launch SettingsActivity when the Settings option is clicked

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.detail_settings) {
            Intent intent = new Intent(this, SettingActivity.class);
            intent.putExtra(Intent.EXTRA_TEXT, mWeatherDisplay.getText().toString());
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}