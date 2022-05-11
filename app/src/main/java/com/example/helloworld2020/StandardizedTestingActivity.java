package com.example.helloworld2020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.time.Clock;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class StandardizedTestingActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String ALARM = "alarm";
    AtomicBoolean ongoingAlarm = new AtomicBoolean(false);

    private boolean alarmOnOFf;
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standardized_testing);

        createNotificationChannel();

        String nextSatTest = "August";
        Button nextSatBtn = (Button)findViewById(R.id.nextSatDateButton);
        nextSatBtn.setText("Upcoming SAT Dates");

        String nextActTest = "August";
        Button nextActBtn = (Button)findViewById(R.id.nextActDateButton);
        nextActBtn.setText("Upcoming ACT Dates");

        Button actDatesBtn = (Button)findViewById(R.id.nextActDateButton);
        actDatesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StandardizedTestingActivity.this,
                        ActDatesActivity.class));
            }
        });

        Button satDatesBtn = (Button)findViewById(R.id.nextSatDateButton);
        satDatesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StandardizedTestingActivity.this,
                        SatDatesActivity.class));
            }
        });

        Button satPrepBtn = (Button)findViewById(R.id.satPrepButton);
        satPrepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StandardizedTestingActivity.this,
                        SatPrepActivity.class));
            }
        });

        Button actPrepBtn = (Button)findViewById(R.id.actPrepButton);
        actPrepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StandardizedTestingActivity.this,
                        ActPrepActivity.class));
            }
        });

        Button dailyAlarmButton = (Button)findViewById(R.id.dailyAlarm);

        loadData();
        updateViews();

        if(ongoingAlarm.get() == true) {
            dailyAlarmButton.setBackgroundColor(Color.GREEN);
        } else if (ongoingAlarm.get() == false) {
            dailyAlarmButton.setBackgroundColor(Color.RED);
        }


        dailyAlarmButton.setOnClickListener(v -> {
          
            Intent intent = new Intent(StandardizedTestingActivity.this,
                    ReminderBroadcast.class);
            PendingIntent pendingIntent =
                    PendingIntent.getBroadcast(StandardizedTestingActivity.this,
                            0, intent, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

            long timeAtButtonClick = System.currentTimeMillis();

            long tenSecondsInMillis = 1000 * 10;

            if (ongoingAlarm.get() == true) {
                alarmManager.cancel(pendingIntent);

                ongoingAlarm.set(false);
                dailyAlarmButton.setBackgroundColor(Color.RED);
                Toast.makeText(this, "Reminder Cancelled!", Toast.LENGTH_SHORT).show();
            } else {
                alarmManager.set(AlarmManager.RTC_WAKEUP, timeAtButtonClick +
                        (1000*10*6*60*24), pendingIntent);
                ongoingAlarm.set(true);
                dailyAlarmButton.setBackgroundColor(Color.GREEN);
                Toast.makeText(this, "Reminder Set!", Toast.LENGTH_SHORT).show();
            }
            saveData();
        });

        Button collegeBoardSiteBtn = (Button)findViewById(R.id.collegeBoardSiteButton);
        collegeBoardSiteBtn.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://collegereadiness.collegeboard.org/sat");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });

        Button actSiteBtn = (Button)findViewById(R.id.actSiteButton);
        actSiteBtn.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.act.org/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }


    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "StudyReminderChannel";
            String description = "Channel for Study Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyStudy", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
  
    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(ALARM, ongoingAlarm.get());

        editor.apply();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        alarmOnOFf = sharedPreferences.getBoolean(ALARM, false);
    }

    public void updateViews() {
        ongoingAlarm.set(alarmOnOFf);
    }
}