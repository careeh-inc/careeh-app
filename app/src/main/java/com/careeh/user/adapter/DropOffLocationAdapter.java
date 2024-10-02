package com.careeh.user.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.careeh.user.R;
import com.careeh.user.model.DropOffLocation;

import java.util.List;

public class DropOffLocationAdapter extends RecyclerView.Adapter<DropOffLocationAdapter.ViewHolder> {

    private final List<DropOffLocation> dropOffLocations;
    private final OnItemClickListener listener;

    public DropOffLocationAdapter(List<DropOffLocation> dropOffLocations, OnItemClickListener listener) {
        this.dropOffLocations = dropOffLocations;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(DropOffLocation item, int position);

        void onCloseClick(int position);
    }

    @NonNull
    @Override
    public DropOffLocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drop_off_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DropOffLocationAdapter.ViewHolder holder, int position) {
        DropOffLocation dropOffLocation = dropOffLocations.get(position);
        holder.bind(dropOffLocation, listener, position);
    }

    @Override
    public int getItemCount() {
        return dropOffLocations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvDropOffLocation;
        private final ImageButton btnClose;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDropOffLocation = itemView.findViewById(R.id.tv_drop_off_location);
            btnClose = itemView.findViewById(R.id.btn_close);
        }

        public void bind(DropOffLocation dropOffLocation, OnItemClickListener listener, int position) {
            tvDropOffLocation.setText(dropOffLocation.getAddressLine());

            btnClose.setOnClickListener(v -> {
                // Item close button click listener
                listener.onCloseClick(position);
            });

            // RecyclerView item click listener
            itemView.setOnClickListener(v -> {
                // Pass values in onItemClick
                listener.onItemClick(dropOffLocation, position);
            });
        }
    }
}
