package com.example.jason.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.Locale;

/**
 * Created by jason on 10/12/15.
 */
//Define the mSectionsPagerAdapter that you're using by inheriting the FragmentPagerAdapter
// You're basically saying SectionsPagerAdapter is a subclass of FragmentPagerAdapter.
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    //define the constructor by just using the constructor defined in FragmentPagerAdapter
    // the constructor in the super takes a FragmentManager object as its parameter
    public SectionsPagerAdapter (FragmentManager fm){
        super(fm);
    }
    // your class must also implement the two abstract methods getItem(int) & getCount()

    /**
     * Method gets the fragment corresponding to the specified position. This fragment is
     * then used to populate the contents of the {@link ViewPager}.
     *
     * @param position Position to fetch fragment for.
     * @return return the Fragment for the specified position.
     */

    @Override
    public Fragment getItem(int position){
        // create an instance of a fragment that you would define for your app. right now the fragment
        // is just called DummySectionFragment

        Fragment fragment = new DummyFragment();
        // Bundles are used to pass data between various activities or to itself in the future
        // A bundle allows you to gather together different types of data into a single object.
         Bundle args = new Bundle();
        //Store the fragment data into the bundle. In this case the data is just the page number
        args.putInt(DummyFragment.ARG_SECTION_NUMBER, position + 1);
        //supply the construction arguments for this fragment.
        fragment.setArguments(args);

        // return the fragment that represents the page you're viewing.
        return fragment;

    }

    /**
     * Get the number of pages the {@link ViewPager} should render.
     * @return Number of fragments to be rendered as pages.
     */
    @Override
    public int getCount(){
        return 3;
    }

    /**
     * Gets the title for each page and displays it on each of the tabs.
     *
     * @param position Page to fetch title for.
     * @return Title for specified page
     */
    @Override
    public CharSequence getPageTitle(int position){
        Locale l = Locale.getDefault();
        switch (position){
            case 0:
                return "Home".toUpperCase(l);
            case 1:
                return "Events".toUpperCase(l);
            case 2:
                return "Sign Up".toUpperCase(l);
        }
        return null;
    }

    //End of Adapter
}