package com.careeh.user.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.careeh.user.adapter.OrdersHistoryAdapter;
import com.careeh.user.databinding.FragmentOrderCompletedBinding;
import com.careeh.user.model.OrderHistoryModel;
import com.careeh.user.ui.activity.OrderDetailsActivity;
import com.careeh.user.viewmodel.OrderCompletedViewModel;


public class OrderCompletedFragment extends Fragment implements OrdersHistoryAdapter.OnItemClickListener {

    public OrderCompletedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment using Data Binding
        FragmentOrderCompletedBinding binding = FragmentOrderCompletedBinding.inflate(getLayoutInflater());

        // Create an instance of the ViewModel associated with this fragment
        OrderCompletedViewModel orderCompletedViewModel = new ViewModelProvider(this).get(OrderCompletedViewModel.class);

        // Set up the RecyclerView with a LinearLayoutManager
        binding.rvCompletedOrders.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Observe changes in the LiveData from the ViewModel and update the RecyclerView adapter accordingly
        orderCompletedViewModel.getOrderCompletedLiveData().observe(getViewLifecycleOwner(), orderHistoryModels -> {

            // Create an adapter with the updated data and set it to the RecyclerView
            OrdersHistoryAdapter completedHistoryAdapter = new OrdersHistoryAdapter(orderHistoryModels, this);
            binding.rvCompletedOrders.setAdapter(completedHistoryAdapter);
        });

        // Load data for the ViewModel
        orderCompletedViewModel.loadData();

        // Return the root view of the inflated layout
        return binding.getRoot();
    }

    @Override
    public void onItemClick(OrderHistoryModel orderHistory, int position) {

        startActivity(new Intent(getActivity(), OrderDetailsActivity.class)
                .putExtra("position", position));
    }
}