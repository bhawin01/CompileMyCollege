package com.example.helloworld2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Switch darkmodeSwitch;

        darkmodeSwitch
                    = findViewById(R.id.switch3);
            SharedPreferences sharedPreferences
                    = getSharedPreferences(
                    "sharedPrefs", MODE_PRIVATE);
            final SharedPreferences.Editor editor
                    = sharedPreferences.edit();
            final boolean isDarkModeOn
                    = sharedPreferences
                    .getBoolean(
                            "isDarkModeOn", false);

            // When user reopens the app
            // after applying dark/light mode
            if (isDarkModeOn) {
                AppCompatDelegate
                        .setDefaultNightMode(
                                AppCompatDelegate
                                        .MODE_NIGHT_YES);
                darkmodeSwitch.setText(
                        "Disable Dark Mode");
            }
            else {
                AppCompatDelegate
                        .setDefaultNightMode(
                                AppCompatDelegate
                                        .MODE_NIGHT_NO);
                darkmodeSwitch
                        .setText(
                                "Enable Dark Mode");
            }

        darkmodeSwitch.setOnClickListener(
                    new View.OnClickListener() {

                        @Override
                        public void onClick(View view)
                        {
                            // When user taps the enable/disable
                            // dark mode button
                            if (isDarkModeOn) {

                                // if dark mode is on it
                                // will turn it off
                                AppCompatDelegate
                                        .setDefaultNightMode(
                                                AppCompatDelegate
                                                        .MODE_NIGHT_NO);
                                // it will set isDarkModeOn
                                // boolean to false
                                editor.putBoolean(
                                        "isDarkModeOn", false);
                                editor.apply();

                                // change text of Button
                                darkmodeSwitch.setText(
                                        "Enable Dark Mode");
                            }
                            else {

                                // if dark mode is off
                                // it will turn it on
                                AppCompatDelegate
                                        .setDefaultNightMode(
                                                AppCompatDelegate
                                                        .MODE_NIGHT_YES);

                                // it will set isDarkModeOn
                                // boolean to true
                                editor.putBoolean(
                                        "isDarkModeOn", true);
                                editor.apply();

                                // change text of Button
                                darkmodeSwitch.setText(
                                        "Disable Dark Mode");
                            }
                        }
                    });
        }
}