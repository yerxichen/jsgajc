package com.sjq.jsgajc;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jkb.slidemenu.SlideMenuLayout;
import com.sjq.jsgajc.fragment.SpFragment;
import com.sjq.jsgajc.fragment.SyFragment;
import com.sjq.jsgajc.fragment.TsFragment;
import com.sjq.jsgajc.fragment.WdFragment;
import com.sjq.jsgajc.fragment.WzFragment;
import com.sjq.jsgajc.utils.BottomNavigationViewHelper;
import com.sjq.jsgajc.utils.StatusBarUtil;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

//    private DrawerLayout drawer;
//    private NavigationView navigationView;
    private BottomNavigationView navigation;
//    private ActionBarDrawerToggle toggle;
    private ImageView iv_menu;
    private FragmentManager fragmentManager;
    private Fragment syFragment, tsFragment, spFragment, wzFragment, wdFragment;
    private SlideMenuLayout slideMenuLayout;
    private RelativeLayout home_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_side);
        StatusBarUtil.setStatusBarColor(this);

        initView();
    }

    private void initView() {
        fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (syFragment == null) {
            syFragment = new SyFragment();
            //加入事务
            transaction.add(R.id.fl_frg, syFragment, "sy");
        } else {
            //fragment不为空就显示出来
            transaction.show(syFragment);
        }
        transaction.commit();
        slideMenuLayout=findViewById(R.id.mainSlideMenu);//仿QQ侧滑
//        //初始化DrawerLayout
//        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        toggle = new ActionBarDrawerToggle(
//                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//        //初始化侧滑导航
//        navigationView = (NavigationView) findViewById(R.id.nav_view);
//        setNavigationViewItemStyle();
//        navigationView.setItemIconTintList(null);//侧边栏显示原本的图片
//        navigationView.setBackgroundColor(getResources().getColor(R.color.colorNavMenuBg));
//        navigationView.setNavigationItemSelectedListener(this);

        //初始化底部导航
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        adjustNavigationIcoSize(navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);//去除超过三个隐藏文字的动画
        iv_menu = findViewById(R.id.iv_menu);
        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(slideMenuLayout.isRightSlideOpen()){
                    slideMenuLayout.closeRightSlide();
                }else{
                    slideMenuLayout.openRightSlide();
                }

            }
        });

        home_title=findViewById(R.id.layout_title);

    }


    private void adjustNavigationIcoSize(BottomNavigationView navigation) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigation.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, displayMetrics);
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }
    }


    public void hideTitle(){
        home_title.setVisibility(View.GONE);
    }

    //设置侧滑navigationView的字体颜色
