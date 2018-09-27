package com.watchx.watchx.models;

import android.arch.persistence.room.Entity;


public class Friend {
    private String name;
    private String number;

    public Friend(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
