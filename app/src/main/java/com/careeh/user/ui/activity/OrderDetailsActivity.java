package com.careeh.user.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.careeh.user.R;
import com.careeh.user.databinding.ActivityOrderDetailsBinding;

public class OrderDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityOrderDetailsBinding binding = ActivityOrderDetailsBinding.inflate(getLayoutInflater());
        int position = getIntent().getIntExtra("position", 1);

        setContentView(binding.getRoot());

        // Set appbar toolbar title
        binding.appbar.toolbar.setTitle(R.string.order_details_title);

        binding.tvOrderId.setText(String.format(getString(R.string.gen_order_id), position + 1));

        // App Toolbar navigation back icon click listener
        binding.appbar.toolbar.setNavigationOnClickListener(v -> {
            // App Toolbar navigation icon (back)
            onBackPressed();
        });
    }
}