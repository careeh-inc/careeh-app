package com.careeh.user.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.careeh.user.databinding.ActivityStartUsingBinding;

public class StartUsingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        ActivityStartUsingBinding binding = ActivityStartUsingBinding.inflate(getLayoutInflater());

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // Check location permissions in onRequestLocationPermission
        onRequestLocationPermission();

        // Start using button click listener
        binding.btnStartUsing.setOnClickListener(v -> {

            // Go to GetStartedActivity
            startActivity(new Intent(this, GetStartedActivity.class));
        });
    }
}