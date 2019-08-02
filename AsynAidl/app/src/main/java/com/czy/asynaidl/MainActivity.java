package com.czy.asynaidl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import com.czy.server.ITaskCallback;
import com.czy.server.ITaskBinder;

public class MainActivity extends AppCompatActivity {

    private final String TAG="client";

    private  boolean connected= true;

    private ServiceConnection mServiceConnection = new ServiceConnection(){

       @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ITaskBinder iTaskBinder = ITaskBinder.Stub.asInterface(iBinder);

            try {
                if (iTaskBinder != null) {
                    iTaskBinder.registerCallback(mCallback);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };



    private ITaskCallback mCallback = new ITaskCallback.Stub() {
        public void actionPerformed(int id) {
            Log.e("123", "calculation" + id);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.e("123", "calculation");

        //使用意图对象绑定开启服务
        Intent intent = new Intent();
        //在5.0及以上版本必须要加上这个
        intent.setPackage("com.czy.server");
        intent.setAction("com.czy.server.MAIDLService");

        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);


    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        if (mServiceConnection != null) {
            unbindService(mServiceConnection);
        }
    }




}
