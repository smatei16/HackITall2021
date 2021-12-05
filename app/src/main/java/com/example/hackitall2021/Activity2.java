package com.example.hackitall2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.example.hackitall2021.Database.Country;
import com.example.hackitall2021.Database.CountryListAdapter;
import com.example.hackitall2021.Database.InputLoader;

import java.io.IOException;
import java.io.InputStream;

public class Activity2 extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextViewCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init();
        loadData();
    }

    private void init() {
        autoCompleteTextViewCountry = findViewById(R.id.autoCompleteTextViewCountry);
    }

    private void loadData() {
        //autoCompleteTextViewCountry.setHint(getText(R.string.search_country));
        //autoCompleteTextViewCountry.setThreshold(1);
        try {
            InputStream inputStream = getAssets().open("database.json");
            InputLoader inputLoader = new InputLoader(inputStream);
            inputLoader.readData();

            CountryListAdapter adapter = new CountryListAdapter(getApplicationContext(), inputLoader.getCountriesList());
            autoCompleteTextViewCountry.setAdapter(adapter);
            autoCompleteTextViewCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    autoCompleteTextViewCountry_onItemClick(adapterView, view, position, id);
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void autoCompleteTextViewCountry_onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Country country = (Country) adapterView.getItemAtPosition(position);
        autoCompleteTextViewCountry.setText(country.getName());
        //textViewId.setText(product.getId());
        //textViewName.setText(product.getName());
        //textViewPrice.setText(String.valueOf(product.getPrice()));
        //textViewDescription.setText(product.getDescription());
        //imageViewPhoto.setImageResource(product.getPhoto());
    }
}