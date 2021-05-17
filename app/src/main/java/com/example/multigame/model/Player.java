package com.example.multigame.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Player {

    @NonNull
    @PrimaryKey
    private String name;
    private String picture;
    private String firstName;
    private int age;
    private String localisation;
    private int dragScore;
    private int tapScore;
    private int swipeScore;

    public Player(String picture, String name, String firstName, int age, String localisation){
        setPicture(picture);
        setName(name);
        setFirstName(firstName);
        setAge(age);
        setLocalisation(localisation);
        setDragScore(0);
        setSwipeScore(0);
        setTapScore(0);
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDragScore(int score) {this.dragScore = score;}

    public int getDragScore(){return this.dragScore;}

    public void setTapScore(int score) {this.tapScore = score;}

    public int getTapScore(){return this.tapScore;}

    public void setSwipeScore(int score) {this.swipeScore = score;}

    public int getSwipeScore(){return this.swipeScore;}
}
