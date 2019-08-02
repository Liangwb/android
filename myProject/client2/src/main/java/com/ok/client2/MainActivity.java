package com.ok.client2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ok.myproject.IStudentService;
import com.ok.myproject.ITaskCallback;

public class MainActivity extends AppCompatActivity {

    public TextView myinfo;
    private Button myconnect;
    private IStudentService iStudentService;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            Log.e("##########LWB", "onServiceConnected successfully   1");
            iStudentService = IStudentService.Stub.asInterface(iBinder);

            try{
                if(iStudentService != null){
                    Log.e("LWB", "onServiceConnected successfully    2");
                    iStudentService.registerCallback(mCallback);

                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            iStudentService = null;
            Log.e("LWB", "onServiceDisconnected--------------");

        }
    };

    public ITaskCallback mCallback = new ITaskCallback.Stub() {

        @Override
        public void actionSave(String info) throws RemoteException {
            myinfo.setText(info);
            //myconnect.setText(info);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myconnect =(Button)findViewById(R.id.conct);
        myinfo = (TextView)findViewById(R.id.myinfo);

        Intent intent = new Intent();
        //在5.0及以上版本必须要加上这个
        intent.setPackage("com.ok.myproject");
        intent.setAction("com.ok.myproject.StudentService");
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);


        myconnect.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Log.e("###########LWB","connect Successfully");
                Intent intent = new Intent();
                //在5.0及以上版本必须要加上这个
                intent.setPackage("com.ok.myproject");
                intent.setAction("com.ok.myproject.StudentService");
                bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

            }
        });
    }
}
