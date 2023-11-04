package com.example.myapplication.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

@IgnoreExtraProperties
public class SleepConsultant extends User {
    public String experience;
    public int rating;
    public List<ConsultationRequest> consultationRequests;
    public List<ConsultationResponse> consultationResponses;

    public SleepConsultant(String experience, int rating, List<ConsultationRequest> consultationRequests, List<ConsultationResponse> consultationResponses) {
        this.experience = experience;
        this.rating = rating;
        this.consultationRequests = consultationRequests;
        this.consultationResponses = consultationResponses;
    }
}
