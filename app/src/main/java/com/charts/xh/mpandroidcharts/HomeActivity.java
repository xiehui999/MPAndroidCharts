package com.charts.xh.mpandroidcharts;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.charts.xh.mpandroidcharts.com.charts.xh.utils.HomeAdapter;
import com.charts.xh.mpandroidcharts.com.charts.xh.utils.HomeItem;

import java.util.ArrayList;


public class HomeActivity extends Activity {
    private static final Class<?>[] ACTIVITY = {LineChartActivity1.class,LineChartActivity2.class,BarChartActivity.class,HorizontalBarChartActivity.class,PieChartActivity.class,RadarChartActivitry.class,BarCharts1.class};
    private static final String[] TITLE = {"线性表1", "线性表2", "柱状图", "水平柱状图", "饼状图", "雷达图","柱状图下钻"};
    private static final String[] COLOR_STR = {"#0dddb8","#0bd4c3","#03cdcd","#03cdcd","#00b1c5","#04b2d1","#04b2d1","#04b2d1"};
    private ArrayList<HomeItem> mDataList;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        initData();
        BaseQuickAdapter homeAdapter = new HomeAdapter(this, R.layout.home_item_view, mDataList);
        homeAdapter.openLoadAnimation();
        homeAdapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(HomeActivity.this, ACTIVITY[position]);
                startActivity(intent);
            }
        });
        homeAdapter.setOnRecyclerViewItemLongClickListener(new BaseQuickAdapter.OnRecyclerViewItemLongClickListener() {
            @Override
            public boolean onItemLongClick(View view, int position) {
                Toast.makeText(HomeActivity.this,"onItemLongClick",Toast.LENGTH_LONG).show();
                return true;
            }
        });
        mRecyclerView.setAdapter(homeAdapter);
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            HomeItem item = new HomeItem();
            item.setTitle(TITLE[i]);
            item.setActivity(ACTIVITY[i]);
            item.setColorStr(COLOR_STR[i]);
            mDataList.add(item);
        }
    }

}
