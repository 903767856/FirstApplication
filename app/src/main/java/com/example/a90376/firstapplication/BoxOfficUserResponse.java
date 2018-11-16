package com.example.a90376.firstapplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

;
public class BoxOfficUserResponse {
    List<User> user;
    public BoxOfficUserResponse()
    {
        user=new ArrayList<User>();
    }

    @SerializedName("User")
    List<User> userList;
    public static BoxOfficUserResponse parseJSON(String response) {
        Gson gson=new GsonBuilder().create();
        BoxOfficUserResponse boxOfficUserResponse=gson.fromJson(response,BoxOfficUserResponse.class);
        return boxOfficUserResponse;
    }
}