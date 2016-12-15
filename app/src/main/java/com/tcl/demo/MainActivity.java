package com.tcl.demo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tcl.handler.demo.R;

public class MainActivity extends AppCompatActivity {


    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(MainActivity.this, "seconds " + msg.arg1, Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startThread();
    }

    private void startThread() {
        new Thread(mRunnable).start();
    }

    Runnable mRunnable = new Runnable() {

        private int seconds = 0;

        @Override
        public void run() {
            try {
                while (true) {
                    Message msg = new Message();
                    msg.arg1 = seconds ++;
                    mHandler.sendMessage(msg);
                    Thread.sleep(1000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

}
