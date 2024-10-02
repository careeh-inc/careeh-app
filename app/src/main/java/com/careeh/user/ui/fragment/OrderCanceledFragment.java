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

import com.careeh.user.adapter.DropOffLocationAdapter;
import com.careeh.user.adapter.OrdersHistoryAdapter;
import com.careeh.user.databinding.FragmentOrderCanceledBinding;
import com.careeh.user.model.OrderHistoryModel;
import com.careeh.user.ui.activity.OrderDetailsActivity;
import com.careeh.user.viewmodel.OrderCanceledViewModel;

public class OrderCanceledFragment extends Fragment implements OrdersHistoryAdapter.OnItemClickListener {

    public OrderCanceledFragment() {
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
        FragmentOrderCanceledBinding binding = FragmentOrderCanceledBinding.inflate(inflater, container, false);

        // Create an instance of the ViewModel associated with this fragment
        OrderCanceledViewModel orderCanceledViewModel = new ViewModelProvider(this).get(OrderCanceledViewModel.class);

        // Set up the RecyclerView with a LinearLayoutManager
        binding.rvCanceledOrders.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Observe changes in the LiveData from the ViewModel and update the RecyclerView adapter accordingly
        orderCanceledViewModel.getOrderCanceledLiveData().observe(getViewLifecycleOwner(), canceledOrders -> {

            // Create an adapter with the updated data and set it to the RecyclerView
            OrdersHistoryAdapter canceledHistoryAdapter = new OrdersHistoryAdapter(canceledOrders, this);
            binding.rvCanceledOrders.setAdapter(canceledHistoryAdapter);
        });

        // Load data for the ViewModel
        orderCanceledViewModel.loadData();

        // Return the root view of the inflated layout
        return binding.getRoot();
    }

    @Override
    public void onItemClick(OrderHistoryModel orderHistory, int position) {

        startActivity(new Intent(getActivity(), OrderDetailsActivity.class)
                .putExtra("position", position));
    }
}