package com.example.hackitall2021.Database;

import java.io.Serializable;

public class Country implements Serializable {
    private int countryID;
    private String name;
    private double case_rate;
    private int newCases;
    private int newDeaths;
    private int avgCases;
    private int avgDeaths;
    private int level;

    public Country(int countryID, String name, double case_rate, int newCases, int newDeaths, int avgCases, int avgDeaths, int level) {
        this.countryID = countryID;
        this.name = name;
        this.case_rate = case_rate;
        this.newCases = newCases;
        this.newDeaths = newDeaths;
        this.avgCases = avgCases;
        this.avgDeaths = avgDeaths;
        this.level = level;
    }

    public int getCountryID() {
        return countryID;
    }

    public String getName() {
        return name;
    }

    public double getCase_rate() {
        return case_rate;
    }

    public int getNewCases() {
        return newCases;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public int getAvgCases() {
        return avgCases;
    }

    public int getAvgDeaths() {
        return avgDeaths;
    }

    public int getLevel() {
        return level;
    }
}
