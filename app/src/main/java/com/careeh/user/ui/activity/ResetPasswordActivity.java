package com.careeh.user.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.careeh.user.databinding.ActivityResetPasswordBinding;

public class ResetPasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        ActivityResetPasswordBinding binding = ActivityResetPasswordBinding.inflate(getLayoutInflater());

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // Continue button click listener
        binding.btnContinue.setOnClickListener(v -> {

            // Go to LoginActivity
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}