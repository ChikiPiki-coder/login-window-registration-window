package com.webapp.tamik.mywebappversion2spring.model;

public class Person {
    private String name;
    private String password;
private String status;

    @Override
    public String toString() {
        return name+" "+password+" "+status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
