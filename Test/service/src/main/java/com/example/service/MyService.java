package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Mybind();
    }

    class Mybind extends Cal.Stub {

        @Override
        public int foctorial(int num) throws RemoteException{
            int sum=1;
            for(int i=1; i<=num;i++)
            {
                sum*=i;
            }

            return sum;
        }
    }
}