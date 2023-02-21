package com.chienfu.companyinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityPage1 extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        //Isen：接收Main帶過來的資料
        TextView tv_CompanyName = (TextView) findViewById(R.id.tv_CompanyName);
        TextView tv_CompanyID = (TextView) findViewById(R.id.tv_CompanyID);
        Intent intent = getIntent();
        String str_Company_Name = intent.getStringExtra("Company_Name");
        String str_Company_ID = intent.getStringExtra("Company_ID");
        tv_CompanyName.setText(str_Company_Name);
        tv_CompanyID.setText(str_Company_ID);

        Button btn_Return = (Button) findViewById(R.id.btn_Return);
        btn_Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("Page1_Result", "Result：Receive OK");
                setResult(REQUEST_CODE,intent);
                finish();
            }
        });
    }
}
