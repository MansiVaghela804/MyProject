package com.example.admin.myproject.Tabs;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.myproject.Fragment.BlankFragment;
import com.example.admin.myproject.Fragment.FirstFragment;
import com.example.admin.myproject.Fragment.SecondFragment;
import com.example.admin.myproject.R;

public class TabActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    TabLayout tabLayout;
    ViewPager viewPager;
    android.support.v4.app.FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabLayout = (TabLayout) findViewById(R.id.TabLayout);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        manager = getSupportFragmentManager();
        viewPager.setAdapter(new TabActivity.adapter(manager));

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

    public class adapter extends FragmentPagerAdapter {
        public adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;

            if (i == 0) {
                fragment = new BlankFragment();
            }
            if (i == 1) {
                fragment = new FirstFragment();

            }
            if (i == 2) {

                fragment = new SecondFragment();
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
