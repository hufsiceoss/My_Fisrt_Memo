package com.professionalandroid.apps.my_fisrt_memo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText mMemoEdit = null;
    TextFileManager mTextFileManager = new TextFileManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMemoEdit = (EditText)findViewById(R.id.memo_edit);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.load_btn: {
                String memoData = mTextFileManager.load();
                mMemoEdit.setText(memoData);

                Toast.makeText(this,"뿅", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.save_btn: {
                String memoData = mMemoEdit.getText().toString();
                mTextFileManager.save(memoData);
                mMemoEdit.setText("");

                Toast.makeText(this,"저장저장", Toast.LENGTH_LONG).show();
                break;
            }
            case R.id.delete_btn: {
                mTextFileManager.delete();
                mMemoEdit.setText("");

                Toast.makeText(this, "삭제삭제", Toast.LENGTH_LONG).show();
            }
        }
    }
}