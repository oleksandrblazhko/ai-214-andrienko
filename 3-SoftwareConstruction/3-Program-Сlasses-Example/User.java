package com.example.myapplication.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

@IgnoreExtraProperties
public class User {
    public String userId;
    public String login;
    public String password;
    public String email;
    public UserInformation userInformation;
    public List<OrderRequest> orderRequests;
    public List<ConsultationRequest> consultationRequests;
    public List<ConsultationResponse> consultationResponses;

    public User(String userId, String login, String password, String email, UserInformation userInformation, List<OrderRequest> orderRequests, List<ConsultationRequest> consultationRequests, List<ConsultationResponse> consultationResponses) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.email = email;
        this.userInformation = userInformation;
        this.orderRequests = orderRequests;
        this.consultationRequests = consultationRequests;
        this.consultationResponses = consultationResponses;
    }
}

