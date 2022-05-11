

package com.example.helloworld2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView settingBtn = (ImageView)findViewById(R.id.imageView2);

        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Setting.class));
            }
        });
    }
    public void launchCollegeList(View v) {
        Intent i = new Intent(this, CollegeListActivity.class);
        startActivity(i);
    }

    public void launchCollegeSearch(View v) {
        // Intent i = new Intent(this, CollegeSearch.class);
        // startActivity(i);
    }

    public void launchStandardizedTesting(View v) {
        Intent i = new Intent(this, StandardizedTestingActivity.class);
        startActivity(i);
    }

    public void launchAbout(View v) {
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }
}