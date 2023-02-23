package com.chienfu.companyinfo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CompanyInfo extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    private TextView tv_CompanyName,tv_CompanyID;
    private EditText edtCompanyName, edtCompanyAddress, edtCompanyPhone;
    private Button btn_Return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_info);

        //Isen：接收Main帶過來的資料
        tv_CompanyName = (TextView) findViewById(R.id.tv_CompanyName);
        tv_CompanyID = (TextView) findViewById(R.id.tv_CompanyID);
        Intent intent = getIntent();
        String str_Company_Name = intent.getStringExtra("Company_Name");
        String str_Company_ID = intent.getStringExtra("Company_ID");
        tv_CompanyName.setText(str_Company_Name);
        tv_CompanyID.setText(str_Company_ID);

        // ChatGPT範例
        // 初始化UI元素
        edtCompanyName = (EditText)findViewById(R.id.edtCompanyName);
        edtCompanyAddress = (EditText)findViewById(R.id.edtCompanyAddress);
        edtCompanyPhone = (EditText)findViewById(R.id.edtCompanyPhone);

        // 設置按鈕的點擊事件，儲存公司資料
        btn_Return = (Button) findViewById(R.id.btn_Return);
        btn_Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ChatGPT範例
                // 取得輸入框中的資料
                String companyName = edtCompanyName.getText().toString();
                String companyAddress = edtCompanyAddress.getText().toString();
                String companyPhone = edtCompanyPhone.getText().toString();

                // 將公司資料儲存到SharedPreferences中
                SharedPreferences sharedPref = getSharedPreferences("company_info", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("company_name", companyName);
                editor.putString("company_address", companyAddress);
                editor.putString("company_phone", companyPhone);
                editor.apply();

                //ChatGPT範例
                // 返回MainActivity
                Intent intent = new Intent(CompanyInfo.this, MainActivity.class);
                startActivity(intent);

                //youtube教學範例Code
                intent = getIntent();
                intent.putExtra("Page1_Result", "Result：Receive OK");
                setResult(REQUEST_CODE,intent);

                finish();
            }
        });
    }
}
