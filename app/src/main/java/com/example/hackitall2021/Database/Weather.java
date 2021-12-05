package com.example.hackitall2021.Database;

import java.io.Serializable;

public class Weather implements Serializable {
    private String description;
    private double temp;
    private double tempMin;
    private double tempMax;
    private int pressure;
    private int humidity;

    public Weather(String description, double temp, double tempMin, double tempMax, int pressure, int humidity) {
        this.description = description;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public String getDescription() {
        return description;
    }

    public double getTemp() {
        return temp;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
