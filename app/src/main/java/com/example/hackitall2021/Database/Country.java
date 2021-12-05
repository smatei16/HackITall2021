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
    private double aqi;
    private int temperature;
    private String description;
    private double pressure;
    private int humidity;
    private String capital;

    public Country(int countryID, String name, double case_rate, int newCases, int newDeaths,
                   int avgCases, int avgDeaths, int level, double aqi,
                   int temperature, String description, double pressure, int humidity, String capital) {
        this.countryID = countryID;
        this.name = name;
        this.case_rate = case_rate;
        this.newCases = newCases;
        this.newDeaths = newDeaths;
        this.avgCases = avgCases;
        this.avgDeaths = avgDeaths;
        this.level = level;
        this.aqi = aqi;
        this.temperature = temperature;
        this.description = description;
        this.pressure = pressure;
        this.humidity = humidity;
        this.capital = capital;
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

    public double getAqi() {
        return aqi;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getCapital() {
        return capital;
    }
}
