/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO (1) Create a field to store the weather display TextView
    TextView weather_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        // TODO (2) Use findViewById to get a reference to the weather display TextView
        weather_view = (TextView) findViewById(R.id.tv_weather_data);

        // TODO (3) Create an array of Strings that contain fake weather data
        String[] fake_data = {"Today, Jan 12 - Sunny - 17°C / 15°C",
                              "Yesterday, Jan 11 - Rainy - 47°C / 35°C",
                              "Jan 10 - HOT - 80°C / 65°C",
                              "Jan 9 - Freezing - 0°C / 0°C",
                              "Jan 8 - HOT - 80°C / 65°C",
                              "Jan 7 - Freezing - 0°C / 0°C",
                              "Jan 6 - HOT - 80°C / 65°C",
                              "Jan 5 - Partly Cloudy - 34°C / 32°C",
                              "Jan 4 - HOT - 45°C / 54°C",
                              "Jan 3 - Rainy - 23°C / 32°C",
        };

        // TODO (4) Append each String from the fake weather data array to the TextView
        for (String str : fake_data) {
            weather_view.append(str + "\n\n");

        }
    }
}