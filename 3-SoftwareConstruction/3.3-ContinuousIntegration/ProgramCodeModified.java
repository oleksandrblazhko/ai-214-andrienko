package com.example.myapplication.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Book 
    public String bookId;
    public String title;
    public String author;
    public double price;

    public Book() { }

    public Book(String bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
