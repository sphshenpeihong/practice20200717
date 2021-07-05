package com.sph.practice.test.serialization.dto.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bean {
    private String name;

    private int[] stature;

    private Friend friend;

    private ArrayList<String> song;

    private Map<String, Integer> score = new HashMap<String, Integer>();

    public Bean(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setStature(int[] stature) {
        this.stature = stature;
    }

    public int[] getStature() {
        return this.stature;
    }

    public void setSong(ArrayList<String> song) {
        this.song = song;
    }

    public ArrayList<String> getSong() {
        return this.song;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    public Friend getFriend() {
        return this.friend;
    }

    public void addScore(String subject, Integer score) {
        this.score.put(subject, score);
    }

    public Map getScore() {
        return this.score;
    }
}

