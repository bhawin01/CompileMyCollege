package com.example.helloworld2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActPrepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_prep);
      
        Button unionTestPrepBtn = (Button)findViewById(R.id.unionTestPrepButton);
        unionTestPrepBtn.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://uniontestprep.com/act");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button kaplanActPrepBtn = (Button)findViewById(R.id.kaplanActPrepButton);
        kaplanActPrepBtn.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.kaptest.com/act/free/act-free-practice-test");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button  actPrepBooksBtn = (Button)findViewById(R.id.actPrepBooksButton);
        actPrepBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActPrepActivity.this,
                        ActBooksActivity.class));
            }
        });
    }
}