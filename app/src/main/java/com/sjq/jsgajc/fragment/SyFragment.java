package com.sjq.jsgajc.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sjq.jsgajc.R;
import com.sjq.jsgajc.activity.GaywXxxxActivity;
import com.sjq.jsgajc.adapter.GaxwAdapter;
import com.sjq.jsgajc.entity.Gaxw;
import com.sjq.jsgajc.utils.DataSourceTest;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class SyFragment extends Fragment implements OnBannerListener {

    private Banner banner;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    private RecyclerView recyclerView;
    private GaxwAdapter gaxwAdapter;

    public SyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sy, container, false);

        banner = view.findViewById(R.id.banner);
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();
        list_path.add("1");
        list_path.add("2");
        list_path.add("3");
        list_path.add("4");
        list_title.add("刘旸副省长出席全省公安机关警务保障工作会议");
        list_title.add("刘旸同志到宿迁市局调研指导工作");
        list_title.add("刘旸同志参加公安部专题调研座谈会");
        list_title.add("刘旸同志参加厅办公室党支部专题组织生活会");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(5000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER).setOnBannerListener(this).start();
        //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。  //必须最后调用的方法，启动轮播图。 .start();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()) {
            @Override
            public boolean canScrollVertically() {
                //解决ScrollView里存在多个RecyclerView时滑动卡顿的问题
                //如果你的RecyclerView是水平滑动的话可以重写canScrollHorizontally方法
                return false;
            }
        });
//recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//recyclerView.setNestedScrollingEnabled(false);
        //解决数据加载不完的问题
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        //解决数据加载完成后, 没有停留在顶部的问题
        recyclerView.setFocusable(false);


        recyclerView.setAdapter(gaxwAdapter = new GaxwAdapter(R.layout.sy_list_item, DataSourceTest.getGaxwData()));
        gaxwAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Gaxw gaxw= (Gaxw) adapter.getItem(position);
                Intent in =new Intent(getActivity(),GaywXxxxActivity.class);
                in.putExtra("resid",gaxw.getResid());
                in.putExtra("title",gaxw.getXxxxtitle());
                in.putExtra("nr",gaxw.getXxxxnr());
                startActivity(in);
            }
        });
        return view;
    }


    //轮播图的监听方法
    @Override
    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第" + position + "张轮播图");
    } //自定义的图片加载器

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            // Glide.with(context).load((String) path).into(imageView);
            if (path.equals("1")) {
                imageView.setImageResource(R.drawable.img1);
            } else if (path.equals("2")) {
                imageView.setImageResource(R.drawable.img2);
            } else if (path.equals("3")) {
                imageView.setImageResource(R.drawable.img3);
            } else if (path.equals("4")) {
                imageView.setImageResource(R.drawable.img4);
            }

        }
    }


}
