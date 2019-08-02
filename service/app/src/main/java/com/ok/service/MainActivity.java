package com.ok.service;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.ok.service.MusicService ;
import com.ok.service.MusicService.MyMusicService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends   AppCompatActivity{

    private TextView tv;
    private ListView lv;
    private List<MuscicInfo> list = new ArrayList<MuscicInfo>();
    private Myconn conn;
    private MyMusicService mms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent startService = new Intent(MainActivity.this,MusicService.class);
        startService(startService);


        tv = (TextView) findViewById(R.id.tvinfo);
        lv =  (ListView) findViewById(R.id.lv);
        list.add(new MuscicInfo("big", R.raw.big));
        list.add(new MuscicInfo("冰雨", R.raw.by));


        lv.setAdapter(new MyAdapter());
        Intent intent = new Intent(this,MusicService.class);
        conn = new Myconn();
        bindService(intent, conn, BIND_AUTO_CREATE);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                tv.setText("正在播放的歌曲是："+list.get(position).getName());
                mms.playMusic(list, position);
                mms.myString();
                System.out.println("正在播放的歌曲是："+list.get(position).getName());
            }
        });

    }
    private class Myconn implements ServiceConnection{
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mms = (MyMusicService) service;
            System.out.println("1234");
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

    }
    private class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(MainActivity.this);
            tv.setText(list.get(position).getName());
            return tv;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mms.stopMusic();
        unbindService(conn);
    }
}