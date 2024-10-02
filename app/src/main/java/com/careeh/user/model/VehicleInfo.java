package com.careeh.user.model;

public class VehicleInfo {

    private int vehicleIcon;
    private String vehicleName;

    public VehicleInfo(int vehicleIcon, String vehicleName) {
        this.vehicleIcon = vehicleIcon;
        this.vehicleName = vehicleName;
    }

    public int getVehicleIcon() {
        return vehicleIcon;
    }

    public void setVehicleIcon(int vehicleIcon) {
        this.vehicleIcon = vehicleIcon;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
