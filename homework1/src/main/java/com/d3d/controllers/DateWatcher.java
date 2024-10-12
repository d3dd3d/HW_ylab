package com.d3d.controllers;

import java.util.Date;

import com.d3d.domain.db.Data;
import com.d3d.domain.model.Habit;
import com.d3d.domain.model.HabitEntry;
import com.d3d.domain.model.User;

public class DateWatcher {
    public void watch(){
        Runnable task = () -> {
            Date currDate = new Date();
            while(true){
                try{
                    if(new Date()!=currDate){
                        for (User user : Data.getUserList().getList().values()) {
                            for (Habit habit : Data.getHabitList().find(user)) {
                                Data.getUserHistory().find(user).add(new HabitEntry(habit));
                            }
                        }
                    }
                }
                catch(Exception ex){

                }
            }
        };
        Thread dateWatcher = new Thread(task);
        dateWatcher.run();
    }
}
