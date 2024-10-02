package com.careeh.user.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.careeh.user.R;
import com.careeh.user.model.VehicleInfo;

import java.util.ArrayList;
import java.util.List;

public class ParcelViewModel extends AndroidViewModel {

    private final MutableLiveData<List<VehicleInfo>> vehiclesLiveData;

    public ParcelViewModel(@NonNull Application application) {
        super(application);

        // Initialize the MediatorLiveData for available vehicles
        vehiclesLiveData = new MutableLiveData<>();
    }

    public void loadData() {
        // Set the value of availableVehicles by retrieving data from the getData() method
        vehiclesLiveData.setValue(getData());
    }

    private List<VehicleInfo> getData() {

        // Get the application context
        Context context = getApplication().getApplicationContext();
        List<VehicleInfo> vehicleList = new ArrayList<>();

        // Arrays containing vehicle icons and names
        int[] vehicleIcons = {R.drawable.icon_truck, R.drawable.icon_car, R.drawable.icon_motorbike};
        String[] vehicleNames = {context.getString(R.string.truck), context.getString(R.string.car), context.getString(R.string.bike)};

        // Create AvailableVehicle objects and add them to the availableVehicles list
        for (int i = 0; i < vehicleIcons.length; i++) {
            vehicleList.add(new VehicleInfo(vehicleIcons[i], vehicleNames[i]));
        }

        // Return the list of available vehicles
        return vehicleList;
    }

    public MutableLiveData<List<VehicleInfo>> getVehiclesLiveData() {
        // Return the LiveData for available vehicles
        return vehiclesLiveData;
    }
}
