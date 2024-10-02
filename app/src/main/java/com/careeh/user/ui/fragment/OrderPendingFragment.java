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
import com.careeh.user.databinding.FragmentOrderPendingBinding;
import com.careeh.user.model.OrderHistoryModel;
import com.careeh.user.ui.activity.OrderDetailsActivity;
import com.careeh.user.viewmodel.OrderPendingViewModel;

public class OrderPendingFragment extends Fragment implements OrdersHistoryAdapter.OnItemClickListener {

    public OrderPendingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflates the layout using data binding and initializes the binding object
        FragmentOrderPendingBinding binding = FragmentOrderPendingBinding.inflate(inflater, container, false);

        // Retrieves the OrderPendingViewModel instance from the ViewModelProvider
        OrderPendingViewModel orderPendingViewModel = new ViewModelProvider(this).get(OrderPendingViewModel.class);

        binding.rvPendingOrders.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Observe changes in pending orders data and update the UI accordingly
        orderPendingViewModel.getOrderHistoryLiveData().observe(getViewLifecycleOwner(), orderHistoryModels -> {

            // Initialize OrdersHistoryAdapter for all orderHistoryModels
            OrdersHistoryAdapter ordersHistoryAdapter = new OrdersHistoryAdapter(orderHistoryModels, this);
            binding.rvPendingOrders.setAdapter(ordersHistoryAdapter);
        });

        // Load data for the orderPendingViewModel
        orderPendingViewModel.loadData();

        // Set variables in Binding
        return binding.getRoot();
    }

    @Override
    public void onItemClick(OrderHistoryModel orderHistory, int position) {

        startActivity(new Intent(getActivity(), OrderDetailsActivity.class)
                .putExtra("position", position));
    }
}