package com.sahafapp.seray.sahaf.Fragments;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.sahafapp.seray.sahaf.Adapters.UserProfileAdapter;
import com.sahafapp.seray.sahaf.Helpers.SampleBitmapSize;
import com.sahafapp.seray.sahaf.R;

public class UserProfileFragment extends android.support.v4.app.Fragment {

    FragmentPagerAdapter adapterViewPager;
    ViewPager vpPager;
    LinearLayout tabs;
    RelativeLayout advertButton, salesButton, reportButton;
    ImageView profileImage;
    final int unselected = Color.argb(0,33,33,33);
    final int selected = Color.argb(155,33,33,33);
    public static int userId;


    public UserProfileFragment() {
        // Required empty public constructor
    }


    public static UserProfileFragment newInstance() {
        UserProfileFragment fragment = new UserProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);

        vpPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabs = (LinearLayout) view.findViewById(R.id.tabs);
        advertButton = (RelativeLayout) view.findViewById(R.id.advertButton);
        salesButton = (RelativeLayout) view.findViewById(R.id.salesButton);
        reportButton = (RelativeLayout) view.findViewById(R.id.reportButton);
        profileImage = (ImageView) view.findViewById(R.id.profileImage);

        advertButton.setOnClickListener(buttonListener);
        salesButton.setOnClickListener(buttonListener);
        reportButton.setOnClickListener(buttonListener);

        int imageResource = getResources().getIdentifier("drawable/profile", null, getActivity().getPackageName());
        Resources res = getResources();
        Bitmap src = SampleBitmapSize.decodeSampledBitmapFromResource(getResources(), imageResource, 100, 100);
        android.support.v4.graphics.drawable.RoundedBitmapDrawable dr = RoundedBitmapDrawableFactory.create(res, src);
        dr.setCircular(true);
        profileImage.setImageDrawable(dr);

        adapterViewPager = new UserProfileAdapter(getChildFragmentManager());
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
                    salesButton.setBackgroundColor(selected);
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
                    vpPager.setCurrentItem(2);
                    break;
                case R.id.reportButton:
                    report();
                    break;
                default:
                    break;
            }
        }
    };

    private void report()
    {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = this.getLayoutInflater(getArguments());
        final View dialogView = inflater.inflate(R.layout.alert_dialog_report, null);

        RelativeLayout positiveButton = (RelativeLayout) dialogView.findViewById(R.id.positiveButton);
        RelativeLayout negativeButton = (RelativeLayout) dialogView.findViewById(R.id.negativeButton);

        GradientDrawable shapeOrange =  new GradientDrawable();
        shapeOrange.setCornerRadius(15);
        shapeOrange.setColor(Color.parseColor("#9cfc9024"));
        positiveButton.setBackground(shapeOrange);
        negativeButton.setBackground(shapeOrange);

        (dialogView.findViewById(R.id.first)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView firstTick = (ImageView) dialogView.findViewById(R.id.firstTick);

                if(firstTick.getVisibility() == View.VISIBLE)
                    firstTick.setVisibility(View.INVISIBLE);
                else
                    firstTick.setVisibility(View.VISIBLE);
            }
        });

        (dialogView.findViewById(R.id.second)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView secondTick = (ImageView) dialogView.findViewById(R.id.secondTick);

                if(secondTick.getVisibility() == View.VISIBLE)
                    secondTick.setVisibility(View.INVISIBLE);
                else
                    secondTick.setVisibility(View.VISIBLE);
            }
        });

        (dialogView.findViewById(R.id.third)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView thirdTick = (ImageView) dialogView.findViewById(R.id.thirdTick);

                if(thirdTick.getVisibility() == View.VISIBLE)
                    thirdTick.setVisibility(View.INVISIBLE);
                else
                    thirdTick.setVisibility(View.VISIBLE);
            }
        });

        (dialogView.findViewById(R.id.fourth)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView fourthTick = (ImageView) dialogView.findViewById(R.id.fourthTick);

                if(fourthTick.getVisibility() == View.VISIBLE)
                    fourthTick.setVisibility(View.INVISIBLE);
                else
                    fourthTick.setVisibility(View.VISIBLE);
            }
        });

        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pass
            }
        });

        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send report
            }
        });

        dialogBuilder.setView(dialogView);

        AlertDialog b = dialogBuilder.create();
        b.show();
    }
}
