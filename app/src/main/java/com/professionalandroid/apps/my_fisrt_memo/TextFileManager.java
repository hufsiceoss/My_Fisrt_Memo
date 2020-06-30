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

    }

    public String load() {

    }

    public void delete() {
        mContext.deleteFile(FILE_NAME);
    }
}