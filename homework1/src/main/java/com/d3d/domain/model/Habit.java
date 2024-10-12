package com.d3d.domain.model;

import java.util.Date;

public class Habit {
    private String name;
    private String userMail;
    private String description;
    private Regularity regularity;
    private Date dateCreation;
    private boolean isActive;

    public Habit(String name, String userMail, String description, Regularity regularity) {
        this.name = name;
        this.userMail = userMail;
        this.description = description;
        this.regularity = regularity;
        this.dateCreation = new Date();
        this.isActive = true;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserMail() {
        return userMail;
    }
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Regularity getRegularity() {
        return regularity;
    }
    public void setRegularity(Regularity regularity) {
        this.regularity = regularity;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
