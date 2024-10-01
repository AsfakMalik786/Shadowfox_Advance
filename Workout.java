package com.example.myapplication.Domain;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Workout implements Serializable {
    private String title;
    private String duration;
    private String description;
    private String durationAll;
    private String picPath;
    private int kcal;
    private ArrayList<Lessions> lessions;

    public Workout(String title, String duration, String description, String durationAll, String picPath, int kcal, ArrayList<Lessions> lessions) {
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.durationAll = durationAll;
        this.picPath = picPath;
        this.kcal = kcal;
        this.lessions = lessions;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDurationAll() {
        return durationAll;
    }

    public void setDurationAll(String durationAll) {
        this.durationAll = durationAll;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public ArrayList<Lessions> getLessions() {
        return lessions;
    }

    public void setLessions(ArrayList<Lessions> lessions) {
        this.lessions = lessions;
    }
}
