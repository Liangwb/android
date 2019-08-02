package com.example.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.service.MyAIDLTest;
import com.example.service.Student;

/**
 * Created by Administrator on 2018/6/20.
 */

public class MyServer extends Service {


    MyAIDLTest.Stub stub = new MyAIDLTest.Stub() {
        @Override
        public int add(int arg1, int arg2) throws RemoteException {
            return arg1 + arg2;
        }

        @Override
        public String inStudentInfo(Student student) throws RemoteException {
            String msg = "table1" + "\n" + "----------------------------------------------" + "\n" + "|" +
                    " id " + "|" + " " +
                    "age " +
                    "|" + " name " + "|" + " className " + "|" + "\n" +
                    "----------------------------------------------" + "\n" + "|  " + student.getId() + " " +
                    "|  " + student
                    .getAge() + "  |  " + student.getName() + "   |     " + student.getClassName() + "   | " +
                    "\n" + "----------------------------------------------";
            return msg;
        }

        @Override
        public String outStudentInfo(Student student) throws RemoteException {
            String msg = student.getId() + " " +
                    "|  " + student
                    .getAge() + "  |  " + student.getName() + "   |     " + student.getClassName() + "   | ";
            return msg;
        }

        @Override
        public String inOutStudentInfo(Student student) throws RemoteException {
            student.setClassName("090411");
            student.setAge(22);
            String msg = "table3" + "\n" + "----------------------------------------------" + "\n" + "|" +
                    " id " + "|" + " " +
                    "age " +
                    "|" + " name " + "|" + " className " + "|" + "\n" +
                    "----------------------------------------------" + "\n" + "|  " + student.getId() + " " +
                    "|  " + student
                    .getAge() + "  |  " + student.getName() + "   |     " + student.getClassName() + "   | " +
                    "\n" + "----------------------------------------------";
            return msg;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("PDA", "MyServer_onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.v("PDA", "MyServer_onRebind");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.v("PDA", "MyServer_onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("PDA", "MyServer_onDestroy");
    }

    /**
     * get current process name
     *
     * @param context
     * @return
     */
    private String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
