package com.d3d.domain.model;

import java.util.HashMap;

public class UserList {
    private HashMap<String,User> list;

    public UserList() {
        list = new HashMap<String, User>();
    }

    public HashMap<String, User> getList() {
        return list;
    }

    public void add(User user){
        list.put(user.getEmail(), user);
    }

    public User find(String userEmail){
        return list.get(userEmail);
    }
}
