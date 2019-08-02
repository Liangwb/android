package com.example.testtwo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.service.MyPrint;

public class MainActivity extends Activity {

    private Button myButton;
    private TextView result;
    private EditText param;
    private MyPrint myPrint;



    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("##########LWB", "onServiceConnected successfully ");
            myPrint = MyPrint.Stub.asInterface(service);
            try {
                String ret=myPrint.myFunc();
                Toast.makeText(getApplicationContext(),"hehei"+ret,Toast.LENGTH_SHORT);
                result.setText(ret) ;

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            myPrint = null;

        }

    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button) findViewById(R.id.mybutton);
        result = (TextView) findViewById(R.id.result);
        param = (EditText) findViewById(R.id.param);

        /*
         * 输入参数
         *
         * */
        param.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction("com.example.service.MyService");
                intent.setPackage("com.example.service");
                bindService(intent,connection,BIND_AUTO_CREATE);
            }

        });


    }


}

