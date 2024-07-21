package com.example.expressage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

public class search extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        ImageButton back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        SearchView searchView = findViewById(R.id.searchView);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                // 1. 获取用户输入的单号
//                String trackingNumber = query;
//
//                // 2. 从本地数据库查询订单信息
//                Order order = queryOrderFromDatabase(trackingNumber);
//
//                runOnUiThread(() -> {
//                    // 在这里更新UI,显示订单信息
//                    updateOrderDetails(order);
//                });
//
//
//
//
//                return false;
//            }
//            private Order queryOrderFromDatabase(String trackingNumber) {
//                // 使用数据库操作查询订单信息
//                // 这里假设您使用了Room数据库库
//                OrderDao orderDao = database.orderDao();
//                Order order = orderDao.getOrderByTrackingNumber(trackingNumber);
//                return order;
//            }
//            private void updateOrderDetails(Order order) {
//                // 在这里更新UI,显示订单信息
//                // 例如,设置订单号、收货地址、配送状态等
//            }

//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
    }

}