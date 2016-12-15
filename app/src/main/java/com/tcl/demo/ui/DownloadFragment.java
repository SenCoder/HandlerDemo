package com.tcl.demo.ui;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tcl.demo.download.DownloadListener;
import com.tcl.demo.download.DownloadManager;
import com.tcl.demo.download.Downloader;
import com.tcl.handler.demo.R;

/**
 * Created by shengyuan on 16-12-15.
 */

public class DownloadFragment extends Fragment {

    private Context mContext;
    private DownloadManager mDownloadManager;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(mContext, "thread "+ Thread.currentThread().getName()
                    + " timer = " + msg.arg1, Toast.LENGTH_SHORT).show();
            super.handleMessage(msg);
        }
    };

    Handler test = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            return false;
        }
    });

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_download, container, false);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        demo();
    }

    public void demo() {
        mDownloadManager = new DownloadManager();
        mDownloadManager.setDownloadListener(new DownloadListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onResume() {

            }

            @Override
            public void onPause() {

            }

            @Override
            public void onFinish() {

            }
        });
        Downloader downloader = new Downloader();
        downloader.setHandler(mHandler);
        downloader.start();
    }

}
