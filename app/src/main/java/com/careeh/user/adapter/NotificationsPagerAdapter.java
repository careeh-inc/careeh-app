package com.careeh.user.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.careeh.user.ui.fragment.NotificationFragment;
import com.careeh.user.ui.fragment.PromotionFragment;

public class NotificationsPagerAdapter extends FragmentStateAdapter {

    public NotificationsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 0) return new NotificationFragment();

        else return new PromotionFragment();
    }

    @Override
    public int getItemCount() {
        return 2; // NotificationsActivity have two tabs
    }
}
