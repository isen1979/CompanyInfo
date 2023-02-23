package com.chienfu.companyinfo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    private TextView tvCompanyName;
    private TextView tvCompanyAddress;
    private TextView tvCompanyPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "onCreate");
        //Activity_全域：生命週期開始
        //以下可建立所有全域的狀態

        // ChatGPT：初始化UI元素
        tvCompanyName = (TextView) findViewById(R.id.tv_company_name);
        tvCompanyAddress = (TextView) findViewById(R.id.tv_company_address);
        tvCompanyPhone = (TextView) findViewById(R.id.tv_company_phone);

        // 設置按鈕的點擊事件，跳轉到CompanyInfoActivity
        Button btn_GoToCompanyInfo = (Button) findViewById(R.id.btnGoToCompanyInfo);
        btn_GoToCompanyInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CompanyInfo.class);
                intent.putExtra("Company_Name", "Company_Name：Chien-fu Tech.");
                intent.putExtra("Company_ID", "Company_ID：45895171");
//                startActivity(intent);//Isen：僅執行但不接收B頁成果
                startActivityForResult(intent, REQUEST_CODE);//Isen：執行後帶回B頁成果
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case REQUEST_CODE:
                //Isen：接收Page1帶過來的資料
                TextView tv_Page1_Result = (TextView) findViewById(R.id.tv_Page1_Result);
                Intent intent = getIntent();
                String str_Page1_Result = data.getStringExtra("Page1_Result");
                tv_Page1_Result.setText(str_Page1_Result);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart");
        //Activity_可視化元件：生命週期開始
        //以下可建立：所有可視化元件的狀態及變數
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume");
        //Activity_可視化元件：生命週期動作起始點
        //以下可建立：所有可視化元件要執行的動作

        // 從SharedPreferences中讀取公司資料
        SharedPreferences sharedPreferences = getSharedPreferences("company_info", Context.MODE_PRIVATE);
        String companyName = sharedPreferences.getString("company_name", "");
        String companyAddress = sharedPreferences.getString("company_address", "");
        String companyPhone = sharedPreferences.getString("company_phone", "");

        // 將公司資料顯示在畫面上
        tvCompanyName.setText(companyName);
        tvCompanyAddress.setText(companyAddress);
        tvCompanyPhone.setText(companyPhone);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause");
        //Activity_可視化元件：生命週期動作暫停點
        //以下可建立：所有可視化元件暫停後要做的事
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop");
        //Activity_可視化元件：生命週期結束
        //以下可建立：所有可視化元件結束後要做的事
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "onDestroy");
        //Activity_全域：生命週期結束
        //結束所有全域狀態前：要清除的事項，要寫在上面
    }
}
