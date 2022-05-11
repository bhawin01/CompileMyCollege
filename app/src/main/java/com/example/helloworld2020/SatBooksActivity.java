package com.example.helloworld2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SatBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sat_books);

        Button collegeBoardBookBtn = (Button)findViewById(R.id.collegeBoardBookButton);
        collegeBoardBookBtn.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.amazon.com/Official-SAT-Study-Guide-2020/dp/1457312190/ref=zg_bs_11682_1?_encoding=UTF8&psc=1&refRID=04SAHDKGFH8KZQXCEWN8");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button barronsBookBtn = (Button)findViewById(R.id.barronsBookButton);
        barronsBookBtn.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.amazon.com/Premium-Study-Guide-Practice-Tests/dp/1438012225/ref=zg_bs_11682_10?_encoding=UTF8&psc=1&refRID=04SAHDKGFH8KZQXCEWN8");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button kaplanBookBtn = (Button)findViewById(R.id.kaplanButton);
        kaplanBookBtn.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.amazon.com/SAT-Prep-Plus-2021-Strategies/dp/1506262678/ref=zg_bs_11682_13?_encoding=UTF8&psc=1&refRID=04SAHDKGFH8KZQXCEWN8");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button princetonReviewBookBtn = (Button)findViewById(R.id.princetonReviewButton);
        princetonReviewBookBtn.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.amazon.com/Princeton-Review-Premium-Prep-2021/dp/0525569340/ref=zg_bs_11682_3?_encoding=UTF8&psc=1&refRID=04SAHDKGFH8KZQXCEWN8");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }
}