package com.testography.androidmiddlegot.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.testography.androidmiddlegot.R;
import com.testography.androidmiddlegot.ui.adapters.ViewPagerAdapter;
import com.testography.androidmiddlegot.ui.fragments.HouseOneFragment;
import com.testography.androidmiddlegot.ui.fragments.HouseThreeFragment;
import com.testography.androidmiddlegot.ui.fragments.HouseTwoFragment;
import com.testography.androidmiddlegot.utils.ConstantsManager;

public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private DrawerLayout mNavigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);

        setupViewPager(mViewPager);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new HouseOneFragment(), ConstantsManager.houseOneName);
        adapter.addFragment(new HouseTwoFragment(), ConstantsManager.houseTwoName);
        adapter.addFragment(new HouseThreeFragment(), ConstantsManager.houseThreeName);

        mViewPager.setAdapter(adapter);

        setupDrawer();
    }

    private void setupDrawer() {
        NavigationView navigationView = (NavigationView) findViewById(R.id
                .navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView
                .OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                item.setChecked(true);
//                mViewPager.setCurrentItem(1);
                mNavigationDrawer.closeDrawer(GravityCompat.START);

                return false;
            }
        });
    }
}
