package com.burelliercervo.androidpokeapi.model;

/**
 * Created by iem on 09/03/2018.
 */

public class User {
    private int userId;

    public User(int userId){
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
