package com.example.myapplication.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

@IgnoreExtraProperties
public class OnlineLibrary {
    public String libraryId;
    public String name;
    public String phoneNumber;
    public List<OrderRequest> orders;
    public List<OrderRequest> orderRequests;

    public OnlineLibrary(String libraryId, String name, String phoneNumber, List<OrderRequest> orders, List<OrderRequest> orderRequests) {
        this.libraryId = libraryId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
        this.orderRequests = orderRequests;
    }

}
