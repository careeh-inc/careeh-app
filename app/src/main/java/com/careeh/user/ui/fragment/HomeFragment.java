package com.careeh.user.ui.fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.careeh.user.R;
import com.careeh.user.adapter.AvailableVehiclesAdapter;
import com.careeh.user.databinding.FragmentHomeBinding;
import com.careeh.user.viewmodel.HomeViewModel;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        // Inflates the layout using data binding and initializes the binding object
        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater, container, false);

        // Retrieves the HomeViewModel instance from the ViewModelProvider
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // Initialize the HomeFragment
        ParcelFragment parcelFragment = new ParcelFragment();

        // Image items for image slider
        binding.imageSlider.setImageList(imageList());

        // Observe changes in available vehicles data and update the UI accordingly
        homeViewModel.getVehiclesLiveData().observe(getViewLifecycleOwner(), availableVehicles -> {

            // Observe changes in available vehicles data and update the UI accordingly
            AvailableVehiclesAdapter vehiclesAdapter = new AvailableVehiclesAdapter(availableVehicles);
            binding.rvAvailableVehicle.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.rvAvailableVehicle.setAdapter(vehiclesAdapter);
        });

        // Load data for the homeViewModel
        homeViewModel.loadData();

        binding.btnParcel.setOnClickListener(v -> {
            // Replace to HomeFragment
            replaceFragment(parcelFragment);
        });

        // Set variables in Binding
        return binding.getRoot();
    }

    private List<SlideModel> imageList() {
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.slider_image_1, ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel(R.drawable.slider_image_1, ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel(R.drawable.slider_image_1, ScaleTypes.CENTER_INSIDE));
        return imageList;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}