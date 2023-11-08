package com.example.myapplication.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Date;

@IgnoreExtraProperties
public class ConsultationResponse extends Message{
    public String responseText;
    public Date responseDate;
    public ConsultationRequest consultationRequest;
    public SleepConsultant sleepConsultant;

    public ConsultationResponse(String responseText, Date responseDate, ConsultationRequest consultationRequest, SleepConsultant sleepConsultant) {
        this.responseText = responseText;
        this.responseDate = responseDate;
        this.consultationRequest = consultationRequest;
        this.sleepConsultant = sleepConsultant;
    }

    public ConsultationResponse(String userName, String textMessage, String responseText, Date responseDate, ConsultationRequest consultationRequest, SleepConsultant sleepConsultant) {
        super(userName, textMessage);
        this.responseText = responseText;
        this.responseDate = responseDate;
        this.consultationRequest = consultationRequest;
        this.sleepConsultant = sleepConsultant;
    }
}
