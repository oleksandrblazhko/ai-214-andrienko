package com.example.myapplication.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Date;

@IgnoreExtraProperties
public class Order {
    public String orderId;
    public String status;
    public Date startDate;

    public Order(String orderId, String status, Date startDate) {
        this.orderId = orderId;
        this.status = status;
        this.startDate = startDate;
    }
}
