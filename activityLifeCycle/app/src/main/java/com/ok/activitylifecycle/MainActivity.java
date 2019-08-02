package com.ok.activitylifecycle;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView tv;
    private int blood = 100 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("主界面界面被创建了");
        //finish() ;
        //拿到怪物的血槽
        tv = (TextView) findViewById(R.id.tv) ;
    }


    @Override
    protected void onStart() {

        super.onStart();
        System.out.println("界面可以看到了");
    }

    @Override
    protected  void onResume() {

        super.onResume();
        System.out.println("我获得焦点了");
    }

    @Override
    protected  void onRestart() {

        super.onRestart();
        System.out.println("用户重启界面了");
    }

    @Override
    protected  void onPause() {

        super.onPause();
        System.out.println("界面失去焦点了");
    }

    @Override
    protected void onStop() {

        super.onStop();
        System.out.println("界面看不见了");
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        System.out.println("界面被销毁了");
    }


    public void click(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent) ;
    }

    public void click1(View view) {

        //每点击一次，让怪物的血下降爱6点
        blood -= 6 ;
        //将血设回到怪物身上
        tv.setText(blood + "") ;
    }
}
