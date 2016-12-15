package com.tcl.demo.download;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.io.File;


public class DownloadParam {

    private String mName;
    private String mStrUrl;
    private int mProgress;  // in percent
    private long mCompletedBytes;
    private long mSize;
    private Status mStatus = Status.PENDING;
    private String mExtension = ".apk";

    public DownloadParam(String name, String strUrl, int progress) {
        mName = name;
        mStrUrl = strUrl;
        mProgress = progress;
    }

    private DownloadParam(String name, String strUrl, long completedBytes, long size, Status status, int progress) {
        mName = name;
        mStrUrl = strUrl;
        mCompletedBytes = completedBytes;
        mSize = size;
        mStatus = status;
        mProgress = progress;
    }

    public String getStrUrl() {
        return mStrUrl;
    }

    void setProgress(int progress) {
        mProgress = progress;
    }

    void setSize(long size) {
        this.mSize = size;
    }

    public long getSize() {
        return mSize;
    }

    public int getProgress() {
        return mProgress;
    }

    public String getName() {
        return mName;
    }

    String getExtension() {
        return mExtension;
    }

    void setCompletedBytes(long completedBytes) {
        mCompletedBytes = completedBytes;
    }

    public long getCompletedBytes() {
        return mCompletedBytes;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

    public enum Status {
        /**
         * before start
         */
        PENDING,
        /**
         * downloading
         */
        RUNNING,
        /**
         * pause button press
         */
        PAUSED,
        /**
         * finish downloading
         */
        FINISHED,
    }
/*

    public static DownloadParam toDownloadParam(Cursor cursor) {

        String appName = cursor.getString(cursor.getColumnIndex(DatabaseConst.FIELDS[1]));

        String url = cursor.getString(cursor.getColumnIndex(DatabaseConst.FIELDS[2]));
        long size = cursor.getLong(cursor.getColumnIndex(DatabaseConst.FIELDS[3]));
        long completedBytes = cursor.getLong(cursor.getColumnIndex(DatabaseConst.FIELDS[4]));
        Log.d("DocumentParam", " comp = " + completedBytes + " size =  " + size);
        Status status = null;
        int progress = 0;
        if (completedBytes < size && completedBytes > 0) {
            status = Status.PAUSED;
            progress = (int)(completedBytes * 100 / size);
        }
        else if(completedBytes == 0) {
            status = Status.PENDING;
        }
        else if(completedBytes == size) {
            status = Status.FINISHED;
            progress = 100;
        }
        DownloadParam param = new DownloadParam(appName, url, completedBytes, size, status, progress);

        return param;
    }
*/

}
