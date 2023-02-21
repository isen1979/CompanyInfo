package com.chienfu.companyinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class ActivityMain extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_Page1 = (Button) findViewById(R.id.btn_Page1);
        btn_Page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMain.this, ActivityPage1.class);
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

}
