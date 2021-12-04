package com.example.hackitall2021.Database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class InputLoader {
    private final String inputPath;

    public InputLoader(final String inputPath) {
        this.inputPath = inputPath;
    }

    public void readData() {
        JSONParser jsonParser = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(inputPath));
            JSONObject database = (JSONObject) jsonObject.get("database");
            JSONArray jsonCountries = (JSONArray) database.get("country");

            for(Object jsonCountry : jsonCountries) {

            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
