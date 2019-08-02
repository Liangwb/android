package com.ok.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private IntentFilter intentFilter;
    private MyReceiver myReceiver;

    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = (Button)findViewById(R.id.send);

        //动态注册广播播放器;
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.ok.broadcastreceiver.MY_BROADCAST");
        //intentFilter.setPriority(100);
        myReceiver = new MyReceiver();
        registerReceiver(myReceiver, intentFilter);


        send.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.ok.broadcastreceiver.MY_BROADCAST");//指明要发送的广播值
                sendBroadcast(intent);
                System.out.println("LWB+++++++++click");
            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}
