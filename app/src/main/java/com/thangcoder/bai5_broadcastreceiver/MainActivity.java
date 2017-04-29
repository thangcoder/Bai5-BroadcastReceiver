package com.thangcoder.bai5_broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    NetworkChangeReceiver networkChangeReceiver;
    private Button btnStart;
    private Button btnSend;
    public static final String ACTION_THANGCODER ="thangcoder.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.btn_start);
        btnSend = (Button) findViewById(R.id.btn_send);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(ACTION_THANGCODER,"Blog lap trinh Android");
                intent.setAction(ACTION_THANGCODER);
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        initBroadcastReceiver();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(networkChangeReceiver);
    }


    @Override
    protected void onStop() {
        super.onStop();
    }
    private void initBroadcastReceiver(){
        networkChangeReceiver = new NetworkChangeReceiver();
        IntentFilter intentFilter  = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction(ACTION_THANGCODER);
        registerReceiver(networkChangeReceiver,intentFilter);
    }
}
