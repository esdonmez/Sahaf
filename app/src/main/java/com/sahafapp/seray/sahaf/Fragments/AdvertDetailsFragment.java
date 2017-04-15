package com.sahafapp.seray.sahaf.Fragments;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sahafapp.seray.sahaf.Helpers.SampleBitmapSize;
import com.sahafapp.seray.sahaf.R;

public class AdvertDetailsFragment extends android.support.v4.app.Fragment {

    Button advertButton;
    RelativeLayout seller;
    TextView bookName, description, sellerName, advertDate, city, price, isSwappable, category, author, language, publisher, edition, publicationDate, pageSize;
    ImageView bookImage;

    public AdvertDetailsFragment() {
        // Required empty public constructor
    }


    public static AdvertDetailsFragment newInstance() {
        AdvertDetailsFragment fragment = new AdvertDetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_advert_details, container, false);

        advertButton = (Button) view.findViewById(R.id.advertButton);
        seller = (RelativeLayout) view.findViewById(R.id.seller);
        bookName = (TextView) view.findViewById(R.id.bookName);
        sellerName = (TextView) view.findViewById(R.id.sellerName);
        city = (TextView) view.findViewById(R.id.city);
        price = (TextView) view.findViewById(R.id.price);
        publicationDate = (TextView) view.findViewById(R.id.price);
        category = (TextView) view.findViewById(R.id.category);
        bookImage = (ImageView) view.findViewById(R.id.bookImage);
        advertButton = (Button) view.findViewById(R.id.advertButton);

        bookName.setText(AdvertFragment.advertDetails.Name);
        sellerName.setText(AdvertFragment.advertDetails.SellerName);
        city.setText(AdvertFragment.advertDetails.Distance);
        price.setText(AdvertFragment.advertDetails.Price);
        publicationDate.setText(AdvertFragment.advertDetails.PublicationDate);
        category.setText(AdvertFragment.advertDetails.Category);
        int imageResource = getResources().getIdentifier(AdvertFragment.advertDetails.Image, null, getActivity().getPackageName());
        bookImage.setImageBitmap(SampleBitmapSize.decodeSampledBitmapFromResource(getResources(), imageResource, 100, 100));

        if(StartFragment.userId.equalsIgnoreCase(Integer.toString(AdvertFragment.advertDetails.SellerId)))
        {
            GradientDrawable shapeGray =  new GradientDrawable();
            shapeGray.setCornerRadius(15);
            shapeGray.setColor(Color.parseColor("#b4b4b4"));
            advertButton.setBackground(shapeGray);
        }
        else
        {
            GradientDrawable shapeOrange =  new GradientDrawable();
            shapeOrange.setCornerRadius(15);
            shapeOrange.setColor(Color.parseColor("#9cfc9024"));
            advertButton.setBackground(shapeOrange);
        }

        advertButton.setOnClickListener(buttonListener);
        seller.setOnClickListener(buttonListener);

        return view;
    }

    private View.OnClickListener buttonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.advertButton:

                    break;
                case R.id.seller:
                    UserProfileFragment userProfileFragment = new UserProfileFragment();
                    UserProfileFragment.userId = AdvertFragment.advertDetails.SellerId;
                    getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, userProfileFragment).addToBackStack(null).commit();
                    break;
                default:
                    break;
            }
        }
    };
}
