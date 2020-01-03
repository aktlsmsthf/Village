package ver0.village.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ver0.village.Fragment.AlarmFragment;
import ver0.village.Fragment.HomeFragment;
import ver0.village.Fragment.TalkFragment;
import ver0.village.Fragment.UploadFragment;


public class TabPagerAdapter extends FragmentStatePagerAdapter {

    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        // Returning the current tabs
        switch (position) {
            case 0:
                HomeFragment tabFragment1 = new HomeFragment();
                return tabFragment1;
            case 1:
                TalkFragment tabFragment2 = new TalkFragment();
                return tabFragment2;
            case 2:
                AlarmFragment tabFragment3 = new AlarmFragment();
                return tabFragment3;
            case 3:
                return null;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}