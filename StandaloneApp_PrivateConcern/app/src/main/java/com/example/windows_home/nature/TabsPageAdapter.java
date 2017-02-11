package com.example.windows_home.nature;

/**
 * Created by windows-home on 03-05-2015.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPageAdapter extends FragmentPagerAdapter {

    public TabsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new HomeTab();
            case 1:
                // Movies fragment activity
                return new Homeopathy();
            case 2:
                // Movies fragment activity
                return new TreatTab();
            case 3:
                // Movies fragment activity
                return new ContactTab();

        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 4;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + (position + 1);
    }

}