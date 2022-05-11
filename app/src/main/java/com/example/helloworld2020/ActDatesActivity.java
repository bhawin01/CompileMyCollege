package com.example.helloworld2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ActDatesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_dates);

        ArrayList<String> satDates = new ArrayList<>();

        TextView textView = (TextView)findViewById(R.id.actDatesTextView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        String data = "";

        StringBuffer sbuffer = new StringBuffer();

        InputStream is = this.getResources().openRawResource(R.raw.actdates);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        if (is != null) {
            try {
                while ((data = reader.readLine()) != null) {
                    sbuffer.append(data + "\n");
                }
                textView.setText(sbuffer);
                is.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}