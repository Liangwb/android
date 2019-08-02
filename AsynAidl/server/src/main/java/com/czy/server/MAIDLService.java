package com.czy.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

public class MAIDLService extends Service {

    private void Log(String str) {
        Log.e("LWB", "----------" + str + "----------");
    }

    private final ITaskBinder.Stub mBinder = new ITaskBinder.Stub() {

        @Override
        public void stopRunningTask() throws RemoteException {
            Log("stopRunningTask");
        }


        public void onCreate() {
            Log("service created");

        }


        public void onStart(Intent intent, int startId) {
            Log("service started id = " + startId);
        }


        @Override
        public boolean isTaskRunning() {
            return false;
        }


        @Override
        public void registerCallback(ITaskCallback cb) {
            if (cb != null) {
                mCallbacks.register(cb);
                try {
                    for (int i = 1; i < 6; i++) {
                        cb.actionPerformed(i);
                        Thread.sleep(5000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        public void unregisterCallback(ITaskCallback cb) {
            if (cb != null) {
                mCallbacks.unregister(cb);
            }
        }
    };

    final RemoteCallbackList<ITaskCallback> mCallbacks = new RemoteCallbackList<ITaskCallback>();

    @Override
    public IBinder onBind(Intent intent) {
        //service on bind
        return mBinder;
    }
}
