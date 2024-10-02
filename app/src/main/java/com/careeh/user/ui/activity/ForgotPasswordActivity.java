package com.careeh.user.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.careeh.user.databinding.ActivityForgotPasswordBinding;

public class ForgotPasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        ActivityForgotPasswordBinding binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // Continue button click listener
        binding.btnContinue.setOnClickListener(v -> {

            // Go to ConfirmOtpActivity
            startActivity(new Intent(this, ConfirmOtpActivity.class));
        });
    }
}