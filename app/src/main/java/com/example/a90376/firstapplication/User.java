package com.example.a90376.firstapplication;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    String userId;
    @SerializedName("password")
    String password;

    public User(String userId,String password)
    {
        this.userId=userId;
        this.password=password;
    }
    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }
}
