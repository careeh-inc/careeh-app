package com.careeh.user.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.careeh.user.R;
import com.careeh.user.model.NotificationModel;

import java.util.ArrayList;
import java.util.List;

public class NotificationViewModel extends AndroidViewModel {

    MutableLiveData<List<NotificationModel>> notificationLiveData;

    public NotificationViewModel(@NonNull Application application) {
        super(application);
        notificationLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<NotificationModel>> getNotificationLiveData() {
        return notificationLiveData;
    }

    public void loadData() {
        notificationLiveData.setValue(getData());
    }

    private List<NotificationModel> getData() {

        Context context = getApplication().getApplicationContext();

        List<NotificationModel> notifications = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            notifications.add(new NotificationModel(
                    context.getString(R.string.dummy_notification_msg),
                    context.getString(R.string.dummy_notification_title),
                    context.getString(R.string.dummy_notification_date),
                    context.getString(R.string.dummy_notification_time)));
        }

        return notifications;
    }
}
