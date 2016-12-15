package com.tcl.demo.download;

/**
 * Created by shengyuan on 16-12-5.
 */

public class DownloadManager {


    private DownloadListener mDownloadListener;


    public void setDownloadListener(DownloadListener downloadListener) {
        mDownloadListener = downloadListener;
    }


    public void startTask() {
        mDownloadListener.onStart();
    }


    public void resumeTask() {
        mDownloadListener.onResume();
    }


    public void pauseTask() {
        mDownloadListener.onPause();
    }

}
