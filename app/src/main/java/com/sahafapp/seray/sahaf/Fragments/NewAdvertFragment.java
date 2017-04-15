package com.sahafapp.seray.sahaf.Fragments;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sahafapp.seray.sahaf.Models.CategoryModel;
import com.sahafapp.seray.sahaf.R;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class NewAdvertFragment extends android.support.v4.app.Fragment implements LocationListener {

    ImageView advertImage, deleteButton;
    EditText advertName, price, author, language, publisher, edition;
    TextView findLocation;
    Button publishButton;
    Spinner spinnerCategory;
    private LocationManager locationManager;
    private String provider;


    public NewAdvertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_advert, container, false);

        advertImage = (ImageView) view.findViewById(R.id.advertImage);
        deleteButton = (ImageView) view.findViewById(R.id.deleteButton);
        advertName = (EditText) view.findViewById(R.id.advertName);
        price = (EditText) view.findViewById(R.id.price);
        findLocation = (TextView) view.findViewById(R.id.findLocation);
        author = (EditText) view.findViewById(R.id.author);
        publisher = (EditText) view.findViewById(R.id.publisher);
        edition = (EditText) view.findViewById(R.id.edition);
        publishButton = (Button) view.findViewById(R.id.publishButton);
        spinnerCategory = (Spinner) view.findViewById(R.id.spinnerCategory);

        advertImage.setImageDrawable(CameraFragment.drawable);

        GradientDrawable shapeOrange =  new GradientDrawable();
        shapeOrange.setCornerRadius(15);
        shapeOrange.setColor(Color.parseColor("#9cfc9024"));
        publishButton.setBackground(shapeOrange);

        ArrayAdapter<String> adapterCategory = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, AdvertFragment.CategoryList2);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);

        locationManager = (LocationManager) getActivity().getSystemService(getContext().LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        locationManager.requestLocationUpdates(provider,400,0,this);

        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }


    @Override
    public void onPause() {
        super.onPause();

        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        //You had this as int. It is advised to have Lat/Loing as double.
        double lat = location.getLatitude();
        double lng = location.getLongitude();

        Geocoder geoCoder = new Geocoder(getContext(), Locale.getDefault());

        try {
            List<Address> address = geoCoder.getFromLocation(lat, lng, 1);
            String city = address.get(0).getLocality();

            findLocation.setText(city); //This will display the final address.

        } catch (IOException e) {
            findLocation.setText("Konum Bul!");
        } catch (NullPointerException e) {
            findLocation.setText("Konum Bul!");
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {


    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(getActivity(), "Enabled new provider " + provider,
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(getActivity(), "Disabled provider " + provider,
                Toast.LENGTH_SHORT).show();
    }
}
