package com.careeh.user.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.careeh.user.R;
import com.careeh.user.model.OrderHistoryModel;

import java.util.ArrayList;
import java.util.List;

public class OrderCompletedViewModel extends AndroidViewModel {

    private final MutableLiveData<List<OrderHistoryModel>> orderCompletedLiveData;

    public OrderCompletedViewModel(@NonNull Application application) {
        super(application);
        orderCompletedLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<OrderHistoryModel>> getOrderCompletedLiveData() {
        return orderCompletedLiveData;
    }

    public void loadData() {
        orderCompletedLiveData.setValue(getData());
    }

    private List<OrderHistoryModel> getData() {

        // Get the application context
        Context context = getApplication().getApplicationContext();
        List<OrderHistoryModel> ordersHistory = new ArrayList<>();

        for (int i = 0; i < 7; i++) {

            ordersHistory.add(new OrderHistoryModel(
                    String.format(context.getString(R.string.gen_order_id), i + 1),
                    context.getString(R.string.dummy_date),
                    context.getString(R.string.dummy_pick_up_location),
                    context.getString(R.string.dummy_drop_off_location))
            );
        }
        return ordersHistory;
    }
}