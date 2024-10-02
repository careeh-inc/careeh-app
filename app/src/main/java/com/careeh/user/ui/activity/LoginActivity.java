package com.careeh.user.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.careeh.user.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // ForgotPassword TextView (as Button) click listener
        binding.tvForgotPassword.setOnClickListener(v -> {

            // Go to ForgotPasswordActivity
            startActivity(new Intent(this, ForgotPasswordActivity.class));
        });

        // Login button click listener
        binding.btnLogin.setOnClickListener(v -> {

            // Go to MainActivity/HomeFragment
            startActivity(new Intent(this, MainActivity.class));
        });

        // Signup TextView (as Button) click listener
        binding.tvSignup.setOnClickListener(v -> {

            // Goto the SelectAccountActivity
            startActivity(new Intent(this, SelectAccountActivity.class));
        });
    }
}