package com.thangcoder.bai5_broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by chien on 4/23/17.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(MainActivity.ACTION_THANGCODER)){
            String title = intent.getStringExtra(MainActivity.ACTION_THANGCODER);
            Toast.makeText(context, title, Toast.LENGTH_SHORT).show();
        }
//        Toast.makeText(context, "Network is turned ON/OFF", Toast.LENGTH_SHORT).show();
    }
}
