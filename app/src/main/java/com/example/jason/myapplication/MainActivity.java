package com.example.jason.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // name a ViewPager variable. A ViewPager is a layout manager that allows the user to
    // flip left and right through pages of data. You supply an PagerAdapter to generate the
    // pages that the view shows. mViewPager host the contents supplied by the PagerAdapter

    // PagerAdapter is an class that represents each page as a Fragment.
    // mSectionsPagerAdapter will provide fragments for each page.
    SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create a TabLayout object that references the view in activity main.
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //create a ViewPager object that references the view in activity main.
        final ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        //create an Adapter
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        //create tabs
        tabLayout.setTabsFromPagerAdapter(mSectionsPagerAdapter);
        //supply the ViewPager with the adapter
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //create viewPager listeners which a TabLayout listener.
       mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
