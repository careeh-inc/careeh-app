package com.careeh.user.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.careeh.user.R;
import com.careeh.user.adapter.NotificationsPagerAdapter;
import com.careeh.user.databinding.ActivityNotificationsBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class NotificationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout using the generated ActivityNotificationsBinding class and set it as the content view of the activity.
        ActivityNotificationsBinding binding = ActivityNotificationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Create an instance of NotificationsAdapter and set it as the adapter for the viewPagerNotifications.
        NotificationsPagerAdapter notificationsAdapter = new NotificationsPagerAdapter(this);
        binding.viewPagerNotifications.setAdapter(notificationsAdapter);

        // Set the offscreen page limit to 1 for viewPagerNotifications, which means only one adjacent page will be kept in memory.
        binding.viewPagerNotifications.setOffscreenPageLimit(1);

        // The mediator sets the tab text for each position based on the R.string values.
        new TabLayoutMediator(binding.tabLayoutNotifications, binding.viewPagerNotifications, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText(R.string.notification);
                    break;
                case 1:
                    tab.setText(R.string.promotion_title);
            }
        }).attach(); // Attach a TabLayoutMediator to synchronize the TabLayout and the ViewPager.

        // Set an onClickListener for the toolbar's navigation icon (if present) to handle the back navigation.
        binding.appbar.toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }
}