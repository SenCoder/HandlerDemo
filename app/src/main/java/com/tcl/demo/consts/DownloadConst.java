package com.tcl.demo.consts;

import android.os.Environment;

/**
 * Created by shengyuan on 16-12-15.
 */

public class DownloadConst {

    public static final String SD_PATH = Environment.getExternalStorageDirectory().getPath();

    public static final String[] FIELDS = {
            "Id",
            "AppName",
            "Url",
            "Size",
            "CompletedBytes",
            "PackageName",
    };

}
