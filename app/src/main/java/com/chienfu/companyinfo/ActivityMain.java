package com.chienfu.companyinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ActivityMain extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_info);
        Log.d("a","b");
    }

    /**
     * 這個是按鈕按下去的回應函數，函數的參數中必須將View傳入，代表 被按下去的物件，本例中是Button元件
     *
     * @param view
     */
    public void nextView(View view) {
        // 新增一個 Intent物件
        Intent intent = new Intent();
        // 設定這個Intent所指向的是Report的類別
        intent.setClass(this, Report.class);

        // Intent帶參數的方式
        // 從Activity中找到main_account的文字編輯區塊
        EditText main_account = (EditText) findViewById(R.id.main_account);
        // 產生一個 Bundle讓Intent能夠傳遞參數
        Bundle bundle = new Bundle();
        // 放入一個鍵值為main_account, 對應值是文字編輯區塊中內容的字串的參數
        bundle.putString("main_account", main_account.getText().toString());
        // 將bundle放入intent之
        intent.putExtras(bundle);

        // 切換至這個Intent所指定的Activity
        startActivity(intent);

    }

}
