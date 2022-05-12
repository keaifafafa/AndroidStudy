package com.example.a22servicecomponent01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("TAG", "onBind");
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onCreate() {
        Log.i("TAG", "onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i("TAG", "onDestroy");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("TAG", "onStartCommand");
        // 开启线程，比较耗时
        new Thread() {
            @Override
            public void run() {
                int i = 1;
                while (i++ < 1000) {
                    Log.i("TAG", i + " ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }
}