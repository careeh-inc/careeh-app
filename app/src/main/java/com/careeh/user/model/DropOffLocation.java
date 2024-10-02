package com.careeh.user.model;

public class DropOffLocation {

    private String addressLine;

    public DropOffLocation(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
}
