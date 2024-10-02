package com.careeh.user.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.careeh.user.R;
import com.careeh.user.databinding.ActivitySearchLocationBinding;
import com.careeh.user.util.Constants;

public class SearchLocationActivity extends BaseActivity {

    /**
     * SearchLocationActivity will help user to search location to pick-up and drop-off
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflates the layout using data binding and initializes the binding object
        ActivitySearchLocationBinding binding = ActivitySearchLocationBinding.inflate(getLayoutInflater());

        // Creates an array of strings to store the labels for pick-up and drop-off locations
        String[] pickupDropOffLabels = {getString(R.string.pick_up_location_text), getString(R.string.where_to_text)};

        // Retrieves the search label index from the intent's extra data, with a fallback to a default index if not found
        int searchLabelIndex = getIntent().getIntExtra(Constants.SEARCH_LABEL_INDEX_KEY, Constants.DEF_SEARCH_LABEL_INDEX);

        // Sets the inflated layout as the content view for the activity
        setContentView(binding.getRoot());

        // Sets the hint for the location search bar based on the search label index
        binding.locationSearchBar.setHint(pickupDropOffLabels[searchLabelIndex]);

        // FAB button click listener
        binding.fabBack.setOnClickListener(v -> onBackPressed());

        binding.currentLocationSuggestion.setOnClickListener(v -> {

            // Start ConfirmLocationActivity (Map)
            startActivity(new Intent(this, ConfirmLocationActivity.class));
        });

        /*binding.pickupSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, String newQuery) {


                List<SearchSuggestion> suggestions = new ArrayList<>();
                // suggestions.add(new )

                binding.pickupSearchView.swapSuggestions(suggestions);
            }
        });*/
    }
}