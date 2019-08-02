package com.czy.aidlparam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;


import com.czy.server.IPersonService;
import com.czy.server.Person;


public class MainActivity extends AppCompatActivity {

    private IPersonService personService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        //在5.0及以上版本必须要加上这个
        intent.setPackage("com.czy.server");
        intent.setAction("com.czy.server.PersonService");

        //new Intent("com.czy.server.PersonService")
        this.bindService(intent, this.serviceConnection, BIND_AUTO_CREATE);//绑定到服务
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unbindService(serviceConnection);//解除服务
    }
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            personService = IPersonService.Stub.asInterface(service);
            try {
//                personService.save(new Person(56, "liming"));
                    //personService.save(new Person(56,"liming"));
            } catch (Exception e) {
                Log.e("ClientActivity", e.toString());
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            personService=null;

        }


    };
}