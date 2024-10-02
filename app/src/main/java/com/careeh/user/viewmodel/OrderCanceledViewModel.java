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

public class OrderCanceledViewModel extends AndroidViewModel {

    private final MutableLiveData<List<OrderHistoryModel>> orderCanceledLiveData;

    public OrderCanceledViewModel(@NonNull Application application) {
        super(application);
        orderCanceledLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<OrderHistoryModel>> getOrderCanceledLiveData() {
        return orderCanceledLiveData;
    }

    public void loadData() {
        orderCanceledLiveData.setValue(getData());
    }

    private List<OrderHistoryModel> getData() {

        // Get the application context
        Context context = getApplication().getApplicationContext();

        List<OrderHistoryModel> ordersHistory = new ArrayList<>();

        for (int i = 0; i < 2; i++) {

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