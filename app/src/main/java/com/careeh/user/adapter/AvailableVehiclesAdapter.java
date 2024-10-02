package com.careeh.user.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.careeh.user.R;
import com.careeh.user.model.VehicleInfo;

import java.util.List;

public class AvailableVehiclesAdapter extends RecyclerView.Adapter<AvailableVehiclesAdapter.ViewHolder> {

    private final List<VehicleInfo> vehicleInfoList;

    public AvailableVehiclesAdapter(List<VehicleInfo> vehicleInfoList) {
        this.vehicleInfoList = vehicleInfoList;
    }

    @NonNull
    @Override
    public AvailableVehiclesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.available_vehicles_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AvailableVehiclesAdapter.ViewHolder holder, int position) {
        VehicleInfo availableVehicle = vehicleInfoList.get(position);
        holder.bind(availableVehicle);
    }

    @Override
    public int getItemCount() {
        return vehicleInfoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivVehicleIcon;
        private final TextView tvVehicleName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivVehicleIcon = itemView.findViewById(R.id.iv_vehicle_icon);
            tvVehicleName = itemView.findViewById(R.id.tv_vehicle_name);
        }

        public void bind(VehicleInfo vehicleInfo) {
            ivVehicleIcon.setImageResource(vehicleInfo.getVehicleIcon());
            tvVehicleName.setText(vehicleInfo.getVehicleName());
        }
    }
}
