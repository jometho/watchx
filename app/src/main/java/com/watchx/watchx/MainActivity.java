package com.watchx.watchx;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.watchx.watchx.MESSAGE";
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    private static List<String> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFriends();
    }

    //String[] recipients = {"+254714938685", "+254718467087"};
    private void addFriends() {
        friends.add("+254718467087");
        friends.add("+254714938685");
        friends.add("+254718467087");
    }
    public void viewFriends(View view) {
        Intent intent = new Intent(this, ViewFriendsActivity.class);
        startActivity(intent);
    }

    private void checkForSmsPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, getString(R.string.permission_not_granted));
            // Permission not yet granted. Use requestPermissions().
            // MY_PERMISSIONS_REQUEST_SEND_SMS is an
            // app-defined int constant. The callback method gets the
            // result of the request.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        }
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        SmsManager sms = SmsManager.getDefault();
        if (!friends.isEmpty()) {
            for (String recipient : friends)
                sms.sendTextMessage(recipient, null, "WatchX ALERT!! From STEVE.", pi, null);
            Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                    Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "You have no friends Amigo!",
                    Toast.LENGTH_LONG).show();
        }
    }
}
