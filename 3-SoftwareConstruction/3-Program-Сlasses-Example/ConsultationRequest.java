package com.example.myapplication.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Date;

@IgnoreExtraProperties
public class ConsultationRequest extends Message {
    public String problemDescription;
    public Date creationDate;
    public User user;
    public SleepConsultant sleepConsultant;

    public ConsultationRequest(String problemDescription, Date creationDate, User user, SleepConsultant sleepConsultant) {
        this.problemDescription = problemDescription;
        this.creationDate = creationDate;
        this.user = user;
        this.sleepConsultant = sleepConsultant;
    }

    public ConsultationRequest(String userName, String textMessage, String problemDescription, Date creationDate, User user, SleepConsultant sleepConsultant) {
        super(userName, textMessage);
        this.problemDescription = problemDescription;
        this.creationDate = creationDate;
        this.user = user;
        this.sleepConsultant = sleepConsultant;
    }


}
