package com.sahafapp.seray.sahaf.Fragments;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.sahafapp.seray.sahaf.Adapters.ProfileAdapter;
import com.sahafapp.seray.sahaf.Helpers.SampleBitmapSize;
import com.sahafapp.seray.sahaf.Models.UserModel;
import com.sahafapp.seray.sahaf.R;

public class ProfileFragment extends android.support.v4.app.Fragment {

    public static UserModel me = new UserModel();
    FragmentPagerAdapter adapterViewPager;
    ViewPager vpPager;
    LinearLayout tabs;
    RelativeLayout advertButton, salesButton, logoutButton;
    ImageView profileImage;
    final int unselected = Color.argb(0,33,33,33);
    final int selected = Color.argb(155,33,33,33);


    public ProfileFragment() {
        // Required empty public constructor
    }


    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        vpPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabs = (LinearLayout) view.findViewById(R.id.tabs);
        advertButton = (RelativeLayout) view.findViewById(R.id.advertButton);
        salesButton = (RelativeLayout) view.findViewById(R.id.salesButton);
        logoutButton = (RelativeLayout) view.findViewById(R.id.logoutButton);
        profileImage = (ImageView) view.findViewById(R.id.profileImage);

        advertButton.setOnClickListener(buttonListener);
        salesButton.setOnClickListener(buttonListener);
        logoutButton.setOnClickListener(buttonListener);

        Resources res = getResources();
        int imageResource = getResources().getIdentifier("drawable/profile", null, getActivity().getPackageName());
        Bitmap src = SampleBitmapSize.decodeSampledBitmapFromResource(getResources(), imageResource, 100, 100);
        android.support.v4.graphics.drawable.RoundedBitmapDrawable dr = RoundedBitmapDrawableFactory.create(res, src);
        dr.setCircular(true);
        profileImage.setImageDrawable(dr);

        adapterViewPager = new ProfileAdapter(getChildFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        advertButton.setBackgroundColor(selected);
        salesButton.setBackgroundColor(unselected);
        vpPager.setCurrentItem(0);

        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if(position == 0)
                {
                    advertButton.setBackgroundColor(selected);
                    salesButton.setBackgroundColor(unselected);
                }

                else if(position == 1)
                {
                    advertButton.setBackgroundColor(unselected);
                    salesButton.setBackgroundColor(unselected);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.advertButton:
                    advertButton.setBackgroundColor(selected);
                    salesButton.setBackgroundColor(unselected);
                    vpPager.setCurrentItem(0);
                    break;
                case R.id.salesButton:
                    advertButton.setBackgroundColor(unselected);
                    salesButton.setBackgroundColor(selected);
                    vpPager.setCurrentItem(1);
                    break;
                default:
                    break;
            }
        }
    };
}
