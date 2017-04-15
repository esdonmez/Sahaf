package com.sahafapp.seray.sahaf.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.sahafapp.seray.sahaf.MainActivity;
import com.sahafapp.seray.sahaf.R;

public class StartFragment extends android.support.v4.app.Fragment {

    RelativeLayout facebookLoginButton, registerButton, loginButton;
    ImageView startLogo;
    public static String userId;


    public StartFragment() {
        // Required empty public constructor
    }


    public static StartFragment newInstance() {
        StartFragment fragment = new StartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_start, container, false);

        facebookLoginButton = (RelativeLayout) view.findViewById(R.id.facebookLogin);
        startLogo = (ImageView) view.findViewById(R.id.startLogo);

        GradientDrawable shapeBlue =  new GradientDrawable();
        shapeBlue.setCornerRadius(15);

        shapeBlue.setColor(Color.parseColor("#9c3b5998"));
        facebookLoginButton.setBackground(shapeBlue);

        facebookLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoginReq().execute();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    class LoginReq extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... params) {

            return null;
        }

        @Override
        protected void onPostExecute(String data) {

        }
    }
}
