package com.d3d.domain.model;

import java.util.ArrayList;
import java.util.HashMap;

public class HabitList {
    public HashMap<String,ArrayList<Habit>> list;

    public HabitList() {
        list = new HashMap<String,ArrayList<Habit>>();
    }

    public HashMap<String, ArrayList<Habit>> getList() {
        return list;
    }

    public void addUser(User user){
        list.put(user.getEmail(), new ArrayList<Habit>())
;    }

    public ArrayList<Habit> find(User user){
        return list.get(user.getEmail());
    }
}
