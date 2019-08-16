package com.example.tablayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tablayout.R;

public class AddFood extends AppCompatActivity {
    Button Addfood_input;
    Spinner Addfood_time,Addfood_location,Addfood_restaurant,Addfood_food;
    EditText Addfood_serving;
    private String[] time = {"早","中","晚"};
    private String[] location = {"靜園","宜園","至善"};
    private String[][] restaurant = {{"白鬍子","極寶"},{"藍卡","買粥"},{"Yami快餐"}};
    private String[][][] food = {{{"綠茶","紅茶","珍珠奶茶"},{"鐵板麵","焗烤","炒飯"}},{{"水果茶"},{"海鮮粥","巧克力厚片"}},{{"豬排飯","烤牛肉飯"}}};
    ArrayAdapter<String> time_adapter,location_adapter,restaurant_adapter,food_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addfood);

        Addfood_time = (Spinner) findViewById(R.id.Addfood_time);
        Addfood_location = (Spinner) findViewById(R.id.Addfood_location);
        Addfood_restaurant = (Spinner) findViewById(R.id.Addfood_restaurant);
        Addfood_food = (Spinner) findViewById(R.id.Addfood_food);

        //設置各個spinner預設顯示的值
        time_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,time);
        Addfood_time.setAdapter(time_adapter);

        location_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,location);
        Addfood_location.setAdapter(location_adapter);

        restaurant_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,restaurant[0]);
        Addfood_restaurant.setAdapter(restaurant_adapter);

        food_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,food[0][0]);
        Addfood_food.setAdapter(food_adapter);

        //設定選擇地點，餐廳欄位跳出相對應的餐廳
        Addfood_location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = Addfood_location.getSelectedItemPosition();
                restaurant_adapter = new ArrayAdapter<String>(AddFood.this,R.layout.support_simple_spinner_dropdown_item,restaurant[pos]);
                Addfood_restaurant.setAdapter(restaurant_adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //設定選擇餐廳，食物欄位跳出該餐廳食物
        Addfood_restaurant.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = Addfood_location.getSelectedItemPosition();
                int pos2 = Addfood_restaurant.getSelectedItemPosition();
                food_adapter = new ArrayAdapter<String>(AddFood.this,R.layout.support_simple_spinner_dropdown_item,food[pos][pos2]);
                Addfood_food.setAdapter(food_adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        getSupportActionBar().hide(); //隱藏標題
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏狀態
    }
}