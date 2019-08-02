package com.ok.orderedbroadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button send;
    private IntentFilter intentFilter;
    private AnotherReceiver anotherReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = (Button)findViewById(R.id.send);


        //动态注册广播播放器;
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.ok.broadcastreceiver.MY_BROADCAST");
        anotherReceiver = new AnotherReceiver();
        registerReceiver(anotherReceiver, intentFilter);


        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.ok.broadcastreceiver.MY_BROADCAST");
                sendOrderedBroadcast(intent,null);

            }
        });
    }
}
