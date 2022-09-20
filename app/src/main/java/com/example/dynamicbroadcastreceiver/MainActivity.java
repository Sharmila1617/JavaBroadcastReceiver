package com.example.dynamicbroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();
    String MY_RECEIVER_ACTION = "TEST MYDynamic Receiver";
 //String ACTION = "My Dynamic Receiver";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "----------->onCreate");

        IntentFilter filter = new IntentFilter();

        //property
        filter.addAction(MY_RECEIVER_ACTION);
        filter.addCategory(Intent.CATEGORY_DEFAULT);

        registerReceiver(myDynamicReceiver, filter);
    }

    public void sendDynamicReceiver(View view) {

        Log.d(TAG, "----------->DynamicReceiver");

        Intent myIntent = new Intent(MY_RECEIVER_ACTION);
        sendBroadcast(myIntent);
    }
       //  created own DynamicReceiver
    BroadcastReceiver myDynamicReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d(TAG, "----------->onReceive");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "----------->onDestroy");

        unregisterReceiver(myDynamicReceiver);
    }
}