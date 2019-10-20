package com.example.hello_world;

public class User {
    public String name;
    public int dailyScore;
    public int totalScore;

    public User(){}

    public User(String name, int dailyScore, int totalScore) {
        this.name = name;
        this.dailyScore = dailyScore;
        this.totalScore = totalScore;
    }

    public String getName(){
        return name;
    }

    public int getDailyScore(){
        return dailyScore;
    }

    public int getTotalScore(){
        return totalScore;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setDailyScore(int s){
        this.dailyScore = s;
    }

    public void setTotalScore(int s){
        this.totalScore = s;
    }
};
