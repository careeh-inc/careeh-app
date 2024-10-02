package com.careeh.user.ui.activity;

import android.os.Bundle;

import com.careeh.user.databinding.ActivityProfileBinding;

public class ProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        ActivityProfileBinding binding = ActivityProfileBinding.inflate(getLayoutInflater());

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // App Toolbar navigation back icon click listener
        binding.appbar.toolbar.setNavigationOnClickListener(v -> {
            // App Toolbar navigation icon (back)
            onBackPressed();
        });
    }
}