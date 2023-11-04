package com.example.myapplication.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserInformation {
    public int age;
    public String fullName;

    public UserInformation(int age, String fullName) {
        this.age = age;
        this.fullName = fullName;
    }
}
