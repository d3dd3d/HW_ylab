package com.d3d.domain.model;

import java.util.ArrayList;
import java.util.HashMap;

public class UserHistory {
    private HashMap<String,ArrayList<HabitEntry>> list;

    public UserHistory() {
        list = new HashMap<String,ArrayList<HabitEntry>>();
    }

    public HashMap<String, ArrayList<HabitEntry>> getList() {
        return list;
    }

    public void addUser(User user){
        list.put(user.getEmail(), new ArrayList<HabitEntry>());
    }

    public ArrayList<HabitEntry> find(User user){
        return list.get(user.getEmail());
    }

}
