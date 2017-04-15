package com.sahafapp.seray.sahaf.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import com.sahafapp.seray.sahaf.Adapters.AdvertAdapter;
import com.sahafapp.seray.sahaf.Models.AdvertModel;
import com.sahafapp.seray.sahaf.R;
import java.util.ArrayList;
import java.util.List;

public class AdvertProfileFragment extends android.support.v4.app.Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    GridView advertView;
    public static List<AdvertModel> AdvertList = new ArrayList<AdvertModel>();
    public static AdvertModel advertDetails;


    public AdvertProfileFragment() {
        // Required empty public constructor
    }


    public static AdvertProfileFragment newInstance(String param1, String param2) {
        AdvertProfileFragment fragment = new AdvertProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_advert_profile, container, false);

        /*AdvertList.clear();
        AdvertList.add(new AdvertModel("Senden Sonra Ben", "İzmir", "20,93 TL", "07/08/2016", "Edebiyat", 1, "drawable/book1"));
        AdvertList.add(new AdvertModel("Kaplan Yürekli Çocuk", "Manisa", "13,87 TL", "07/08/2016", "Edebiyat", 2, "drawable/book2"));
        AdvertList.add(new AdvertModel("Havva'nın Üç Kızı", "İzmir", "20,25 TL", "07/08/2016", "Edebiyat", 3, "drawable/book3"));
        AdvertList.add(new AdvertModel("Yitik Kalpler İstasyonu", "Aydın", "18,75 TL", "07/08/2016", "Edebiyat", 4, "drawable/book4"));
        AdvertList.add(new AdvertModel("Nefesini Tut", "İzmir", "20,95 TL", "07/08/2016", "Edebiyat", 5, "drawable/book5"));
        AdvertList.add(new AdvertModel("Düşünen Bir Yürek", "İzmir", "20,93 TL", "07/08/2016", "Edebiyat", 6, "drawable/book6"));
        AdvertList.add(new AdvertModel("Senden Sonra Ben", "İzmir", "20,93 TL", "07/08/2016", "Edebiyat", 7, "drawable/book7"));*/

        advertView = (GridView) view.findViewById(R.id.advertList);
        advertView.setAdapter(new AdvertAdapter(getContext(), AdvertList));

        advertView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                AdvertDetailsFragment advertDetailsFragment = new AdvertDetailsFragment();
                advertDetails = AdvertList.get(pos);
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, advertDetailsFragment).addToBackStack(null).commit();
            }
        });

        return view;
    }
}
