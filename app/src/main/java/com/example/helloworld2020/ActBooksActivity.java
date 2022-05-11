package com.example.helloworld2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class ActBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_books);

        Button officialBookBtn = (Button)findViewById(R.id.officialButton);
        officialBookBtn.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.amazon.com/Official-ACT-Prep-Guide-2020/dp/1119685761/ref=zg_bs_11670_1?_encoding=UTF8&psc=1&refRID=EG4T4NGNJA5HTBJGWG92");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button barronsActBookBtn = (Button)findViewById(R.id.barronsActBookButton);
        barronsActBookBtn.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.amazon.com/Barrons-6-ACT-Practice-Tests/dp/143801063X/ref=zg_bs_11670_7?_encoding=UTF8&psc=1&refRID=EG4T4NGNJA5HTBJGWG92");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button kaplanActBookBtn = (Button)findViewById(R.id.kaplanActBookButton);
        kaplanActBookBtn.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.amazon.com/ACT-Prep-Plus-2021-Strategies/dp/150626249X/ref=zg_bs_11670_6?_encoding=UTF8&psc=1&refRID=EG4T4NGNJA5HTBJGWG92");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button princetonReviewActBookBtn = (Button)findViewById(R.id.princetonReviewActButton);
        princetonReviewActBookBtn.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.amazon.com/Princeton-Review-Premium-Prep-2020/dp/0525568808/ref=zg_bs_11670_3?_encoding=UTF8&psc=1&refRID=EG4T4NGNJA5HTBJGWG92");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }
}