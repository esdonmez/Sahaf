package com.sahafapp.seray.sahaf;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.sahafapp.seray.sahaf.Core.DataClient;
import com.sahafapp.seray.sahaf.Fragments.AdvertFragment;
import com.sahafapp.seray.sahaf.Fragments.CameraFragment;
import com.sahafapp.seray.sahaf.Fragments.MessageFragment;
import com.sahafapp.seray.sahaf.Fragments.ProfileFragment;
import com.sahafapp.seray.sahaf.Fragments.UserProfileFragment;

public class MainActivity extends AppCompatActivity {
    public static DataClient Client = new DataClient();
    public static FragmentManager fragmentManager;
    final int unselected = Color.rgb(157, 157, 157);
    final int selected = Color.rgb(252, 144, 36);
    ImageView shoppingButton;
    ImageView cameraButton;
    ImageView messageButton;
    ImageView profileButton;
    AdvertFragment advertFragment;
    ProfileFragment profileFragment;
    MessageFragment messageFragment;
    CameraFragment cameraFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ScreenFeatures();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        InitializeUI();
    }

    private void ScreenFeatures() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private void InitializeUI() {
        shoppingButton = (ImageView) findViewById(R.id.shoppingButton);
        cameraButton = (ImageView) findViewById(R.id.cameraButton);
        messageButton = (ImageView) findViewById(R.id.messageButton);
        profileButton = (ImageView) findViewById(R.id.profileButton);

        shoppingButton.setOnClickListener(bottombarListener);
        cameraButton.setOnClickListener(bottombarListener);
        messageButton.setOnClickListener(bottombarListener);
        profileButton.setOnClickListener(bottombarListener);

        shoppingButton.setColorFilter(selected, android.graphics.PorterDuff.Mode.SRC_ATOP);
        cameraButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
        messageButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
        profileButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);

        advertFragment = new AdvertFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, advertFragment).commit();
    }

    public void setFragment(UserProfileFragment frag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, frag).commit();
    }

    private View.OnClickListener bottombarListener = new View.OnClickListener() {
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.shoppingButton:
                    shoppingButton.setColorFilter(selected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    cameraButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    messageButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    profileButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    advertFragment = new AdvertFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, advertFragment).commit();
                    break;
                case R.id.cameraButton:
                    shoppingButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    cameraButton.setColorFilter(selected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    messageButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    profileButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    cameraFragment = new CameraFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, cameraFragment).commit();
                    /*NewAdvertFragment newAdvertFragment = new NewAdvertFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, newAdvertFragment).commit();*/
                    break;
                case R.id.messageButton:
                    shoppingButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    cameraButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    messageButton.setColorFilter(selected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    profileButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    messageFragment = new MessageFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, messageFragment).commit();
                    break;
                case R.id.profileButton:
                    shoppingButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    cameraButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    messageButton.setColorFilter(unselected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    profileButton.setColorFilter(selected, android.graphics.PorterDuff.Mode.SRC_ATOP);
                    profileFragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, profileFragment).commit();
                    break;
                default:
                    break;
            }
        }
    };
}
