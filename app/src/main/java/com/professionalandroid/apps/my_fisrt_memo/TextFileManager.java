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
    }//저장하기 함수 작성했던 메모를 저장한다.
     //메모를 저장할 때는 바이트 타입으로 저장한다.

    public String load() {
        try {
            FileInputStream fisMemo = mContext.openFileInput(FILE_NAME);

            byte[] memoData = new byte[fisMemo.available()];

            while (fisMemo.read(memoData) != -1) {
            }
            return new String(memoData);
        } catch (IOException e) {
        }
        return "";
    }//불러오기 함수 사용자가 저장했던 메모를 불러 다시 화면에 보여준다.
     //바이트를 다시 스트링타입으로 사용자에게 변환하여 보여준다.

    public void delete() {
        mContext.deleteFile(FILE_NAME);
    }//삭제하기 함수 저장했던 함수를 삭제해준다.
}