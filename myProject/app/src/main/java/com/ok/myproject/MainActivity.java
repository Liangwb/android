package com.ok.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*1.oncreate（）  activity被创建的时候调用的方法， ui界面的初始化 setContentView（）
        * 2.onDestroy（） activity被销毁的时候调用的方法,例如界面退出之前的扫尾操作，短信发送器，退出前数据的保存。
        * 3. onStart() activity的界面用户可见，更新ui的操作，播放视频
        * 4.onStop() activity的界面用户不再可见，界面不可见，暂停视频播放
        * 5.onResume()    ==>界面获取到了焦点，按钮可以相应点击事件
        * 6. onPause()   界面失去焦点，按钮可以相应点击事件
        * 7. onRestart() activity 被最小化，并没有销毁，如果下次再去 打开这个activity重新用户界面可见
        *
        * ###完整生命周期（entire lifetime）
            onCreate-->onStart-->onResume-->onPause-->onStop-->onDestory


            ###可视生命周期（visible lifetime）
            onStart-->onResume-->onPause-->onStop


            ###前台生命周期（foreground lifetime）
            onResume-->onPause
        * */

        super.onCreate(savedInstanceState);     //  activity被创建的时候调用的方法
        setContentView(R.layout.activity_main);     // ui界面的初始化
        Log.e("##########LWB", "server onCreate successfully");

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        Intent startService = new Intent(MainActivity.this,StudentService.class);
        startService(startService);


    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();



}
