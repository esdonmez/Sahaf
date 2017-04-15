package com.sahafapp.seray.sahaf.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import com.sahafapp.seray.sahaf.Adapters.AdvertAdapter;
import com.sahafapp.seray.sahaf.MainActivity;
import com.sahafapp.seray.sahaf.Models.AdvertModel;
import com.sahafapp.seray.sahaf.Models.CategoryModel;
import com.sahafapp.seray.sahaf.R;
import java.util.ArrayList;
import java.util.List;

public class AdvertFragment extends android.support.v4.app.Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    GridView advertView;
    private static List<AdvertModel> AdvertList = new ArrayList<AdvertModel>();
    public static List<CategoryModel> CategoryList = new ArrayList<CategoryModel>();
    public static List<String> CategoryList2 = new ArrayList<String>();
    ImageView searchButton;
    Spinner spinner;
    public static AdvertModel advertDetails;
    String selectedCategory;


    public AdvertFragment() {
        // Required empty public constructor
    }


    public static AdvertFragment newInstance(String param1, String param2) {
        AdvertFragment fragment = new AdvertFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_advert, container, false);

        searchButton = (ImageView) view.findViewById(R.id.searchButton);
        advertView = (GridView) view.findViewById(R.id.advertList);
        spinner = (Spinner) view.findViewById(R.id.spinner);

        new GetAdvertsReq().execute();
        new CategoriesReq().execute();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCategory = parent.getItemAtPosition(position).toString();
                List<AdvertModel> advertList = new ArrayList<AdvertModel>();


                if(selectedCategory.toLowerCase().equalsIgnoreCase("tümü"))
                {
                    advertList = AdvertList;
                }
                else
                {
                    for(int i = 0; i < AdvertList.size(); i++)
                    {
                        if(selectedCategory.equalsIgnoreCase(AdvertList.get(i).Category))
                        {
                            advertList.add(AdvertList.get(i));
                        }
                    }
                }


                advertView.setAdapter(new AdvertAdapter(getContext(), advertList));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        searchButton.setOnClickListener(buttonListener);

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

    public View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.searchButton:

                    break;
                default:
                    break;
            }
        }
    };

    class GetAdvertsReq extends AsyncTask<String,Void,List<AdvertModel>> {
        @Override
        protected List<AdvertModel> doInBackground(String... params) {

            AdvertList = MainActivity.Client.GetAdverts();

            return null;
        }

        @Override
        protected void onPostExecute(List<AdvertModel> data) {

            advertView.setAdapter(new AdvertAdapter(getContext(), AdvertList));
        }
    }

    class CategoriesReq extends AsyncTask<String,Void,List<CategoryModel>> {
        @Override
        protected List<CategoryModel> doInBackground(String... params) {

            CategoryList = MainActivity.Client.Categories();

            return null;
        }

        @Override
        protected void onPostExecute(List<CategoryModel> data) {
            for(int i = 0; i < CategoryList.size(); i++)
            {
                CategoryList2.add(CategoryList.get(i).Name);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, CategoryList2);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }
    }
}
