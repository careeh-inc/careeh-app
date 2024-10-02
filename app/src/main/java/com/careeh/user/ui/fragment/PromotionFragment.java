package com.careeh.user.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.careeh.user.adapter.PromotionAdapter;
import com.careeh.user.databinding.FragmentPromotionBinding;
import com.careeh.user.viewmodel.PromotionViewModel;


public class PromotionFragment extends Fragment {

    public PromotionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentPromotionBinding binding = FragmentPromotionBinding.inflate(inflater, container, false);
        PromotionViewModel promotionViewModel = new ViewModelProvider(this).get(PromotionViewModel.class);

        binding.rvPromotions.setLayoutManager(new LinearLayoutManager(getActivity()));

        promotionViewModel.getPromotions().observe(getViewLifecycleOwner(), strings -> {

            PromotionAdapter promotionAdapter = new PromotionAdapter(strings);
            binding.rvPromotions.setAdapter(promotionAdapter);
        });

        promotionViewModel.loadData();

        return binding.getRoot();
    }
}