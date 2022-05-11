package com.example.helloworld2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SatPrepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sat_prep);

       Button  satPrepBooksBtn = (Button)findViewById(R.id.satPrepBooksButton);
        satPrepBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SatPrepActivity.this,
                        SatBooksActivity.class));
            }
        });

        Button khanAcademy = (Button)findViewById(R.id.khanAcademyButton);
        khanAcademy.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.khanacademy.org/sat");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }
}