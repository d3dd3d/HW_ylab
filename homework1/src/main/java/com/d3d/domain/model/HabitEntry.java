package com.d3d.domain.model;

import java.util.Date;

public class HabitEntry {
    private String habitName;
    private String userMail;
    private boolean isDone;
    private Date dateHabit;

    public HabitEntry(String habitName, String userMail) {
        this.habitName = habitName;
        this.userMail = userMail;
        this.isDone = false;
        this.dateHabit = new Date();
    }

    public HabitEntry(Habit habit) {
        this.habitName = habit.getName();
        this.userMail = habit.getUserMail();
        this.isDone = false;
        this.dateHabit = new Date();
    }

    public String habitName() {
        return habitName;
    }

    public void sethabitId(String habitName) {
        this.habitName = habitName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public Date getDateHabit() {
        return dateHabit;
    }
}
