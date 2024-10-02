package com.careeh.user.model;

public class NotificationModel {

    private String notificationMsg;
    private String notificationTitle;
    private String notificationDate;
    private String notificationTime;

    public NotificationModel(String notificationMsg, String notificationTitle, String notificationDate, String notificationTime) {
        this.notificationMsg = notificationMsg;
        this.notificationTitle = notificationTitle;
        this.notificationDate = notificationDate;
        this.notificationTime = notificationTime;
    }

    public String getNotificationMsg() {
        return notificationMsg;
    }

    public void setNotificationMsg(String notificationMsg) {
        this.notificationMsg = notificationMsg;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }
}
