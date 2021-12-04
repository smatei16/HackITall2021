package com.example.hackitall2021.Database;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class InputLoader {
    private final InputStream inputStream;

    public InputLoader(final InputStream inputPath) {
        this.inputStream = inputPath;
    }

    public String readData() {
        String json = null;
        try {
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer);
            JSONObject object = new JSONObject(json);
            JSONObject database = object.getJSONObject("database");
            JSONArray countries = database.getJSONArray("country");
            for(int i = 0; i < countries.length(); i++) {
                JSONObject country = countries.getJSONObject(i);
                return country.getString("name");
            }

        } catch (IOException  | JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
}
