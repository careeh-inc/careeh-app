package com.careeh.user.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.careeh.user.ui.fragment.OrderCanceledFragment;
import com.careeh.user.ui.fragment.OrderCompletedFragment;
import com.careeh.user.ui.fragment.OrderPendingFragment;

public class MyOrdersPagerAdapter extends FragmentStateAdapter {

    public MyOrdersPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public int getItemCount() {
        return 3; // MyOrdersActivity have three tabs
    }

    /*@NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new OrderPendingFragment();
            case 1:
                return new OrderCompletedFragment();
            case 2:
                return new OrderCanceledFragment();
            default:
                throw new IllegalArgumentException("Invalid position: " + position);
        }
    }*/

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        if (position == 0) return new OrderPendingFragment();

        else if (position == 1) return new OrderCompletedFragment();

        else return new OrderCanceledFragment();
    }
}