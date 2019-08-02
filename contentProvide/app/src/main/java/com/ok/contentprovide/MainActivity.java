package com.ok.contentprovide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private Button save;



    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        setLister();
    }


    private void initview() {
        name = (EditText) findViewById(R.id.et_name);
        save = (Button) findViewById(R.id.bt_save);
    }

    private void setLister() {
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String uname = name.getText().toString().trim();
                String path = getFilesDir()+"/private.txt";
                System.out.println("LWB###########"+path);
                try {
                    FileOutputStream fos = new FileOutputStream(path);

                    fos.write(uname.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(), "保存成功",Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
