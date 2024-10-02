package com.careeh.user.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import com.careeh.user.R;
import com.careeh.user.databinding.FragmentPickupTimeDialogBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PickTimeBottomSheetFragment extends BottomSheetDialogFragment {

    public PickTimeBottomSheetFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        FragmentPickupTimeDialogBinding binding = FragmentPickupTimeDialogBinding.inflate(inflater, container, false);

        // Chip not on click listener
        binding.pickNowChip.setOnClickListener(v -> {

            // Close time picker bottom sheet fragment
            this.dismiss();
        });

        // Chip later on click listener
        binding.pickLaterChip.setOnClickListener(v -> {

            // Show pick later click listener
            binding.pickLaterView.setVisibility(View.VISIBLE);
        });

        return binding.getRoot();
    }

    @Override public int getTheme() {
        return R.style.CustomBottomSheetDialog;
    }
}