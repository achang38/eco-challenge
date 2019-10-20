package com.example.hello_world;

public class User {
    public String name;
    public int score;

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }
};
