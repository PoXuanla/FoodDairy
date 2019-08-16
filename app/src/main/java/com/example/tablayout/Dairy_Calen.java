package com.example.tablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

public class Dairy_Calen extends AppCompatActivity {
    CalendarView calendarview;
    public static String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dairy_calendarview);

        calendarview = (CalendarView)findViewById(R.id.calendarView);

        calendarview.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = (Integer.toString(year)) +" 年 "+  (Integer.toString(month))  +" 月 "+  (Integer.toString(dayOfMonth)) +" 日";
              Intent intent = new Intent(Dairy_Calen.this,Date_Calen.class);
              startActivity(intent);
            }
        });
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
    }
}
