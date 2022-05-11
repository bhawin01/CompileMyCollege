package com.example.helloworld2020;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.BitSet;

public class ReminderBroadcast extends BroadcastReceiver {
    public ReminderBroadcast() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyStudy")
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Study Reminder")
                .setContentText("Make sure to study today!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(200, builder.build());

        Intent intent1 = new Intent(context, ReminderBroadcast.class);
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent1, 0);
        final AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (1000*10*6*60*24), pendingIntent);
    }
}
