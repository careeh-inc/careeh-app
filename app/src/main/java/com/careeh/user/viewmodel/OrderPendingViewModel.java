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

public class OrderPendingViewModel extends AndroidViewModel {

    private final MutableLiveData<List<OrderHistoryModel>> orderHistoryLiveData;

    public OrderPendingViewModel(@NonNull Application application) {
        super(application);
        orderHistoryLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<OrderHistoryModel>> getOrderHistoryLiveData() {
        return orderHistoryLiveData;
    }

    public void loadData() {
        orderHistoryLiveData.setValue(getData());
    }

    private List<OrderHistoryModel> getData() {

        // Get the application context
        Context context = getApplication().getApplicationContext();
        List<OrderHistoryModel> ordersHistory = new ArrayList<>();

        for (int i = 0; i < 4; i++) {

            ordersHistory.add(new OrderHistoryModel(
                    String.format(context.getString(R.string.gen_order_id), i+1),
                    context.getString(R.string.dummy_date),
                    context.getString(R.string.dummy_pick_up_location),
                    context.getString(R.string.dummy_drop_off_location))
            );
        }
        return ordersHistory;
    }
}
