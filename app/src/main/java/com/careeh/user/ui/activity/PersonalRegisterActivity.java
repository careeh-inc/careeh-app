package com.careeh.user.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.careeh.user.databinding.ActivityPersonalRegisterBinding;

public class PersonalRegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        ActivityPersonalRegisterBinding binding = ActivityPersonalRegisterBinding.inflate(getLayoutInflater());

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // Sign up button click listener
        binding.btnSignUp.setOnClickListener(v -> {

            // After sign up go to LoginActivity
            startActivity(new Intent(this, LoginActivity.class));
        });

        // Login TextView (as Button) click listener
        binding.tvLogin.setOnClickListener(v -> {

            // Go to LoginActivity
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}