package com.tcl.demo.download;

import android.os.Handler;
import android.os.Message;

import com.lidroid.xutils.util.LogUtils;

/**
 * Created by shengyuan on 16-12-15.
 */

public class Downloader extends Thread {


    private DownloadParam mParam;
    private Handler mHandler;


    public void setHandler(Handler handler) {
        mHandler = handler;
    }


    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i ++) {
            try {
                Thread.sleep(1000);
                Message msg = mHandler.obtainMessage();
                msg.arg1 = i * 10;

                msg.sendToTarget(); // same as sendMessage()

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
