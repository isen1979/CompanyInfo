package com.chienfu.companyinfo;

/**
 * Created by isenw on 2023/2/20.
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Report extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_list);
        // 從Intent中取值
        // 先取得文字區塊的參照
        TextView main_account = (TextView) findViewById(R.id.main_account);
        Bundle bundle = this.getIntent().getExtras();
        // 設定值main_account文字區塊的值是從前一個Activity而來
        main_account.setText(bundle.getString("main_account"))  ;

    }
}
