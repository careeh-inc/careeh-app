package com.careeh.user.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.careeh.user.R;

import java.util.ArrayList;
import java.util.List;

public class PromotionViewModel extends AndroidViewModel {

    MutableLiveData<List<String>> promotions;

    public PromotionViewModel(@NonNull Application application) {
        super(application);
        promotions = new MutableLiveData<>();
    }

    public MutableLiveData<List<String>> getPromotions() {
        return promotions;
    }

    public void loadData() {
        promotions.setValue(getData());
    }

    private List<String> getData() {

        Context context = getApplication().getApplicationContext();

        List<String> promotions = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            promotions.add(context.getString(R.string.dummy_promotion));
        }
        return promotions;
    }
}
