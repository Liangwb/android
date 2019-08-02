package com.ok.client1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.constraintlayout.widget.Barrier;

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
import android.widget.EditText;
import android.widget.TextView;
import com.ok.myproject.IStudentService;
import com.ok.myproject.ITaskCallback;
import com.ok.myproject.Student;

public class MainActivity extends AppCompatActivity {

    private IStudentService iStudentService=null;
    private static Student newStudent = new Student();
    private EditText editTextid;
    private EditText editTextname;
    private EditText editTextsex;
    private EditText editTextscore;
    private Button conServer;

    private Button dataSubmit;
    public TextView infoPlay;

    private ITaskCallback mCallback = new ITaskCallback.Stub() {

        @Override
        public void actionSave(String info) throws RemoteException {
            if(info!=null)
                infoPlay.setText(info);
            else
                infoPlay.setText("nothing");
        }
    };

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
            Log.e("LWB", "onServiceDisconnected successfully");

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextid = (EditText)findViewById(R.id.editTextId);
        editTextname = (EditText) findViewById(R.id.editTextName);
        editTextsex =(EditText) findViewById(R.id.editTextSex);
        editTextscore =(EditText)findViewById(R.id.editTextScore);
        conServer = (Button) findViewById(R.id.conServer);
        dataSubmit = (Button) findViewById(R.id.dataSubmit);
        infoPlay = (TextView) findViewById(R.id.InfoPlay);

        Log.e("##########LWB", "client1 onCreate successfully");

        dataSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Student newStudent = new Student();
                newStudent.setId(1);
                newStudent.setName("nihao");
                newStudent.setSex("男");
                newStudent.setSorce(90.0);
                if(editTextid.length()!=0)
                {
                    newStudent.setId(Integer.parseInt(editTextid.getText().toString()));
                }

                if(editTextname.length()!=0)
                {
                    newStudent.setName(editTextname.getText().toString());
                }

                if(editTextsex.length()!=0)
                {
                    newStudent.setSex(editTextsex.getText().toString());
                }

                if(editTextscore.length()!=0)
                {
                    newStudent.setSorce(Integer.parseInt(editTextscore.getText().toString()));
                }









                try{
                    if(iStudentService != null){
                        Log.e("LWB", "dataSubmit Click successfully    ");
                        iStudentService.mySava(newStudent);


                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        conServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("##########LWB", "click");
                Intent intent = new Intent();
                //在5.0及以上版本必须要加上这个
                intent.setPackage("com.ok.myproject");
                intent.setAction("com.ok.myproject.StudentService");
                bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

            }
        });


    }



}
