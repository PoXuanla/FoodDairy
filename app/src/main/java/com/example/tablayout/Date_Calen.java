package com.example.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Date_Calen extends AppCompatActivity {
    private TextView date_calen_title;
    private TabLayout tablayout_calen;
    private ViewPager viewpager_calen;
    private String[] IconName = {"早餐","中餐","晚餐"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_calen);

        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態

        tablayout_calen = (TabLayout) findViewById(R.id.tablayout_calen);
        viewpager_calen = (ViewPager) findViewById(R.id.viewpager_calen);
        date_calen_title = (TextView)findViewById(R.id.date_calen_title);

        date_calen_title.setText(Dairy_Calen.date);

        //設定Tablayout 與 ViewPager 連動
        for(int i =0 ;i<3;i++)
            tablayout_calen.addTab(tablayout_calen.newTab());
        setViewPager();
        tablayout_calen.setupWithViewPager(viewpager_calen);
        setTabIcon();
    }
    private void setViewPager(){
        FragmentList_One myFragment1 = new FragmentList_One();
        FragmentList_Two myFragment2 = new FragmentList_Two();
        FragmentList_Three myFragment3 = new FragmentList_Three();
        List<Fragment> fragmentList = new ArrayList<Fragment>();
        fragmentList.add(myFragment1);
        fragmentList.add(myFragment2);
        fragmentList.add(myFragment3);
        ViewPagerFragmentAdapter myFragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), fragmentList);
        viewpager_calen.setAdapter(myFragmentAdapter);
    }
    private void setTabIcon(){
        for(int i = 0 ; i<IconName.length ; i++){
            tablayout_calen.getTabAt(i).setText(IconName[i]);
        }
    }
}
