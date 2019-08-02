package com.ok.myproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

import com.ok.myproject.ITaskCallback;
import com.ok.myproject.IStudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentService extends Service {

    final List<ITaskCallback> mCallbacks = new ArrayList<ITaskCallback>();

    private ServiceBinder mBinder = new ServiceBinder();



    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }   //重点

    public class ServiceBinder extends IStudentService.Stub{

        @Override
        public void save(Student student) throws RemoteException {


        }

        @Override
        public String fileInfo() throws RemoteException {
            return getFileInfo();
        }

        @Override
        public void mySava(Student student) throws RemoteException {
            Log.e("LWB+++++++++","service: mySava");

            filesave(student);//文件保存以后;

            String datastring = fileInfo();

            final  int N = mCallbacks.size();
            for(int i = 0; i<N;i++){
                try{

                    mCallbacks.get(i).actionSave(datastring);
                }catch (RemoteException e){
                    e.printStackTrace();
                }
            }
            Log.e("##########LWB", "server file successfully");

        }

        @Override
        public void registerCallback(ITaskCallback cb) throws RemoteException {
            if(cb !=null){
                mCallbacks.add(cb);

            }

        }

        @Override
        public void unregisterCallback(ITaskCallback cb) throws RemoteException {
            if(cb != null){
                mCallbacks.remove(cb);
            }

        }
    }




    public native void filesave(Student student);
    public native String getFileInfo();




}
