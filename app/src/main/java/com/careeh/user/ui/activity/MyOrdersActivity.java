package com.careeh.user.ui.activity;

import android.os.Bundle;

import com.careeh.user.R;
import com.careeh.user.adapter.MyOrdersPagerAdapter;
import com.careeh.user.databinding.ActivityMyOrdersBinding;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * <h1>This line of codes are working but deprecated</h1>
 * // Set up the ViewPager with an adapter TODO: This is working
 * MyOrdersPagerAdapter pagerAdapter = new MyOrdersPagerAdapter(getSupportFragmentManager());
 * binding.viewPagerMyOrders.setAdapter(pagerAdapter);
 * <p>
 * // Connect the TabLayout with the ViewPager
 * binding.tabLayoutMyOrders.setupWithViewPager(binding.viewPagerMyOrders);
 * <p>
 * // Set a listener to handle tab selection changes
 * binding.tabLayoutMyOrders.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
 *
 * @Override public void onTabSelected(TabLayout.Tab tab) {
 * // Switch to the selected tab
 * binding.viewPagerMyOrders.setCurrentItem(tab.getPosition());
 * }
 * @Override public void onTabUnselected(TabLayout.Tab tab) {
 * // Do nothing
 * }
 * @Override public void onTabReselected(TabLayout.Tab tab) {
 * // Do nothing
 * }
 * });
 * <p>
 * public class MyOrdersPagerAdapter extends FragmentPagerAdapter { // TODO: This is working
 * <p>
 * public MyOrdersPagerAdapter(FragmentManager fragmentManager) {
 * super(fragmentManager);
 * }
 * @Override public Fragment getItem(int position) {
 * // Return the appropriate fragment based on the tab position
 * switch (position) {
 * case 0:
 * return new OrderPendingFragment(); // Replace with your pending orders fragment
 * case 1:
 * return new OrderCompletedFragment(); // Replace with your completed orders fragment
 * case 2:
 * return new OrderCanceledFragment(); // Replace with your cancelled orders fragment
 * default:
 * return null;
 * }
 * }
 * @Override public int getCount() {
 * // Return the total number of tabs
 * return 3;
 * }
 * @Override public CharSequence getPageTitle(int position) {
 * // Return the title for each tab
 * switch (position) {
 * case 0:
 * return "Pending";
 * case 1:
 * return "Completed";
 * case 2:
 * return "Cancelled";
 * default:
 * return null;
 * }
 * }
 * }
 */

public class MyOrdersActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        ActivityMyOrdersBinding binding = ActivityMyOrdersBinding.inflate(getLayoutInflater());

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // Set appbar toolbar title
        binding.appbar.toolbar.setTitle(getString(R.string.my_orders));

        MyOrdersPagerAdapter myOrdersPagerAdapter = new MyOrdersPagerAdapter(this);
        binding.viewPagerMyOrders.setAdapter(myOrdersPagerAdapter);

        // Set the offscreen page limit to preload more fragments in advance
        binding.viewPagerMyOrders.setOffscreenPageLimit(2); // Set the number of pages to preload (change as needed)

        // Attach the TabLayout to the ViewPager
        new TabLayoutMediator(binding.tabLayoutMyOrders, binding.viewPagerMyOrders, (tab, position) -> {

            // Set the tab title based on the position
            switch (position) {
                case 0:
                    tab.setText(getString(R.string.pending));
                    break;
                case 1:
                    tab.setText(getString(R.string.completed));
                    break;
                case 2:
                    tab.setText(getString(R.string.canceled));
                    break;
            }
        }).attach();

        // App Toolbar navigation back icon click listener
        binding.appbar.toolbar.setNavigationOnClickListener(v -> {
            // App Toolbar navigation icon (back)
            onBackPressed();
        });
    }
}