package com.ok.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import java.util.List;

public class MusicService extends Service {
    private MediaPlayer mp;

    @Override
    public IBinder onBind(Intent intent) {
        return new MyMusicService();
    }

    public class MyMusicService extends Binder{

        public void myString(){
            System.out.println("LWB######################myString");
        }

        public void playMusic(List<MuscicInfo> list,int postion){
            play(list,postion);
            System.out.println("这里已经访问 了");
        }
        public void stopMusic(){
            stop();
        }
    }
    //播放歌曲
    public void play(List<MuscicInfo> list, int postion) {
        if(mp!=null){
            //说明正在播放,然后停止播放
            mp.stop();
            //释放资源
            mp.release();
            mp = null;
        }
        System.out.println("歌曲id是："+list.get(postion).getId());
        //实例化
        mp= MediaPlayer.create(this, list.get(postion).getId());
        //播放歌曲
        mp.start();
    }
    //停止歌曲
    public void stop() {
        if(mp != null){
            mp.stop() ;
            mp.release() ;
            mp = null ;
        }
    }


}
