package com.professionalandroid.apps.my_fisrt_memo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.professionalandroid.apps.my_fisrt_memo.R;
import com.professionalandroid.apps.my_fisrt_memo.TextFileManager;

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
    }//클릭할때 어떻게 실행되는지에 관한 함수 불러오기, 저장하기, 삭제하기 등을 버튼으로 만들었고
     //각 버튼을 눌렀을 때 TextFileManager 클래스와 연동될수 있게 불러오며 일정 행동을 수행한 후에
     //밑에 작은 문구로 실행을 완료했음을 토스트로 화면에 보여준다.
}