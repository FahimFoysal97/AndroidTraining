package com.example.androidtraining.fragments.model;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int id;
    private boolean isActive;

    public Person() {

    }

    public Person(String name, int id, boolean isActive) {
        this.name = name;
        this.id = id;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nID: " + id +
                "\nActive: " + (isActive?"Yes":"No");
    }
}
