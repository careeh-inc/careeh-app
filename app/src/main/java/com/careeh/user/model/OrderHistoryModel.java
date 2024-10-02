package com.careeh.user.model;

public class OrderHistoryModel {

    private String orderId;
    private String orderDate;
    private String pickUpLocation;
    private String dropOffLocation;

    public OrderHistoryModel(String orderId, String orderDate, String pickUpLocation, String dropOffLocation) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }
}
