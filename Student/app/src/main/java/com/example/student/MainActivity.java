package com.example.student;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.service.MyAIDLTest;
import com.example.service.Student;

public class MainActivity extends AppCompatActivity {

    private EditText et_id;
    private EditText et_name;
    private EditText et_className;
    private EditText et_age;
    private EditText et_result;
    private Button btn_tj;
    private MyAIDLTest myAIDLTest;

    private ServiceConnection connection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                myAIDLTest = MyAIDLTest.Stub.asInterface(iBinder);
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
        et_id = (EditText) findViewById(R.id.et_id);
        et_name = (EditText) findViewById(R.id.et_name);
        et_className = (EditText) findViewById(R.id.et_className);
        et_age = (EditText) findViewById(R.id.et_age);
        et_result = (EditText) findViewById(R.id.et_result);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("androidpos.zy.com.aidltesttwo", "com.test.myservice.MyServer"));
        intent.setAction("com.test.aidl.myaidltest");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);

        findViewById(R.id.btn_tj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String data = myAIDLTest.add(9, 9) + "  \n" + myAIDLTest.inStudentInfo(new Student(Integer.parseInt(et_id.getText() + ""),
                            et_name.getText() + "",
                            et_className.getText() + "",
                            Integer.parseInt(et_age.getText() + "")));
                    et_result.setText(data);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}