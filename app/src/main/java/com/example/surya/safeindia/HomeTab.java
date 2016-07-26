package com.example.surya.safeindia;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class HomeTab extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tab);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        tabLayout=(TabLayout)findViewById(R.id.toolBar);

        tabLayout.addTab(tabLayout.newTab().setText("Contacts Tab selected"));
        tabLayout.addTab(tabLayout.newTab().setText("Friends Tab selected"));
        tabLayout.addTab(tabLayout.newTab().setText("Maps Tab selected"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager=(ViewPager)findViewById(R.id.pager);

        Pager adapter=new Pager(getSupportFragmentManager(),tabLayout.getTabCount() );

        viewPager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(this);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
