package com.example.tablayout;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageButton calen;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private int[] IconId = {R.drawable.testpic,R.drawable.testpic,R.drawable.testpic};
    private String[] IconName = {"早餐","中餐","晚餐"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態

        setContentView(R.layout.activity_main);
        calen = (ImageButton) findViewById(R.id.calen);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        //設定Tablayout 與 ViewPager 連動
        for(int i =0 ;i<3;i++)
        tablayout.addTab(tablayout.newTab());
        setViewPager();
        tablayout.setupWithViewPager(viewpager);
        setTabIcon();
        //設定日曆的監聽
        calen.setOnClickListener(calenListener);
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
        viewpager.setAdapter(myFragmentAdapter);
    }
    private void setTabIcon(){
        for(int i = 0 ; i<IconId.length ; i++){
            tablayout.getTabAt(i).setText(IconName[i]);
        }
    }
    private Button.OnClickListener calenListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Dairy_Calen.class);
            startActivity(intent);
        }
    };
}
