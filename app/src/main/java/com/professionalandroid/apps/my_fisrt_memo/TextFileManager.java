package com.professionalandroid.apps.my_fisrt_memo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFileManager {
    private static final String FILE_NAME = "Memo.txt";

    Context mContext = null;

    public TextFileManager(Context context) {
        mContext = context;
    }

    public void save(String strData) {
        if(strData == null || strData.equals("")) {
            return;
        }
        FileOutputStream fosMemo = null;

        try {
            fosMemo = mContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fosMemo.write(strData.getBytes());
            fosMemo.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String load() {

    }

    public void delete() {
        mContext.deleteFile(FILE_NAME);
    }
}