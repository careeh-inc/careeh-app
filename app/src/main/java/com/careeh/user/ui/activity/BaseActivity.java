package com.careeh.user.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.careeh.user.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class BaseActivity extends AppCompatActivity {

    /**
     * <h1>BaseActivity</h1>
     * <p>
     * Base activity will help...
     * </p>
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize pretty logger logcat
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    // Method for location permission
    public void onRequestLocationPermission() {

        // Check if location is enabled or not
        if (isLocationEnable()) {
            checkLocationPermission();
        } else {
            // Location service is off; go to the settings to turn on the location
            Toast.makeText(this, R.string.turn_on_location, Toast.LENGTH_LONG).show();
            locationSettingsLauncher.launch(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
        }
    }

    private void checkLocationPermission() {
        if (!hasLocationPermission())
            aDialogForLocationPermission(); // Pop-up alert dialog to ask user for location permission
    }

    // Method to check location is enable or not
    private boolean isLocationEnable() {
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    // Method to check location permission
    private boolean hasLocationPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void aDialogForLocationPermission() {

        new MaterialAlertDialogBuilder(this)
                .setIcon(R.drawable.outline_location)
                .setTitle(R.string.location_permission_title)
                .setMessage(R.string.location_permission_text)
                .setPositiveButton(R.string.next, ((dialog, which) -> {

                    // If user press OKAY button the dialog will be dismiss;  Request for permission
                    locationPermissionResult.launch(Manifest.permission.ACCESS_FINE_LOCATION);

                }))
                .setNegativeButton(R.string.cancel, (dialog, which) -> {

                    // If user press CANCEL button the dialog will be dismiss
                    dialog.dismiss();
                }).show();
    }

    private final ActivityResultLauncher<Intent> locationSettingsLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {

                // Check if location settings were changed
                if (isLocationEnable())
                    checkLocationPermission(); // If the users enable their location then check for location permission
                else
                    Toast.makeText(this, R.string.location_update_failed_text, Toast.LENGTH_SHORT).show();
            });

    private final ActivityResultLauncher<String> locationPermissionResult =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), result -> {

                if (result)
                    Toast.makeText(this, getText(R.string.permission_granted_text), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, getText(R.string.permission_denied_text), Toast.LENGTH_SHORT).show();
            });
}
