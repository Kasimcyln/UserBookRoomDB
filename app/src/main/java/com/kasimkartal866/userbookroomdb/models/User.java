package com.kasimkartal866.userbookroomdb.models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User {
    private String fName;
    private String lName;
    private String phone;

    public User (){ }
    @Ignore
    public User (String fName, String lName, String phone) {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;

    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    public  void setId(int id) {
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
