package com.careeh.user.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.careeh.user.databinding.ActivitySelectAccountBinding;

public class SelectAccountActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        ActivitySelectAccountBinding binding = ActivitySelectAccountBinding.inflate(getLayoutInflater());

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // Skip button click listener
        binding.btnSkip.setOnClickListener(v -> {

            // Go to MainActivity -> HomeFragment
            startActivity(new Intent(this, MainActivity.class));
        });

        // AccountIndividual button click listener
        binding.acIndividual.setOnClickListener(v -> {

            // Start PersonalRegisterActivity
            startActivity(new Intent(this, PersonalRegisterActivity.class));
        });

        // AccountBusiness button click listener
        binding.acBusiness.setOnClickListener(v -> {

            // Start BusinessRegisterActivity
            startActivity(new Intent(this, BusinessRegisterActivity.class));
        });

        // Login: TextView click listener
        binding.tvLogin.setOnClickListener(v -> {

            // Go to LoginActivity
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}