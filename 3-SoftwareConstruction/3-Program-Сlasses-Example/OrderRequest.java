package com.example.myapplication.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Date;
import java.util.List;

@IgnoreExtraProperties
public class OrderRequest {
    public String requestId;
    public Date creationDate;
    public double price;
    public User user;
    public OnlineLibrary onlineLibrary;
    public List<Book> books;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OnlineLibrary getOnlineLibrary() {
        return onlineLibrary;
    }

    public void setOnlineLibrary(OnlineLibrary onlineLibrary) {
        this.onlineLibrary = onlineLibrary;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
