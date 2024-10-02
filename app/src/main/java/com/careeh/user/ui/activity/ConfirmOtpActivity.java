package com.careeh.user.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.careeh.user.databinding.ActivityConfirmOtpBinding;

public class ConfirmOtpActivity extends BaseActivity {

    /**
     * Documentation: Pin view library for android <a href="https://github.com/GoodieBag/Pinview">GitHub Pin View</a>
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        ActivityConfirmOtpBinding binding = ActivityConfirmOtpBinding.inflate(getLayoutInflater());

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // Continue button click listener
        binding.btnContinue.setOnClickListener(v -> {

            Log.e("OTP", binding.pinView.getValue());

            // Go to ResetPasswordActivity
            startActivity(new Intent(this, ResetPasswordActivity.class));
        });
    }
}