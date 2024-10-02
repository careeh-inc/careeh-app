package com.careeh.user.ui.activity;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.careeh.user.R;
import com.careeh.user.databinding.ActivityMainBinding;
import com.careeh.user.ui.fragment.CashbackFragment;
import com.careeh.user.ui.fragment.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // Initialize the HomeFragment
        HomeFragment homeFragment = new HomeFragment();

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // Navigate to the HomeFragment when MainActivity is initialized
        replaceFragment(homeFragment);

        // Check location permissions in onRequestLocationPermission
        onRequestLocationPermission();

        // App Toolbar navigation fries menu icon click listener
        binding.toolbar.setNavigationOnClickListener(v -> {

            // App Toolbar navigation icon
            binding.drawerLayout.openDrawer(GravityCompat.START);
        });

        // Appbar/Toolbar menu item click listener
        binding.toolbar.setOnMenuItemClickListener(item -> {

            // Check if the clicked item has the ID "menu_notification"
            if (item.getItemId() == R.id.menu_notification) {
                // Start a new activity by creating and launching an intent for the NotificationsActivity class.
                startActivity(new Intent(this, NotificationsActivity.class));
            }

            // Return "true" to indicate that the event has been handled and should not be further propagated.
            return true;
        });

        // Floating action button click listener
        binding.fabOrderHistory.setOnClickListener(v -> {

            // Handle my orders item click; Start my orders activity
            startActivity(new Intent(this, MyOrdersActivity.class));
        });

        // Disable curve bottom navigation nav_my_orders. Because, My Orders will replace when fabOrderHistory clicked
        binding.curveBottomNavigation.getMenu().findItem(R.id.nav_my_orders).setEnabled(false);

        // navigation view
        binding.navDrawerView.setNavigationItemSelectedListener(this);

        // Bottom navigation select listener
        binding.curveBottomNavigation.setOnItemSelectedListener(item -> {

            // Initialize item id
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {

                // Replace to HomeFragment
                replaceFragment(homeFragment);
                return true;

            } else if (itemId == R.id.nav_cashback) {

                // Replace to CashbackFragment
                replaceFragment(new CashbackFragment());
                return true;
            }
            return false;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Initialize menu item id
        int itemId = item.getItemId();

        // Handle navigation item clicks
        if (itemId == R.id.nav_profile) {

            // Handle profile item click; Start profile activity
            startActivity(new Intent(this, ProfileActivity.class));

        } else if (itemId == R.id.nav_my_orders) {

            // Handle my orders item click; Start my orders activity
            startActivity(new Intent(this, MyOrdersActivity.class));

        } else if (itemId == R.id.nav_logout) {

            // Handle profile item click
            Log.e("Info", "Logout");
        }

        // Close the drawer after handling the item click
        binding.drawerLayout.closeDrawer(GravityCompat.START);

        // Uncheck the selected item to disable its selection
        // item.setChecked(false);
        item.setCheckable(false);

        return true;
    }
}