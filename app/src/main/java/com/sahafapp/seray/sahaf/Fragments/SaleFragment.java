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

public class SaleFragment extends android.support.v4.app.Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    GridView saleView;
    public static List<AdvertModel> SaleList = new ArrayList<AdvertModel>();


    public SaleFragment() {
        // Required empty public constructor
    }


    public static SaleFragment newInstance(String param1, String param2) {
        SaleFragment fragment = new SaleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sale, container, false);

        /*SaleList.clear();
        SaleList.add(new AdvertModel("Senden Sonra Ben", "İzmir", "20,93 TL", "07/08/2016", "Edebiyat", 1, "drawable/book1"));
        SaleList.add(new AdvertModel("Kaplan Yürekli Çocuk", "Manisa", "13,87 TL", "07/08/2016", "Edebiyat", 2, "drawable/book2"));
        SaleList.add(new AdvertModel("Havva'nın Üç Kızı", "İzmir", "20,25 TL", "07/08/2016", "Edebiyat", 3, "drawable/book3"));
        SaleList.add(new AdvertModel("Yitik Kalpler İstasyonu", "Aydın", "18,75 TL", "07/08/2016", "Edebiyat", 4, "drawable/book4"));
        SaleList.add(new AdvertModel("Nefesini Tut", "İzmir", "20,95 TL", "07/08/2016", "Edebiyat", 5, "drawable/book5"));
        SaleList.add(new AdvertModel("Düşünen Bir Yürek", "İzmir", "20,93 TL", "07/08/2016", "Edebiyat", 6, "drawable/book6"));
        SaleList.add(new AdvertModel("Senden Sonra Ben", "İzmir", "20,93 TL", "07/08/2016", "Edebiyat", 7, "drawable/book7"));*/

        saleView = (GridView) view.findViewById(R.id.saleList);
        saleView.setAdapter(new AdvertAdapter(getContext(), SaleList));

        saleView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                /*AdvertDetailsFragment advertDetailsFragment = new AdvertDetailsFragment();
                AdvertFragment.advertDetails = SaleList.get(pos);
                getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, advertDetailsFragment).addToBackStack(null).commit();*/
            }
        });

        return view;
    }
}
