package com.sjq.jsgajc.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.print.PrinterId;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sjq.jsgajc.R;
import com.sjq.jsgajc.adapter.GaxwAdapter;
import com.sjq.jsgajc.adapter.XgtjAdapter;
import com.sjq.jsgajc.entity.Gaxw;
import com.sjq.jsgajc.entity.Jywy;
import com.sjq.jsgajc.utils.DataSourceTest;

public class GaywXxxxActivity extends AppCompatActivity {

    private LinearLayout ll_context;
    private int resid;
    private String title;
    private String[] nr;
    private TextView tv_title;
    private ImageView imageView;
    private RecyclerView rv_xgtj;
    private XgtjAdapter xgtjAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gayw_xxxx);

        Bundle bundle=getIntent().getExtras();
        resid=bundle.getInt("resid");
        title=bundle.getString("title");
        nr=bundle.getStringArray("nr");
        intiData();

    }

    private void intiData(){
        tv_title=findViewById(R.id.tv_title);
        imageView=findViewById(R.id.iv);
        ll_context=findViewById(R.id.ll_context);
        tv_title.setText(title);
        imageView.setImageResource(resid);
        for(int i=0;i<nr.length;i++){
            View view = getLayoutInflater().inflate(R.layout.gayw_xxxx_nr, null);
            TextView tv=view.findViewById(R.id.tv);
            tv.setTextColor(getResources().getColor(R.color.black));
            tv.setText("    "+nr[i]);
            ll_context.addView(view);
        }

        rv_xgtj=findViewById(R.id.rv_xgtj);
        rv_xgtj.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                //解决ScrollView里存在多个RecyclerView时滑动卡顿的问题
                //如果你的RecyclerView是水平滑动的话可以重写canScrollHorizontally方法
                return false;
            }
        });

        //解决数据加载不完的问题
        rv_xgtj.setNestedScrollingEnabled(false);
        rv_xgtj.setHasFixedSize(true);
        //解决数据加载完成后, 没有停留在顶部的问题
        rv_xgtj.setFocusable(false);


        rv_xgtj.setAdapter(xgtjAdapter = new XgtjAdapter(R.layout.xgtj_item, DataSourceTest.getJywyData()));
        xgtjAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Jywy jywy= (Jywy) adapter.getItem(position);
                Intent in =new Intent(GaywXxxxActivity.this,JywyXxxxActivity.class);
                in.putExtra("title",jywy.getTitle());
                in.putExtra("zz",jywy.getZzdw()+"    "+jywy.getZzxm());
                in.putExtra("nr",jywy.getContext());
                startActivity(in);
            }
        });

    }
}
