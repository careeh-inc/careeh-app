package com.careeh.user.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.careeh.user.databinding.ActivityGetStartedBinding;

public class GetStartedActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        ActivityGetStartedBinding binding = ActivityGetStartedBinding.inflate(getLayoutInflater());

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // Skip button click listener
        binding.btnSkip.setOnClickListener(v -> {

            // Go to MainActivity -> HomeFragment
            startActivity(new Intent(this, MainActivity.class));
        });

        // Get Started button click listener
        binding.btnGetStarted.setOnClickListener(v -> {

            // Go to SelectAccountActivity
            startActivity(new Intent(this, SelectAccountActivity.class));
        });

        // Login TextView (as Button) click listener
        binding.tvLogin.setOnClickListener(v -> {

            // Go to LoginActivity
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}