package com.example.daan.fortnitestats.models;

public class Stat implements Comparable<Stat> {

    private String title;
    private String value;

    public Stat(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(Stat compareStat) {
        return this.getTitle().compareTo(compareStat.getTitle());
    }
}
