package com.careeh.user.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.careeh.user.R;
import com.careeh.user.model.OrderHistoryModel;

import java.util.List;

public class OrdersHistoryAdapter extends RecyclerView.Adapter<OrdersHistoryAdapter.ViewHolder> {

    private final List<OrderHistoryModel> orderHistoryList;
    private final OnItemClickListener listener;

    public OrdersHistoryAdapter(List<OrderHistoryModel> orderHistoryList, OnItemClickListener listener) {
        this.orderHistoryList = orderHistoryList;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(OrderHistoryModel orderHistory, int position);
    }

    @NonNull
    @Override
    public OrdersHistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersHistoryAdapter.ViewHolder holder, int position) {
        OrderHistoryModel orderHistory = orderHistoryList.get(position);
        holder.bind(orderHistory, listener, position);
    }

    @Override
    public int getItemCount() {
        return orderHistoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvOrderId;
        private final TextView tvDate;
        private final TextView tvPickUpLocation;
        private final TextView tvDropOffLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOrderId = itemView.findViewById(R.id.tv_order_id);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvPickUpLocation = itemView.findViewById(R.id.tv_pick_up_location);
            tvDropOffLocation = itemView.findViewById(R.id.tv_drop_off_location);
        }

        public void bind(OrderHistoryModel orderHistory, OnItemClickListener listener, int position) {

            tvOrderId.setText(orderHistory.getOrderId());
            tvDate.setText(orderHistory.getOrderDate());
            tvPickUpLocation.setText(orderHistory.getPickUpLocation());
            tvDropOffLocation.setText(orderHistory.getDropOffLocation());

            // RecyclerView item click listener
            itemView.setOnClickListener(v -> {
                // Pass values in onItemClick
                listener.onItemClick(orderHistory, position);
            });
        }
    }
}
