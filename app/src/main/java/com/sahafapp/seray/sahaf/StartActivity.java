package com.sahafapp.seray.sahaf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.sahafapp.seray.sahaf.Fragments.StartFragment;

public class StartActivity extends AppCompatActivity {

    StartFragment startFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ScreenFeatures();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startFragment = new StartFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, startFragment).commit();
    }

    private void ScreenFeatures() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}