//    private void setNavigationViewItemStyle() {
//        /**设置MenuItem的字体颜色**/
//        Resources resource = (Resources) getBaseContext().getResources();
//        ColorStateList csl = resource.getColorStateList(R.color.navigation_view_menu_item_color);
//        navigationView.setItemTextColor(csl);
//        /**设置MenuItem默认选中项**/
//        navigationView.getMenu().getItem(0).setChecked(true);
//        navigationView.getMenu().getItem(0).setIcon(R.drawable.gayw_img);
//    }
//
//    //初始化侧滑导航的图标（没有找到特别科学的方法）
//    private void initItemIcon() {
//        int size = navigationView.getMenu().size();
//        for (int i = 0; i < size; i++) {
//            MenuItem item = navigationView.getMenu().getItem(i);
//            int id = navigationView.getMenu().getItem(i).getItemId();
//            if (id == R.id.nav_gayw) {
//                // Handle the camera action
//                item.setIcon(R.drawable.gayw_img_nomal);
//            } else if (id == R.id.nav_zlzf) {
//                item.setIcon(R.drawable.zlzf_img_nomal);
//            } else if (id == R.id.nav_jqyj) {
//                item.setIcon(R.drawable.jqyj_img_nomal);
//            } else if (id == R.id.nav_spdb) {
//                item.setIcon(R.drawable.spdb_img_nomal);
//            } else if (id == R.id.nav_jywy) {
//                item.setIcon(R.drawable.jywy_img_nomal);
//            } else if (id == R.id.nav_bjfw) {
//                item.setIcon(R.drawable.bjfw_img_nomal);
//            }
//
//        }
//    }

    @Override
    public void onBackPressed() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (slideMenuLayout.isRightSlideOpen()) {
            slideMenuLayout.closeRightSlide();
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            if (drawer.isDrawerOpen(Gravity.END)) {
//                drawer.closeDrawer(Gravity.END);
//            } else {
//                drawer.openDrawer(Gravity.END);
//            }
//        }
//        if (toggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    //侧边栏选择监听
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//        initItemIcon();//每次选择之前先初始化图标
//        if (id == R.id.nav_gayw) {
//            // Handle the camera action
//            item.setIcon(R.drawable.gayw_img);
//        } else if (id == R.id.nav_zlzf) {
//            item.setIcon(R.drawable.zlzf_img);
//        } else if (id == R.id.nav_jqyj) {
//            item.setIcon(R.drawable.jqyj_img);
//        } else if (id == R.id.nav_spdb) {
//            item.setIcon(R.drawable.spdb_img);
//        } else if (id == R.id.nav_jywy) {
//            item.setIcon(R.drawable.jywy_img);
//        } else if (id == R.id.nav_bjfw) {
//            item.setIcon(R.drawable.bjfw_img);
//        }
//
//        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.END);
//        return true;
//    }

    //底部导航栏选择
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            hideFragment(transaction);

            switch (item.getItemId()) {
                case R.id.navigation_sy:
                    if(home_title.getVisibility()==View.GONE){
                        home_title.setVisibility(View.VISIBLE);
                    }
                    if (syFragment == null) {
                        syFragment = new SyFragment();
                        //加入事务
                        transaction.add(R.id.fl_frg, syFragment, "sy");
                    } else {
                        //fragment不为空就显示出来
                        transaction.show(syFragment);
                    }
                    transaction.commit();
                    return true;
                case R.id.navigation_ts:
                    if(home_title.getVisibility()==View.GONE){
                        home_title.setVisibility(View.VISIBLE);
                    }
                    if (tsFragment == null) {
                        tsFragment = new TsFragment();
                        //加入事务
                        transaction.add(R.id.fl_frg, tsFragment, "ts");
                    } else {
                        //fragment不为空就显示出来
                        transaction.show(tsFragment);
                    }
                    transaction.commit();
                    return true;
                case R.id.navigation_sp:
                    if(home_title.getVisibility()==View.GONE){
                        home_title.setVisibility(View.VISIBLE);
                    }
                    if (spFragment == null) {
                        spFragment = new SpFragment();
                        //加入事务
                        transaction.add(R.id.fl_frg, spFragment, "sp");
                    } else {
                        //fragment不为空就显示出来
                        transaction.show(spFragment);
                    }
                    transaction.commit();
                    return true;
                case R.id.navigation_wz:
                    if(home_title.getVisibility()==View.GONE){
                        home_title.setVisibility(View.VISIBLE);
                    }
                    if (wzFragment == null) {
                        wzFragment = new WzFragment();
                        //加入事务
                        transaction.add(R.id.fl_frg, wzFragment, "wz");
                    } else {
                        //fragment不为空就显示出来
                        transaction.show(wzFragment);
                    }
                    transaction.commit();
                    return true;
                case R.id.navigation_wd:
                    if(home_title.getVisibility()==View.VISIBLE){
                        home_title.setVisibility(View.GONE);
                    }
                    if (wdFragment == null) {
                        wdFragment = new WdFragment();
                        //加入事务
                        transaction.add(R.id.fl_frg, wdFragment, "wd");
                    } else {
                        //fragment不为空就显示出来
                        transaction.show(wdFragment);
                    }
                    transaction.commit();
                    return true;
            }

            return false;//返回值为true才能切换tab
        }
    };


    /**
     * 用来隐藏fragment的方法
     *
     * @param fragmentTransaction
     */
    private void hideFragment(FragmentTransaction fragmentTransaction) {
        //如果此fragment不为空的话就隐藏起来
        if (fragmentManager.findFragmentByTag("sy") != null) {
            fragmentTransaction.hide(syFragment);
        }
        if (fragmentManager.findFragmentByTag("ts") != null) {
            fragmentTransaction.hide(tsFragment);
        }
        if (fragmentManager.findFragmentByTag("sp") != null) {
            fragmentTransaction.hide(spFragment);
        }
        if (fragmentManager.findFragmentByTag("wz") != null) {
            fragmentTransaction.hide(wzFragment);
        }
        if (fragmentManager.findFragmentByTag("wd") != null) {
            fragmentTransaction.hide(wdFragment);
        }
    }

}
