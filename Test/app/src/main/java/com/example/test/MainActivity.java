package com.example.test;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.service.Cal;

public class MainActivity extends Activity {

    private Button myButton;
    private TextView result;
    private EditText param;
    private Cal cal;



    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            cal = Cal.Stub.asInterface(service);
            try {
                int num = 0;
                num= (int)Cal.foctorial(Integer.parseInt(param.getText().toString());

                result.setText(String.valueOf(num));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            cal = null;

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
