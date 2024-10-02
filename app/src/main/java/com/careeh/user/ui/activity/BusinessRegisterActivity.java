package com.careeh.user.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.careeh.user.R;
import com.careeh.user.databinding.ActivityBusinessRegisterBinding;

import java.util.Arrays;
import java.util.List;

public class BusinessRegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        ActivityBusinessRegisterBinding binding = ActivityBusinessRegisterBinding.inflate(getLayoutInflater());

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // Test Auto complete dropdown text input layout
        List<String> items = Arrays.asList("Agriculture", "Construction", "Education", "Energy", "Finance", "Healthcare", "Manufacturing", "Retail", "Technology");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.industry_list_item, items);

        // Set adapter
        binding.autoComIndustry.setAdapter(adapter);

        // Sign up button click listener
        binding.btnSignUp.setOnClickListener(v -> {

            // After sign up go to LoginActivity
            startActivity(new Intent(this, LoginActivity.class));
        });

        // Login: TextView (as Button) click listener
        binding.tvLogin.setOnClickListener(v -> {

            // Go to LoginActivity
            startActivity(new Intent(this, LoginActivity.class));
        });
    }
}