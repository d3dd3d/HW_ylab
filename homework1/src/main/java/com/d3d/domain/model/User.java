package com.d3d.domain.model;

public class User {
    
    private String name;
    private String password;
    private String email;
    private boolean isBlocked;
    private boolean isAdmin;
   

    public User(String name, String password, String email, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
    public void setBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
