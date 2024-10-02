package com.careeh.user.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.careeh.user.adapter.NotificationAdapter;
import com.careeh.user.databinding.FragmentNotificationBinding;
import com.careeh.user.viewmodel.NotificationViewModel;

public class NotificationFragment extends Fragment {

    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentNotificationBinding binding = FragmentNotificationBinding.inflate(inflater, container, false);

        NotificationViewModel notificationViewModel = new ViewModelProvider(this).get(NotificationViewModel.class);

        binding.rvNotifications.setLayoutManager(new LinearLayoutManager(getActivity()));

        notificationViewModel.getNotificationLiveData().observe(getViewLifecycleOwner(), notificationModels -> {

            NotificationAdapter notificationAdapter = new NotificationAdapter(notificationModels);
            binding.rvNotifications.setAdapter(notificationAdapter);
        });

        notificationViewModel.loadData();

        return binding.getRoot();
    }
}