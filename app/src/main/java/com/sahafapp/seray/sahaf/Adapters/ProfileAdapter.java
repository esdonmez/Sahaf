package com.sahafapp.seray.sahaf.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.sahafapp.seray.sahaf.Fragments.AdvertProfileFragment;
import com.sahafapp.seray.sahaf.Fragments.SaleFragment;

public class ProfileAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 2;


    public ProfileAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AdvertProfileFragment.newInstance("0", "Page # 1");
            case 1:
                return SaleFragment.newInstance("1", "Page # 2");
            default:
                return null;
        }
    }
}
