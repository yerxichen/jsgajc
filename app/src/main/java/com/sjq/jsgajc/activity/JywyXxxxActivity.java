package com.sjq.jsgajc.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sjq.jsgajc.R;

public class JywyXxxxActivity extends AppCompatActivity {

    private TextView tv_title,tv_zz;
    private LinearLayout ll_context;
    private String title,zz;
    private String[] nr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jywy_xxxx);
        Bundle bundle=getIntent().getExtras();
        title=bundle.getString("title");
        zz=bundle.getString("zz");
        nr=bundle.getStringArray("nr");
        initData();
    }

    private void initData(){
        ll_context=findViewById(R.id.ll_context);
        tv_title=findViewById(R.id.tv_title);
        tv_zz=findViewById(R.id.tv_zz);
        tv_title.setText(title);
        tv_zz.setText(zz);
        for(int i=0;i<nr.length;i++){
            View view = getLayoutInflater().inflate(R.layout.gayw_xxxx_nr, null);
            TextView tv=view.findViewById(R.id.tv);
            tv.setText("    "+nr[i]);
            ll_context.addView(view);
        }

    }
}
