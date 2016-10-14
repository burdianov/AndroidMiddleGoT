package com.testography.androidmiddlegot.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.testography.androidmiddlegot.R;
import com.testography.androidmiddlegot.ui.adapters.SwornMembersAdapter;
import com.testography.androidmiddlegot.ui.adapters.ViewPagerAdapter;
import com.testography.androidmiddlegot.ui.fragments.HouseOneFragment;
import com.testography.androidmiddlegot.ui.fragments.HouseThreeFragment;
import com.testography.androidmiddlegot.ui.fragments.HouseTwoFragment;

public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private RecyclerView mRecyclerView;
    private SwornMembersAdapter mSwornMembersAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        setupViewPager(mViewPager);

        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new HouseOneFragment(), "ONE");
        adapter.addFragment(new HouseTwoFragment(), "TWO");
        adapter.addFragment(new HouseThreeFragment(), "THREE");

        mViewPager.setAdapter(adapter);
    }
}
