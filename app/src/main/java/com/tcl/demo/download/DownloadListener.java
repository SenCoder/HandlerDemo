package com.tcl.demo.download;

/**
 * Created by shengyuan on 16-12-15.
 */
public interface DownloadListener {


    public void onStart();

    public void onResume();

    public void onPause();

    public void onFinish();

}
