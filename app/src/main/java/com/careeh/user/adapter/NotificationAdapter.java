package com.careeh.user.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.careeh.user.R;
import com.careeh.user.model.NotificationModel;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private final List<NotificationModel> notificationList;

    public NotificationAdapter(List<NotificationModel> notificationList) {
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.ViewHolder holder, int position) {
        NotificationModel notification = notificationList.get(position);
        holder.bind(notification);
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvNotificationMsg;
        private final TextView tvNotificationTitle;
        private final TextView tvDate;
        private final TextView tvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNotificationMsg = itemView.findViewById(R.id.tv_notification_msg);
            tvNotificationTitle = itemView.findViewById(R.id.tv_notification_title);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvTime = itemView.findViewById(R.id.tv_time);
        }

        public void bind(NotificationModel notification) {

            tvNotificationMsg.setText(notification.getNotificationMsg());
            tvNotificationTitle.setText(notification.getNotificationTitle());
            tvDate.setText(notification.getNotificationDate());
            tvTime.setText(notification.getNotificationTime());
        }
    }
}
