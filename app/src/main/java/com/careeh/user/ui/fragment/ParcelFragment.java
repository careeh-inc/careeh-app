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

import com.careeh.user.R;
import com.careeh.user.adapter.AvailableVehiclesAdapter;
import com.careeh.user.adapter.DropOffLocationAdapter;
import com.careeh.user.databinding.FragmentParcelBinding;
import com.careeh.user.model.DropOffLocation;
import com.careeh.user.ui.activity.SearchLocationActivity;
import com.careeh.user.util.Constants;
import com.careeh.user.viewmodel.ParcelViewModel;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class ParcelFragment extends Fragment implements DropOffLocationAdapter.OnItemClickListener {

    private DropOffLocationAdapter dropOffLocationAdapter;
    private List<DropOffLocation> dropOffLocations;

    public ParcelFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflates the layout using data binding and initializes the binding object
        FragmentParcelBinding binding = FragmentParcelBinding.inflate(inflater, container, false);

        // Retrieves the ParcelViewModel instance from the ViewModelProvider
        ParcelViewModel parcelViewModel = new ViewModelProvider(this).get(ParcelViewModel.class);

        // Image items for image slider
        binding.imageSlider.setImageList(imageList());

        // Observe changes in available vehicles data and update the UI accordingly
        parcelViewModel.getVehiclesLiveData().observe(getViewLifecycleOwner(), availableVehicles -> {

            // Observe changes in available vehicles data and update the UI accordingly
            AvailableVehiclesAdapter vehiclesAdapter = new AvailableVehiclesAdapter(availableVehicles);
            binding.rvAvailableVehicle.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.rvAvailableVehicle.setAdapter(vehiclesAdapter);
        });

        binding.pickUpLocation.setOnClickListener(v -> startActivity(new Intent(getActivity(), SearchLocationActivity.class)));

        binding.btnSelectSchedule.setOnClickListener(v -> {

            // Show time picker bottom sheet fragment
            new PickTimeBottomSheetFragment().show(getChildFragmentManager(), Constants.BOTTOM_SHEET_TAG);
        });

        // dropOffLocation (Drop-off Location) button click listener; Top of btnAddStop button
        binding.dropOffLocation.setOnClickListener(v -> {

            // Start activity for drop off SearchLocationActivity
            startActivity(new Intent(getActivity(), SearchLocationActivity.class)
                    // These extra information for pickup or drop off labels hints
                    .putExtra(Constants.SEARCH_LABEL_INDEX_KEY, Constants.DROP_OFF_LOCATION_INDEX));
        });

        // Drop-off location recycler view
        dropOffLocations = new ArrayList<>();

        dropOffLocationAdapter = new DropOffLocationAdapter(dropOffLocations, this);
        binding.rvDropOffView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvDropOffView.setAdapter(dropOffLocationAdapter);

        binding.btnAddStop.setOnClickListener(v -> {
            dropOffLocations.add(new DropOffLocation("Drop-off " + dropOffLocations.size()));
            dropOffLocationAdapter.notifyItemChanged(dropOffLocations.size() - 1);
        });

        // Load data for the parcelViewModel
        parcelViewModel.loadData();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private List<SlideModel> imageList() {
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.slider_image_1, ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel(R.drawable.slider_image_1, ScaleTypes.CENTER_INSIDE));
        imageList.add(new SlideModel(R.drawable.slider_image_1, ScaleTypes.CENTER_INSIDE));
        return imageList;
    }

    @Override
    public void onItemClick(DropOffLocation item, int position) {

        // Start activity for drop off SearchLocationActivity
        startActivity(new Intent(getActivity(), SearchLocationActivity.class)
                // These extra information for pickup or drop off labels hints
                .putExtra(Constants.SEARCH_LABEL_INDEX_KEY, Constants.DROP_OFF_LOCATION_INDEX));
    }

    @Override
    public void onCloseClick(int position) {
        dropOffLocations.remove(position);
        dropOffLocationAdapter.notifyItemRemoved(position);
        dropOffLocationAdapter.notifyItemRangeChanged(position, dropOffLocations.size());
    }
}