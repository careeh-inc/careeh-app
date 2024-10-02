package com.careeh.user.ui.activity;

import androidx.core.splashscreen.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.careeh.user.R;

public class SplashUi extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Handle the splash screen transition.
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);

        // Disable the splash screen visibility for this Activity
        splashScreen.setKeepOnScreenCondition(() -> false);

        setContentView(R.layout.activity_splash_ui);

        new Handler().postDelayed(() -> {

            // After 3 seconds start GettingStartedActivity.class
            startActivity(new Intent(this, StartUsingActivity.class));
            finish();

        }, 2000);
    }
}