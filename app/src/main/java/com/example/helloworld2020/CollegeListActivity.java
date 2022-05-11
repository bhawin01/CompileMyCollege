package com.example.helloworld2020;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CollegeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_list);

        ArrayList<String> satScores = new ArrayList<>();
        ArrayList<String> acceptanceRates = new ArrayList<>();
        ArrayList<String> collegeNames = new ArrayList<>();
        ArrayList<String> rankings = new ArrayList<>();

        //TextView textView = (TextView)findViewById(R.id.textView1);
        //textView.setMovementMethod(new ScrollingMovementMethod());

        String data = "";
        int rank = 1;

        StringBuffer sbuffer = new StringBuffer();

        InputStream is = this.getResources().openRawResource(R.raw.collegenames);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        sbuffer.append("Top 25 Computer Science Colleges in the US\n\n");

        if (is != null) {
            try {
                while ((data = reader.readLine()) != null) {
                    sbuffer.append("#" + rank + " - " + data + "\n\n");
                    rank += 1;
                }
                //textView.setText(sbuffer);
                is.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        Button stanfordBtn = (Button)findViewById(R.id.stanfordButton);
        stanfordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CollegeListActivity.this,
                        StanfordActivity.class));
            }
        });

        Button caltechBtn = (Button)findViewById(R.id.caltechButton);
        caltechBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CollegeListActivity.this,
                        CalTechActivity.class));
            }
        });

        Button carnegieBtn = (Button)findViewById(R.id.carnegieButton);
        carnegieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CollegeListActivity.this,
                        CMUActivity.class));
            }
        });

        Button harvardBtn = (Button)findViewById(R.id.harvardButton);
        harvardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CollegeListActivity.this,
                        HarvardActivity.class));
            }
        });

        Button yaleBtn = (Button)findViewById(R.id.yaleButton);
        yaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CollegeListActivity.this,
                        YaleActivity.class));
            }
        });

        Button dukeBtn = (Button)findViewById(R.id.dukeButton);
        dukeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CollegeListActivity.this,
                        DukeActivity.class));
            }
        });
    }
}